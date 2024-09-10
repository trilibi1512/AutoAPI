package org.example;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class verifyBody {
    public static Map<String, Object> setHeader(){
        Map<String, Object> headermap = new HashMap<>();
        headermap.put("User-Agent", "PostmanRuntime/7.41.2");
        headermap.put("Accept-Encoding", "gzip, deflate, br");
        headermap.put("Connection", "keep-alive");
        return headermap;

    }

    public static JSONObject requestBodyJson (String username, String password) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("username",username)
                .put("password", password);
        return jsonObject;
    }

}
