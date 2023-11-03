package com.example.videoframe.service;

import com.example.videoframe.entity.Videoinfo;

import java.util.List;

/**
 * @Author: `sujinwang`
 * @Date: `2023/10/30 14:18`
 * @Version: 1.0
 * @Description:
 */
public interface VideoInfoService {

    int addVideoInfo(Videoinfo videoinfo);

    List<Videoinfo> showVideoInfoList(Videoinfo videoinfo);

}
