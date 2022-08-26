package chapter8;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Unmodifiable {
    public static void main(String[] args) {
        var UnmodifiableList = Collections.emptyList();
        //创建一个只有一个元素且不可改变的set对象
        var UnmodifiableSet = Collections.singleton("疯狂java讲义");
        var UnmodifiableList1 = Collections.singletonList("我才");
        //创建一个普通的map对象
        var scores = new HashMap();
        scores.put("yw",98);
        scores.put("yy",99);
        //返回普通map的不可变集合版本
        var UnmodifiableMap = Collections.unmodifiableMap(scores);
    }
}
