package chapter8;

import java.util.EnumMap;

enum Season
{
    SPRING,SUMMER,FALL,WINTER
}

public class EnumMapTest {
    public static void main(String[] args) {
        //创建EnumMap对象，该EnumMap对象的所有key都是Season枚举类的枚举值
        EnumMap<Season,String> enumMap = new EnumMap<>(Season.class);
        enumMap.put(Season.SPRING,"春暖花开");
        enumMap.put(Season.SUMMER, "夏日炎炎");
        System.out.println(enumMap);
    }
}
