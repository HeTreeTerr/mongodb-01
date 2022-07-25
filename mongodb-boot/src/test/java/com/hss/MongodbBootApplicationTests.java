package com.hss;

import com.hss.bean.UserInfo;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest(classes = MongodbBootApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
public class MongodbBootApplicationTests {

    private final static String COLLECTION_NAME = "userInfo";

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 插入文档
     */
    @Test
    public void insert(){
        UserInfo person = UserInfo.builder()
                .name("lisi")
                .age(18)
                .build();
        UserInfo insert = mongoTemplate.insert(person, COLLECTION_NAME);
        log.info(insert.toString());
    }

    /**
     * 查询文档
     */
    @Test
    public void findOne(){
        UserInfo person = mongoTemplate.findById("62dd456007dbf40a102be99a", UserInfo.class, COLLECTION_NAME);
        log.info(person.toString());
    }

    /**
     * 更新文档
     */
    @Test
    public void update(){
        UpdateResult updateResult = mongoTemplate.updateFirst(
                Query.query(Criteria.where("name").is("lisi")),
                Update.update("age", 28),
                UserInfo.class,
                COLLECTION_NAME);
        log.info(updateResult.toString());

        UserInfo person = mongoTemplate.findOne(Query.query(Criteria.where("name").is("lisi")), UserInfo.class, COLLECTION_NAME);
        log.info("Updated: " + person);
    }

    /**
     * 删除文档
     */
    @Test
    public void delete(){
        DeleteResult deleteResult = mongoTemplate.remove(Query.query(Criteria.where("name").is("lisi")), COLLECTION_NAME);
        log.info(deleteResult.toString());
    }

    /**
     * 查询文档（多）
     */
    @Test
    public void findAll(){
        List<UserInfo> people =  mongoTemplate.findAll(UserInfo.class,COLLECTION_NAME);
        log.info("Number of people = : " + people.size());
    }

    /**
     * 删除集合
     */
    @Test
    public void dropCollection(){
        mongoTemplate.dropCollection(COLLECTION_NAME);
        log.info("drop success");
    }

}
