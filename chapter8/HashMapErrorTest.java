package chapter8;

import java.util.HashMap;

public class HashMapErrorTest {
    public static void main(String[] args) {
        var hm = new HashMap();
        //此处的A类与前一个程序的A类是同一个类
        hm.put(new A(6000),"fk java jyi");
        hm.put(new A(87563),"jlj Java EE jyi");
        //获得HashMap的集合对应的key set集合的 Iterator迭代器
        System.out.println(hm);
        var it = hm.keySet().iterator();
        //取出Map中第一个Key，并修改它的count值
        var first = (A) it.next();
        first.count = 87563;//这里改变了原来key的count值，也就改变了其hashcode值
        //
        System.out.println(hm);
        //只能删除没有被修改过的key所对应的key-value对
        hm.remove(new A(87563));
        System.out.println(hm);
        //无法获取剩下的value，下面两行代码都将输出null
        System.out.println(hm.get(new A(87563))); //
        System.out.println(hm.get(new A(6000)));
    }
}
/**
 * 该程序使用的A对象作为Key，A是一个可变对象，当程序在改变了A对象后，实际上修改
 * 了HashMap集合中元素的key，这就导致了该key不能被准确访问
 * 当程序试图删除count为87563的A对象时，只能删除没被修改的key所对应的key-value对
 * 这是因为后面虽然改了key值，但是它的存在记录位置是在原来的key值计算出的
 * hashcode决定的，所以当要删除876536时，找到的并不是修改的元素
 */