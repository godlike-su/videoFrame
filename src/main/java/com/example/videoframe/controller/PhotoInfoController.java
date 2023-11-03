package com.example.videoframe.controller;

import com.example.videoframe.entity.Photoinfo;
import com.example.videoframe.fo.PhotoinfoFO;
import com.example.videoframe.fo.VideoinfoFO;
import com.example.videoframe.service.PhotoInfoService;
import com.example.videoframe.util.ObjectTransform;
import com.example.videoframe.webreturn.result.BaseResult;
import com.example.videoframe.webreturn.result.ListResult;
import com.example.videoframe.webreturn.result.SingleResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: `sujinwang`
 * @Date: `2023/10/30 15:45`
 * @Version: 1.0
 * @Description:
 */
@RestController
@Tag(name = "视频文件分解")
@RequestMapping("/photoInfo")
public class PhotoInfoController {

    @Autowired
    private PhotoInfoService photoInfoService;

    @Operation(summary = "视频文件分解成照片")
    @PostMapping("splitVideo")
    public BaseResult splitVideo() {
        photoInfoService.splitVideo();
        return new BaseResult();
    }

    @Operation(summary = "根据videoInfoId寻找照片")
    @PostMapping("showPhotoInfoByVideoInfoId")
    public ListResult<Photoinfo> showPhotoInfoByVideoInfoId(@RequestBody PhotoinfoFO photoinfoFO) {
        Photoinfo transform = ObjectTransform.transform(photoinfoFO, Photoinfo.class);
        List<Photoinfo> photoinfos = photoInfoService.showPhotoInfoByVideoInfoId(transform);
        ListResult<Photoinfo> objectListResult = new ListResult<>();
        objectListResult.setData(photoinfos);
        return objectListResult;
    }


}
