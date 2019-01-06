package com.zilin.myspringtest.service;

import com.zilin.myspringtest.entity.MyUser;
import com.zilin.myspringtest.jsonbean.JsonBase;
import com.zilin.myspringtest.jsonbean.UserEditInfo;
import com.zilin.myspringtest.jsonbean.UserInfo;

public interface UserService {
    UserInfo userLogin(MyUser myUser);
    JsonBase userRegister(UserEditInfo userEditInfo);
    JsonBase userUpdate(UserEditInfo userEditInfo);
}
