package com.zilin.myspringtest.jsonbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginInfo {
    @NotBlank(message = "UserName can't be null")
    private String userName;
    @NotBlank(message = "Password can't be null")
    private String userPassword;
}
