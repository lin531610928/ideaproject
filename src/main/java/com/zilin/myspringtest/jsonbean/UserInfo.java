package com.zilin.myspringtest.jsonbean;

import com.zilin.myspringtest.entity.MyUser;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class UserInfo extends JsonBase {
    private MyUser myUser;
}
