package com.zilin.myspringtest.controller;

import com.zilin.myspringtest.entity.MyUser;
import com.zilin.myspringtest.jsonbean.JsonBase;
import com.zilin.myspringtest.jsonbean.LoginInfo;
import com.zilin.myspringtest.jsonbean.UserEditInfo;
import com.zilin.myspringtest.jsonbean.UserInfo;
import com.zilin.myspringtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public JsonBase login(@RequestBody @Valid LoginInfo loginInfo){
        MyUser myUser = MyUser.builder().userName(loginInfo.getUserName()).userPassword(loginInfo.getUserPassword()).build();
        UserInfo userInfo = userService.userLogin(myUser);
        return userInfo;
    }

    @RequestMapping("/register")
    public JsonBase register(@RequestBody @Validated({UserEditInfo.register.class}) UserEditInfo userEditInfo){
        return userService.userRegister(userEditInfo);
    }

    @RequestMapping("/edit")
    public JsonBase edit(@RequestBody @Validated({UserEditInfo.edit.class}) UserEditInfo userEditInfo){
        return userService.userUpdate(userEditInfo);
    }
}
