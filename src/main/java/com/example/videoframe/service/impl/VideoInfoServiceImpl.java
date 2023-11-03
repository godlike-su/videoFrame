package com.example.videoframe.service.impl;

import com.example.videoframe.common.VideoInfoCommon;
import com.example.videoframe.entity.Videoinfo;
import com.example.videoframe.mapper.VideoinfoMapper;
import com.example.videoframe.mapper.example.VideoinfoExample;
import com.example.videoframe.service.VideoInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Author: `sujinwang`
 * @Date: `2023/10/30 14:18`
 * @Version: 1.0
 * @Description:
 */
@Slf4j
@Service
public class VideoInfoServiceImpl implements VideoInfoService {

    @Autowired
    private VideoinfoMapper videoinfoMapper;

    @Override
    public int addVideoInfo(Videoinfo videoinfo) {
        // 上传视频
        videoinfo.setStatus(VideoInfoCommon.VIDEO_STATUS_FAIL);
        videoinfo.setCreatetime(new Date());
        return videoinfoMapper.insert(videoinfo);
    }

    @Override
    public List<Videoinfo> showVideoInfoList(Videoinfo videoinfo) {
        VideoinfoExample videoinfoExample = new VideoinfoExample();
        VideoinfoExample.Criteria criteria = videoinfoExample.createCriteria();
        criteria.andUserinfoidEqualTo(videoinfo.getUserinfoid());

        return videoinfoMapper.selectByExample(videoinfoExample);
    }
}
