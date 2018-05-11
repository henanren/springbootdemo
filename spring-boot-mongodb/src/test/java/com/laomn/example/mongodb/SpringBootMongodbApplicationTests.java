package com.laomn.example.mongodb;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSONObject;
import com.laomn.example.mongodb.dao.DemoDao;
import com.laomn.example.mongodb.enties.DemoEntity;

/**
 * 描述: 单元测试
 *
 * @author: yanpenglei
 * @create: 2018/2/5 13:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootMongodbApplication.class)
public class SpringBootMongodbApplicationTests {

    @Autowired
    private DemoDao demoDao;

//    @Test
    public void saveDemoTest() {
    	System.err.println("插入=====");
        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1L);
        demoEntity.setTitle("Spring Boot 中使用 MongoDB");
        demoEntity.setDescription("关注公众号，搜云库，专注于开发技术的研究与知识分享");
        demoEntity.setBy("souyunku");
        demoEntity.setUrl("http://www.souyunku.com");

        demoDao.saveDemo(demoEntity);

        demoEntity = new DemoEntity();
        demoEntity.setId(2L);
        demoEntity.setTitle("Spring Boot 中使用 MongoDB");
        demoEntity.setDescription("关注公众号，搜云库，专注于开发技术的研究与知识分享");
        demoEntity.setBy("souyunku");
        demoEntity.setUrl("http://www.souyunku.com");

        demoDao.saveDemo(demoEntity);
    }

//    @Test
    public void removeDemoTest() {
        demoDao.removeDemo(2L);
    }

//    @Test
    public void updateDemoTest() {

        DemoEntity demoEntity = new DemoEntity();
        demoEntity.setId(1L);
        demoEntity.setTitle("Spring Boot 中使用 MongoDB 更新数据");
        demoEntity.setDescription("关注公众号，搜云库，专注于开发技术的研究与知识分享");
        demoEntity.setBy("souyunku");
        demoEntity.setUrl("http://www.souyunku.com");

        demoDao.updateDemo(demoEntity);
    }

    @Test
    public void findDemoByIdTest() {
    	System.err.println("查询=====");

        DemoEntity demoEntity = demoDao.findDemoById(1L);

        System.out.println(JSONObject.toJSONString(demoEntity));
    }

}
