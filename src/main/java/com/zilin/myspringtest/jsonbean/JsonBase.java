package com.zilin.myspringtest.jsonbean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonBase {
    private int code;
    private String msg;
}
