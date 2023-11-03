package com.example.videoframe.service;

import com.example.videoframe.entity.Photoinfo;

import java.util.List;

/**
 * @Author: `sujinwang`
 * @Date: `2023/10/30 15:35`
 * @Version: 1.0
 * @Description:
 */
public interface PhotoInfoService {

    void splitVideo();

    List<Photoinfo> showPhotoInfoByVideoInfoId(Photoinfo photoinfo);

}
