package com.zilin.myspringtest.jsonbean;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString(callSuper = true)
public class ErrorInfo extends JsonBase{
    private String name;
    private String errorMsg;
}
