package com.firebasky.user;

import java.io.IOException;

public class person {
    static {
        System.out.println("call 静态方法");
    }

    public person(String name){
        System.out.println("call 构造函数"+name);
    }
    public person(){
        System.out.println("call 无参数构造函数");
    }

    public String getName() {
        System.out.println("call getname");
        return name;
    }

    public void setName(String name) throws IOException {
//        Runtime.getRuntime().exec("calc");
        System.out.println("call setname");
        this.name = "firebasky";
    }

    public Integer getAge() {
        System.out.println("call getage");
        return age;
    }

    public void setAge(Integer age) {
        System.out.println("call setage");
        this.age = 21;
    }

    public String name="firebasky";
    public Integer age=21;

}
