package chapter8;

import java.util.WeakHashMap;

public class WeakHashMapTest {
    public static void main(String[] args) {
        WeakHashMap<String,String> whm = new WeakHashMap<>();
        //向WeakHashMap中添加三个key-value对
        //三个key都是匿名字符串对象（没有其它引用）
        whm.put(new String("Chinese"),new String("well"));
        whm.put(new String("English"),new String("Good"));
        whm.put(new String("Math"),new String("Excellent"));
        //向WeakHashMap中添加一个Key-value对
        //该key是一个系统缓存的字符串对象
        whm.put("Java", new String("just so so"));
        //输出whm对象，将看到4个key-value对
        System.out.println(whm);
        //通知系统立即进行垃圾回收
        System.gc();
        System.runFinalization();
        //在通常情况下，将只看到一个key-value对
        System.out.println(whm);

        
    }
   
}
