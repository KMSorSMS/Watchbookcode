package chapter8;

/**
 * 如果要实现定制排序，则需要在创建TreeSet集合对象时，提供一个Comparator对象与该TreeSet集合关联
 * 由该Comparator对象负责集合元素的排序逻辑。由于Comparator是一个函数式接口，因此可以使用Lambda
 * 表达式来替代Comparator对象
 */

 import java.util.TreeSet;

class M {
    int age;
    public M(int age){
        this.age = age;
    }
    public String toString()
    {
        return "M [age:"+age+"]";
    }
}

public class TreeSetTest4 {
 public static void main(String[] args) {
    //此处Lambda表达式的目标类型是Comparator
    var ts = new TreeSet((o1,o2)->{
        var m1 = (M) o1;
        var m2 = (M) o2;
        //根据M对象的age属性来决定大小，age越大，M对象反而越小
        return m1.age > m2.age?-1
        : m1.age <m2.age?1:0;
    });
    ts.add(new M(5));
    ts.add(new M(-3));
    ts.add(new M(9));
    ts.add(new M(100));
    System.out.println(ts);
 }   
}
