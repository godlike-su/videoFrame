package com.example.videoframe.controller;

import com.example.videoframe.entity.Videoinfo;
import com.example.videoframe.fo.VideoinfoFO;
import com.example.videoframe.service.VideoInfoService;
import com.example.videoframe.util.ObjectTransform;
import com.example.videoframe.webreturn.result.ListResult;
import com.example.videoframe.webreturn.result.MessageResult;
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
 * @Date: `2023/10/30 14:17`
 * @Version: 1.0
 * @Description:
 */
@RestController
@Tag(name = "视频操作")
@RequestMapping("/videoInfo")
public class VideoInfoController {

    @Autowired
    private VideoInfoService videoInfoService;

    @Operation(description = "确定上传用户视频")
    @PostMapping("addVideoInfo")
    public MessageResult addVideoInfo(@RequestBody VideoinfoFO videoinfoFO) {
        Videoinfo transform = ObjectTransform.transform(videoinfoFO, Videoinfo.class);
        videoInfoService.addVideoInfo(transform);
        return new MessageResult("创建用户视频成功");
    }

    @Operation(summary = "根据条件查找对应的视频")
    @PostMapping("showVideoInfoList")
    public ListResult<Videoinfo> showVideoInfoList(@RequestBody VideoinfoFO videoinfoFO) {
        Videoinfo transform = ObjectTransform.transform(videoinfoFO, Videoinfo.class);
        List<Videoinfo> videoinfos = videoInfoService.showVideoInfoList(transform);
        ListResult<Videoinfo> listResult = new ListResult<>();
        listResult.setData(videoinfos);
        return listResult;
    }


}
