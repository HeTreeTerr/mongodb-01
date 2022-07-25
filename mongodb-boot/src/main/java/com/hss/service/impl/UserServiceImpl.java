package com.hss.service.impl;

import com.hss.bean.UserInfo;
import com.hss.bean.UserInfoDetail;
import com.hss.dao.UserInfoDao;
import com.hss.dao.UserInfoDetailDao;
import com.hss.dto.CreateUserDTO;
import com.hss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Autowired
    private UserInfoDetailDao userInfoDetailDao;

    @Override
    @Transactional
    public void createUser(CreateUserDTO userDTO) {
        UserInfo userInfo = UserInfo.builder()
                .name(userDTO.getName())
                .age(userDTO.getAge())
                .build();
        userInfo = userInfoDao.insert(userInfo);
        if(true){
            throw new RuntimeException("测试事务！");
        }
        UserInfoDetail userInfoDetail = UserInfoDetail.builder()
                .uid(userInfo.getId())
                .tags(userDTO.getTags())
                .build();
        userInfoDetailDao.insert(userInfoDetail);
    }
}
