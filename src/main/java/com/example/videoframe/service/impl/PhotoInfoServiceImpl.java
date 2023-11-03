package com.example.videoframe.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.videoframe.common.VideoInfoCommon;
import com.example.videoframe.entity.Fileupload;
import com.example.videoframe.entity.Photoinfo;
import com.example.videoframe.entity.Videoinfo;
import com.example.videoframe.mapper.FileuploadMapper;
import com.example.videoframe.mapper.PhotoinfoMapper;
import com.example.videoframe.mapper.VideoinfoMapper;
import com.example.videoframe.mapper.example.FileuploadExample;
import com.example.videoframe.mapper.example.PhotoinfoExample;
import com.example.videoframe.mapper.example.VideoinfoExample;
import com.example.videoframe.service.PhotoInfoService;
import com.example.videoframe.util.FfmpegUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.List;

/**
 * @Author: `sujinwang`
 * @Date: `2023/10/30 15:35`
 * @Version: 1.0
 * @Description:
 */
@Slf4j
@Service
public class PhotoInfoServiceImpl implements PhotoInfoService {

    @Autowired
    private PhotoinfoMapper photoinfoMapper;

    @Autowired
    private VideoinfoMapper videoinfoMapper;

    @Autowired
    private FileuploadMapper fileuploadMapper;

    @Value("${file.videoPhotoFolder}")
    private String videoPhotoFolder;

    @Value("${file.accuracy}")
    private String accuracy;


    @Override
    public void splitVideo() {

        // 获取需要处理的视频文件
        VideoinfoExample videoinfoExample = new VideoinfoExample();
        VideoinfoExample.Criteria criteria = videoinfoExample.createCriteria();
        criteria.andStatusEqualTo(VideoInfoCommon.VIDEO_STATUS_FAIL);

        // 视频文件开始处理
        log.info("开始处理视频文件");
        String format = DateUtil.format(new Date(), "yyyyMMdd");

        List<Videoinfo> videoinfos = videoinfoMapper.selectByExample(videoinfoExample);
        for (Videoinfo videoinfo : videoinfos) {
            try {
                String sta = PhotoInfoServiceImpl.class.getClassLoader().getResource("").getPath();
                String ffmepg = sta + "static/ffmpeg";


                FileuploadExample fileuploadExample = new FileuploadExample();
                FileuploadExample.Criteria criteria1 = fileuploadExample.createCriteria();
                criteria1.andAttachGroupIdEqualTo(videoinfo.getAttachgroupid());
                List<Fileupload> fileuploads = fileuploadMapper.selectByExample(fileuploadExample);
                Fileupload fileupload = fileuploads.get(0);
                String mp4 = fileupload.getUrl();
                // 获取随机id
                String simpleUUID = IdUtil.simpleUUID();

                String output = videoPhotoFolder + format + "/" + simpleUUID;
                log.info(output);

                File file = new File(output);
                if (!file.exists()) {
                    file.mkdirs();
                }
                // 分解视频
                FfmpegUtil.getVideoCover2(ffmepg, mp4, output + "/image-%d.jpeg", accuracy);

                // 统计文件，并存入数据库中
                if(delayPhotoFile(file, output, videoinfo, fileupload)) {
                    // 如果都成功了，那么videoinfo都状态要变成1
                    videoinfo.setStatus(VideoInfoCommon.VIDEO_STATUS_SUCCESS);
                    videoinfoMapper.updateByPrimaryKeySelective(videoinfo);
                }
            } catch (Exception e) {
                log.error("视频文件处理失败groupid: {}", videoinfo.getAttachgroupid());
                log.error("", e);
            }

        }





    }

    @Override
    public List<Photoinfo> showPhotoInfoByVideoInfoId(Photoinfo photoinfo) {
        PhotoinfoExample photoinfoExample = new PhotoinfoExample();
        PhotoinfoExample.Criteria criteria = photoinfoExample.createCriteria();
        criteria.andVideoinfoidEqualTo(photoinfo.getVideoinfoid());

        List<Photoinfo> photoinfos = photoinfoMapper.selectByAtt(photoinfo);
        return photoinfos;
    }

    private boolean delayPhotoFile(File file, String output, Videoinfo videoinfo, Fileupload fileupload) {
        File[] files = file.listFiles();
        log.info("共分解出照片数目：{}", files.length);
        for (File f : files) {
            String name = f.getName();

            Fileupload fileuploa = new Fileupload();
            fileuploa.setCreatetime(new Date());
            fileuploa.setName(name);
            fileuploa.setProfilx(".jpeg");
            fileuploa.setType("image/jpeg");
            fileuploa.setUrl(output+"/"+name);
            fileuploa.setAttachGroupId(IdUtil.simpleUUID());
            int insert = fileuploadMapper.insert(fileuploa);
            if (insert!=1) {
                log.error("剪切图片插入数据库失败groupid: {}", videoinfo.getAttachgroupid());
                return false;
            }

            Photoinfo photoinfo = new Photoinfo();
            photoinfo.setName(name);
            photoinfo.setAttachGroupId(fileuploa.getAttachGroupId());
            photoinfo.setVideoinfoid(videoinfo.getId());
            if (photoinfoMapper.insert(photoinfo)!=1) {
                log.error("剪切图片插入photoinfo数据库失败 groupid: {}", videoinfo.getAttachgroupid());
                return false;
            }
            if ("image-1.jpeg".equals(name)) {
                videoinfo.setAttgroupid1(fileuploa.getAttachGroupId());
            }
        }
        return true;
    }

}
