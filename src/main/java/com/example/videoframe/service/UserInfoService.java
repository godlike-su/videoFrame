package com.example.videoframe.service;

import com.example.videoframe.entity.Userinfo;

import java.util.List;

/**
 * @Author: `sujinwang`
 * @Date: `2023/10/30 14:18`
 * @Version: 1.0
 * @Description:
 */
public interface UserInfoService {


    int addUserInfo(Userinfo userinfo);

    List<Userinfo> findUserInfo(Userinfo userinfo);

}
