package chapter8;

import java.util.Arrays;

public class FixedSizeList {
    public static void main(String[] args) {
        var fixedList = Arrays.asList("疯狂Java讲义","轻量级Java EE企业应用实战");
        //获取FixedList的实现类，将输出Arrays$ArrayList
        System.out.println(fixedList.getClass());
        //使用方法引用遍历集合元素
        fixedList.forEach(System.out::println);
        //试图增加、删除元素都会引发UnsupportOperationException
        // fixedList.add("疯狂Android讲义");
        // fixedList.remove("疯狂Java讲义");
    }
    /**
     * 上面程序的add和remove对于普通的List集合完全正常，但如果试图通过
     * 这两个方法来增加、删除Arrays$ArrayList集合里的元素，将会引发异常
     * 。
     */
}
