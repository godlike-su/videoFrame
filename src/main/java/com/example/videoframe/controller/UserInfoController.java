package com.example.videoframe.controller;

import com.example.videoframe.entity.Userinfo;
import com.example.videoframe.fo.UserinfoFO;
import com.example.videoframe.service.UserInfoService;
import com.example.videoframe.util.ObjectTransform;
import com.example.videoframe.vo.UserinfoVO;
import com.example.videoframe.webreturn.result.MessageResult;
import com.example.videoframe.webreturn.result.PageResult;
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
 * @Date: `2023/10/30 14:16`
 * @Version: 1.0
 * @Description:
 */
@RestController
@Tag(name = "用户目录操作")
@RequestMapping("/userInfo")
public class UserInfoController {


    @Autowired
    private UserInfoService userInfoService;

    @Operation(summary = "创建一个新的用户目录")
    @PostMapping("addUserInfo")
    public MessageResult addUserInfo(@RequestBody UserinfoFO userinfoFO) {
        Userinfo transform = ObjectTransform.transform(userinfoFO, Userinfo.class);
        userInfoService.addUserInfo(transform);
        return new MessageResult("创建用户目录成功");
    }

    @Operation(summary = "根据条件查找用户目录")
    @PostMapping("findUserInfo")
    public PageResult<Userinfo> findUserInfo(@RequestBody UserinfoFO userinfoFO) {
        Userinfo transform = ObjectTransform.transform(userinfoFO, Userinfo.class);
        List<Userinfo> userInfo = userInfoService.findUserInfo(transform);
        PageResult<Userinfo> objectPageResult = new PageResult<>();
        objectPageResult.setData(userInfo);
        return objectPageResult;

    }


}
