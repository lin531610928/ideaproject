package com.zilin.myspringtest.dao;

import com.zilin.myspringtest.entity.MyUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MyUsersDao {
    MyUser selectByPrimaryKey(int userId);

    List<MyUser> selectAll();

    MyUser selectByPassword(MyUser myUser);

    int insertSelective(MyUser myUser);

    int updateByPrimaryKeySelective(MyUser myUser);

    int selectByName(String userName);

    int selectByMail(String userMail);
}
