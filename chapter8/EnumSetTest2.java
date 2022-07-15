package chapter8;

import java.util.EnumSet;
import java.util.HashSet;

public class EnumSetTest2 {
    public static void main(String[] args) {
        var c = new HashSet();
        c.clear();
        c.add(Season.FALL);
        c.add(Season.WINTER);
        c.add(Season.SPRING);
        //复制Collection集合中的所有元素来创建EnumSet集合
        var enumset = EnumSet.copyOf(c);
        System.out.println(enumset);
        c.add("疯狂java讲义");
        System.out.println(c);
        //下面代码将出现异常：因为c集合里的元素不是全部都为枚举值
        // enumset = EnumSet.copyOf(c);
    }
}
