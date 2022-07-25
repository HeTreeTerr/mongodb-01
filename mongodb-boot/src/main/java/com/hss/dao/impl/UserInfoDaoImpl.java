package com.hss.dao.impl;

import com.hss.bean.UserInfo;
import com.hss.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDaoImpl implements UserInfoDao {

    private final static String COLLECTION_NAME = "userInfo";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserInfo insert(UserInfo userInfo) {
        userInfo = mongoTemplate.insert(userInfo, COLLECTION_NAME);
        return userInfo;
    }
}
