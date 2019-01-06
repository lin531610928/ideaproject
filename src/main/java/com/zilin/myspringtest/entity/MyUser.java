package com.zilin.myspringtest.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MyUser {
    private int userId;
    private String userName;
    private String userPassword;
    private String userMail;
    private String nickName;
}
