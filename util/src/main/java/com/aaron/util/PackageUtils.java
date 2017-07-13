package com.aaron.util;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by com.aaron on 7/8/17.
 */
public class PackageUtils {
    private static final String CODE = "code";
    private static final String CODE_SUCCESS = "success";
    private static final String CODE_FAIL = "fail";
    private static final String CODE_EXCEPTION = "exception";

    private static final String MESSAGE = "message";
    private static final String MESSAGE_SUCCESS = "处理成功";
    private static final String MESSAGE_FAIL = "处理失败";
    private static final String MESSAGE_EXCEPTION = "服务器异常";

    private static final String CONTENT = "content";

    public static JSONObject success() {
        return success(new JSONObject());
    }

    public static JSONObject success(JSONObject content) {
        JSONObject res = new JSONObject();
        res.put(CODE, CODE_SUCCESS);
        res.put(MESSAGE, MESSAGE_SUCCESS);
        res.put(CONTENT, content);
        return res;
    }

    public static JSONObject fail() {
        return fail(MESSAGE_FAIL);
    }

    public static JSONObject fail(String message) {
        JSONObject res = new JSONObject();
        res.put(CODE, CODE_FAIL);
        res.put(MESSAGE, message);
        return res;
    }

    public static JSONObject exception() {
        JSONObject res = new JSONObject();
        res.put(CODE, CODE_EXCEPTION);
        res.put(MESSAGE, MESSAGE_EXCEPTION);
        return res;
    }
}
