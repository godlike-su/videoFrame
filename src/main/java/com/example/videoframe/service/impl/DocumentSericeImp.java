package com.example.videoframe.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.videoframe.entity.Fileupload;
import com.example.videoframe.exception.BaseException;
import com.example.videoframe.exception.DataNullException;
import com.example.videoframe.exception.GenerallyeException;
import com.example.videoframe.exception.ParamerException;
import com.example.videoframe.mapper.FileuploadMapper;
import com.example.videoframe.mapper.example.FileuploadExample;
import com.example.videoframe.service.DocumentService;
import com.example.videoframe.util.UrlParse;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: `sujinwang`
 * @Date: `2023/10/30 01:18`
 * @Version: 1.0
 * @Description:
 */
@Slf4j
@Service
public class DocumentSericeImp implements DocumentService {

    private static final String TMP_URL = "tmp/";
    @Value("${file.uploadFolder}")
    private String absoluteUrl;

    @Autowired
    private FileuploadMapper fileuploadMapper;

    @Override
    public String uploadVideoFile(MultipartFile file) {
        try {
            String format = DateUtil.format(new Date(), "yyyyMMdd");
            if (file.isEmpty()) {
                return "上传视频，请选择文件";
            }
            StringBuilder filePath = new StringBuilder();
            filePath.append(absoluteUrl).append("video/").append(format).append("/");
            // 获取文件类型
            String mimeType = Optional.ofNullable(file.getContentType()).orElse("");

            // 获取文件后缀
            String fileName = Optional.ofNullable(file.getOriginalFilename()).orElse("");
            String profilx = "";
            // 获取文件名后缀 .jpg .png
            int i = fileName.lastIndexOf(".");
            if (i != -1) {
                profilx = fileName.substring(i);
            }
            if (!".mp4".equals(profilx)) {
                throw new BaseException("只能上传mp4后缀文件");
            }
            // 获取随机id
            String simpleUUID = IdUtil.simpleUUID();

            //  先将文件存到临时文件夹
            String tmpFileParentUrl = filePath.toString();
            File tmpUplod = new File(tmpFileParentUrl);
            if (!tmpUplod.exists()) {
                tmpUplod.mkdirs();
            }
            String tmpFileUrl = tmpFileParentUrl + simpleUUID + profilx;
            File tmpFile = new File(tmpFileUrl);
            log.info("tmpFile文件路径{}", tmpFile.getAbsoluteFile());
            file.transferTo(tmpFile.getAbsoluteFile());

            Fileupload fileInformation = new Fileupload();
            fileInformation.setUrl(tmpFileParentUrl + simpleUUID + profilx);
            fileInformation.setName(fileName);
            fileInformation.setAttachGroupId(simpleUUID);
            fileInformation.setCreatetime(new Date());
            fileInformation.setProfilx(profilx);
            fileInformation.setType(mimeType);
            // 存入数据库
            fileuploadMapper.insert(fileInformation);

            return fileInformation.getAttachGroupId();
        } catch (Exception e) {
            log.error("文件出错", e);
            throw new GenerallyeException("上传文件错误");
        }
    }

    @Override
    public String uploadPhotoFile(MultipartFile file, String used) {
        return null;
    }

    @Override
    public void downloadFile(String attachGroupId, HttpServletResponse response) {
    }

    @Override
    public void downloadFileByImage(String attachGroupId, HttpServletResponse response) {
        // 根据文件id查找文件信息
        FileuploadExample fileuploadExample = new FileuploadExample();
        FileuploadExample.Criteria criteria = fileuploadExample.createCriteria();
        criteria.andAttachGroupIdEqualTo(attachGroupId);
        List<Fileupload> fileuploads = fileuploadMapper.selectByExample(fileuploadExample);
        if (ObjectUtils.isEmpty(fileuploads)) {
            throw new ParamerException("查找不到该文件！");
        }
        Fileupload fileupload = fileuploads.get(0);
        File file = new File( fileupload.getUrl());
        if (!file.exists()) {
            throw new DataNullException("该文件不存在！");
        }

        String filename = filenameEncoding(fileupload.getName());
        // 告知浏览器文件的大小
        response.addHeader("Content-Length", "" + file.length());
        // 设置对应文件的头文件
        UrlParse urlParse = new UrlParse();
        String suffix = urlParse.urlSuffix(filename);
        response.setContentType(urlParse.getContentType(suffix));
        response.addHeader("Content-Disposition", "attachment;fileName=" + filename);
        response.addHeader("Pargam", "no-cache");
        response.addHeader("Cache-Control", "no-cache");
        byte[] buffer = new byte[1024];
        try (FileInputStream fis = new FileInputStream(file);
             BufferedInputStream bis = new BufferedInputStream(fis)) {
            OutputStream os = response.getOutputStream();

            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            log.error("下载文件出错:", e);
            throw new GenerallyeException("下载文件出错!");
        }

    }

    /**
     * 文件名解析
     *
     * @param fileName 文件名
     * @return {@link String}
     */
    public String filenameEncoding(String fileName) {
        try {
            return URLEncoder.encode(fileName, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new GenerallyeException("解析文件名出错!");
        }

    }

    private void fileModelVertify(String mimeTyp) {
        boolean equals = mimeTyp.equals("image/jpeg") || mimeTyp.equals("image/png") || mimeTyp.equals("video/mp4")
                || mimeTyp.equals("image/gif");
        if (!equals) {
            throw new GenerallyeException("文件只允许jpg、jpeg、gif、mp4上传。 mineType错误: " + mimeTyp);
        }
    }
}
