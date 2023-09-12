package com.shown.shownapiclient.client;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.shown.shownapiclient.model.User;
import com.shown.shownapiclient.util.SignUtil;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ShownApiClient {
    private String accessKey;
    private String secretKey;

    public ShownApiClient(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    public String getName(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.get("http://localhost:8123/api/name/", paramMap);
    }

    public String postName(String name){
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name", name);
        return HttpUtil.post("http://localhost:8123/api/name/", paramMap);
    }

    public String postUserName(User user){
        String json = JSONUtil.toJsonStr(user);
        Map<String, String> map = new HashMap<>();
        map.put("accessKey",accessKey);
        map.put("nonce",RandomUtil.randomNumbers(4));
        map.put("timeStamp",String.valueOf(System.currentTimeMillis()/1000));
        map.put("body",json);
        map.put("sign",SignUtil.genSign(json,secretKey));
        return HttpRequest.post("http://localhost:8123/api/name/user")
                .addHeaders(map)
                .body(json)
                .execute().body();
    }
}
