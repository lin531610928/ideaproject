package com.zilin.myspringtest.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum CodeInfo {
    SUCCESS(1001, "Success"),
    ERROE(1002, "Error"),
    DATAERROR(1003, "The data is incorrect"),
    LOGINERROR(1004, "Username or password is incorrect"),
    USERNAMEEXIST(1005, "Username already exists"),
    DATABASE_WRITE_ERROE(1006, "Database write failed"),
    REPASSWORDERROR(1007, "Two passwords are different"),
    EMAILEXIST(1008, "Email already exists");

    private int code;
    private String msg;
}