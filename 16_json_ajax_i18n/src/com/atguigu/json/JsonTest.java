package com.atguigu.json;

import com.atguigu.pojo.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    // 1.2.1 javaBean和json的互转
    @Test
    public void test() {
        Person person = new Person(1,"老八");
        //创建gson对象实例
        Gson gson = new Gson();
        //toJson方法可以将java对象转化为json字符串
        String jsonPersonToString = gson.toJson(person);
        System.out.println(jsonPersonToString);
        //fromJson将json字符串转化回java对象
        Person person1 = gson.fromJson(jsonPersonToString, Person.class);
        System.out.println(person1);


    }

    //1.2.2 List和json的互转
    @Test
    public void test2() {
        List<Person> list=new ArrayList<>();
        list.add(new Person(1, "老八"));
        list.add(new Person(2, "老九"));
        Gson gson=new Gson();
        String s = gson.toJson(list);
        System.out.println(s);
        Object o=gson.fromJson(s,new TypeToken<ArrayList<Person>>(){}.getType());
        System.out.println(o);

    }


    //1.2.3 map和json的互转
    @Test
    public void test3() {
        Map<Integer, Person> personMap = new HashMap<>();
        personMap.put(1, new Person(1, "老八"));
        personMap.put(2, new Person(2, "老九"));
        Gson gson = new Gson();
        String s = gson.toJson(personMap);
        System.out.println(s);
//        Object o = gson.fromJson(s, new PersonListType().getType());
        Object o = gson.fromJson(s, new TypeToken<HashMap<Integer, Person>>() {
        }.getType());
        Person person = personMap.get(1);
        System.out.println(person);
        System.out.println(o);
    }

}
