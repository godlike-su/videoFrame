package com.example.videoframe.service;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Author: `sujinwang`
 * @Date: `2022/3/3 14:19`
 * @Version: 1.0
 * @Description:
 */
public interface DocumentService {

    /**
     * 上传文件
     *
     * @return {@link String}
     */
    String uploadVideoFile(MultipartFile file);

    String uploadPhotoFile(MultipartFile file, String used);

    /**
     * 下载文件
     *
     * @param attachGroupId
     * @param response
     */
    void downloadFile(String attachGroupId, HttpServletResponse response);

    /**
     * 下载文件，图片形式
     *
     * @param attachGroupId
     * @param response
     */
    void downloadFileByImage(String attachGroupId, HttpServletResponse response);


    /**
     * cleard文件
     *
     * @param fo
     * @return int
     */
//    int cleardFile(DownloadFileFo fo);

}
