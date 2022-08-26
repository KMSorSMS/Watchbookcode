package chapter8;

import java.util.Hashtable;

/**
 * 判断key相等的条件：
 * 两个key通过equals判断true
 * 两个vkey通过hashCode判断相等
 */
/**
 * 判断value相等的条件：
 * 两个value通过equals相等即可
 */

class A {
    int count;

    public A(int count) {
        this.count = count;
    }

    // 根据count值来判断两个对象是否相等
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj != null && obj.getClass() == A.class) {
            var a = (A) obj;
            return this.count == a.count;
        }
        return false;
    }

    // 根据count来计算hashCode值
    public int hashCode() {
        return this.count;
    }
}

class B {
    // 重写equals方法,对象B与任何对象通过equals（）方法比较都返回true
    public boolean equals(Object obj) {
        return true;
    }
}

public class HashTableTest {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        ht.put(new A(60000),"疯狂Java讲义");
        ht.put(new A(87563),"轻量级我了个去");
        ht.put(new A(233), new B());
        System.out.println(ht);
        //只要两个对象通过equals（）方法比较返回true
        //Hashtable就认为它们是相等的value
        //由于其中的B对象的equals和所有对象都返回true，所以和所有对象都相等
        System.out.println(ht.contains("测试字符串"));
        //只要两个对象的count相等，它们通过equals()方法比较返回true，且hashCode值相等
        //hashtable即认为它们是相同的key，所以下面输出true
        System.out.println(ht.containsKey(new A(87563)));
        ht.remove(new A(233));
        System.out.println(ht);
    }
}
