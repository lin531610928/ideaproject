package com.zilin.myspringtest;

import com.zilin.myspringtest.dao.MyUsersDao;
import com.zilin.myspringtest.entity.MyUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyspringtestApplicationTests {
    @Autowired
    MyUsersDao myUsersDao;

    @Test
    public void contextLoads() {
        MyUser myUser = MyUser.builder().userId(10001).userName("lin1234").userPassword("12345678").build();
        System.out.println(myUsersDao.selectByName("lin123"));
    }

}

