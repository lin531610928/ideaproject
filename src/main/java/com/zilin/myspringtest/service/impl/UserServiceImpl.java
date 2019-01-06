package com.zilin.myspringtest.service.impl;

import com.zilin.myspringtest.dao.MyUsersDao;
import com.zilin.myspringtest.entity.MyUser;
import com.zilin.myspringtest.jsonbean.JsonBase;
import com.zilin.myspringtest.jsonbean.UserEditInfo;
import com.zilin.myspringtest.jsonbean.UserInfo;
import com.zilin.myspringtest.service.UserService;
import com.zilin.myspringtest.util.CodeInfo;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service()
@Log4j2
public class UserServiceImpl implements UserService {
    @Autowired
    private MyUsersDao myUsersDao;

    @Override
    public UserInfo userLogin(MyUser myUser) {
        MyUser result = myUsersDao.selectByPassword(myUser);
        UserInfo userInfo = new UserInfo(result);
        if(result == null){
            userInfo.setCode(CodeInfo.LOGINERROR.getCode());
            userInfo.setMsg(CodeInfo.LOGINERROR.getMsg());
            log.info("Error info: " + CodeInfo.LOGINERROR.toString() + " Request info: " + myUser.toString());
        }else {
            userInfo.setCode(CodeInfo.SUCCESS.getCode());
            userInfo.setMsg(CodeInfo.SUCCESS.getMsg());
            log.info("Success info: Login in success! Request info: " + myUser.toString());
        }
        return userInfo;
    }

    @Override
    public JsonBase userRegister(UserEditInfo userEditInfo) {
        if(userEditInfo.getUserPassword().equals(userEditInfo.getUserPassword2()) == false){
            log.info("Error info: " + CodeInfo.REPASSWORDERROR.toString() + " Request info: " + userEditInfo.toString());
            return new JsonBase(CodeInfo.REPASSWORDERROR.getCode(), CodeInfo.REPASSWORDERROR.getMsg());
        }
        MyUser myUser = MyUser.builder()
                .userName(userEditInfo.getUserName())
                .userPassword(userEditInfo.getUserPassword())
                .userMail(userEditInfo.getUserMail())
                .nickName(userEditInfo.getNickName())
                .build();
        if(myUsersDao.selectByName(myUser.getUserName()) > 0){
            log.info("Error info: " + CodeInfo.USERNAMEEXIST.toString() + " Request info: " + userEditInfo.toString());
            return new JsonBase(CodeInfo.USERNAMEEXIST.getCode(), CodeInfo.USERNAMEEXIST.getMsg());
        }
        if(myUsersDao.insertSelective(myUser) == 0){
            log.info("Error info: " + CodeInfo.DATABASE_WRITE_ERROE.toString() + " Request info: " + userEditInfo.toString());
            return new JsonBase(CodeInfo.DATABASE_WRITE_ERROE.getCode(), CodeInfo.DATABASE_WRITE_ERROE.getMsg());
        }
        log.info("Success info: Register success! Request info: " + userEditInfo.toString());
        return new JsonBase(CodeInfo.SUCCESS.getCode(), CodeInfo.SUCCESS.getMsg());
    }

    @Override
    public JsonBase userUpdate(UserEditInfo userEditInfo) {
        if(userEditInfo.getUserName() != null && myUsersDao.selectByName(userEditInfo.getUserName()) > 0){
            log.info("Error info: " + CodeInfo.USERNAMEEXIST.toString() + " Request info: " + userEditInfo.toString());
            return new JsonBase(CodeInfo.USERNAMEEXIST.getCode(), CodeInfo.USERNAMEEXIST.getMsg());
        }
        if((userEditInfo.getUserPassword() == null && userEditInfo.getUserPassword2() != null) || (userEditInfo.getUserPassword() != null && userEditInfo.getUserPassword().equals(userEditInfo.getUserPassword2()) == false)){
            log.info("Error info: " + CodeInfo.REPASSWORDERROR.toString() + " Request info: " + userEditInfo.toString());
            return new JsonBase(CodeInfo.REPASSWORDERROR.getCode(), CodeInfo.REPASSWORDERROR.getMsg());
        }
        if(userEditInfo.getUserMail() != null && myUsersDao.selectByMail(userEditInfo.getUserMail()) > 0){
            log.info("Error info: " + CodeInfo.EMAILEXIST.toString() + " Request info: " + userEditInfo.toString());
            return new JsonBase(CodeInfo.EMAILEXIST.getCode(), CodeInfo.EMAILEXIST.getMsg());
        }
        MyUser myUser = MyUser.builder()
                .userId(userEditInfo.getUserId())
                .userName(userEditInfo.getUserName())
                .userPassword(userEditInfo.getUserPassword())
                .userMail(userEditInfo.getUserMail())
                .nickName(userEditInfo.getNickName())
                .build();
        if(myUsersDao.updateByPrimaryKeySelective(myUser) == 0){
            log.info("Error info: " + CodeInfo.DATABASE_WRITE_ERROE.toString() + " Request info: " + userEditInfo.toString());
            return new JsonBase(CodeInfo.DATABASE_WRITE_ERROE.getCode(), CodeInfo.DATABASE_WRITE_ERROE.getMsg());
        }
        log.info("Success info: Edit success! Request info: " + userEditInfo.toString());
        return new JsonBase(CodeInfo.SUCCESS.getCode(), CodeInfo.SUCCESS.getMsg());
    }
}
