package com.example.videoframe.service.impl;

import com.example.videoframe.entity.Userinfo;
import com.example.videoframe.mapper.UserinfoMapper;
import com.example.videoframe.mapper.example.UserinfoExample;
import com.example.videoframe.service.UserInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.page.PageMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @Author: `sujinwang`
 * @Date: `2023/10/30 14:18`
 * @Version: 1.0
 * @Description:
 */
@Slf4j
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserinfoMapper userinfoMapper;

    @Override
    public int addUserInfo(Userinfo userinfo) {
        userinfo.setCreatetime(new Date());
        userinfo.setUpdatetime(new Date());
        return userinfoMapper.insert(userinfo);
    }

    @Override
    public List<Userinfo> findUserInfo(Userinfo userinfo) {

        UserinfoExample userinfoExample = new UserinfoExample();
        UserinfoExample.Criteria criteria = userinfoExample.createCriteria();
        criteria.andNameLike("%"+ Optional.ofNullable(userinfo.getName()).orElse("") +"%");
        PageHelper.startPage(userinfo.getPage(), userinfo.getRows());
        List<Userinfo> userinfos = userinfoMapper.selectByExample(userinfoExample);
        return userinfos;
    }
}
