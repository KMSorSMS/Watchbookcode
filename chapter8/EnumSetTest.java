package chapter8;

import java.util.EnumSet;

enum Season
{
    SPRING,SUMMER,FALL,WINTER
}

public class EnumSetTest {
public static void main(String[] args) {
    //创建一个EnumSet集合，集合元素就是Season枚举类的全部枚举值
    var es1 = EnumSet.allOf(Season.class);
    //输出[Spring,Summer,Fall,Winter]
    System.out.println(es1);
    //创建一个EnumSet空集合，指定其集合元素是Season类的枚举值
    var es2 = EnumSet.noneOf(Season.class);
    //输出[]
    System.out.println(es2);
    //手动添加两个元素
    es2.add(Season.WINTER);
    es2.add(Season.SPRING);
    es2.add(Season.SUMMER);
    System.out.println(es2);//输出[SPRING,WINTER]
    //以指定枚举值创建EnumSet
    var es3 = EnumSet.of(Season.SUMMER,Season.WINTER);
    System.out.println(es3);//输出[SUMMER,WINTER]
    var es4 = EnumSet.range(Season.SUMMER,Season.WINTER);
    System.out.println(es4);//输出[SUMMER,FALL,WINTER]
    //新创建的EnumSet集合元素和es4集合元素有相同的类型
    //es5集合元素+es4集合元素 = Season枚举类的全部枚举值
    var es5 = EnumSet.complementOf(es4);
    System.out.print(es5);//[SPRING]
}
}
