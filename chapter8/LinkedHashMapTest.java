package chapter8;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String,Integer> scores = new LinkedHashMap<>();
        scores.put("语文",80);
        scores.put("英语",82);
        scores.put("数学", 76);
        //调用foreach()方法遍历scores里的所有key-value对
        scores.forEach((key,value) -> System.out.println(key+"--->"+value));
        // scores.forEach(System.out::println);
    }
}
