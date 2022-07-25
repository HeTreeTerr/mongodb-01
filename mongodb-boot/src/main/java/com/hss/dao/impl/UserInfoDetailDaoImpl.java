package com.hss.dao.impl;

import com.hss.bean.UserInfoDetail;
import com.hss.dao.UserInfoDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserInfoDetailDaoImpl implements UserInfoDetailDao {

    private final static String COLLECTION_NAME = "userInfoDetail";

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserInfoDetail insert(UserInfoDetail userInfoDetail) {
        userInfoDetail = mongoTemplate.insert(userInfoDetail, COLLECTION_NAME);
        return userInfoDetail;
    }
}
