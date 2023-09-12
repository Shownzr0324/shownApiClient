package com.shown.shownapiclient.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class User {
    private String userName;
    private String secretKey;
    private String accessKey;
}
