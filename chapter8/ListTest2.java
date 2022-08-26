package chapter8;

import java.util.ArrayList;

/**
 * List判断两个对象相等只要通过equals()方法比较返回true即可
 */

class A
{
    public boolean equals(Object obj){
        return true;
    }
}
public class ListTest2 {
    public static void main(String[] args) {
        var books = new ArrayList();
        books.add("轻量级Java企业应用实战");
        books.add("疯狂Java讲义");
        books.add("哎哟肚子好痛");
        System.out.println(books);
        books.toString();
        //删除集合中的A对象，将导致第一个元素被删除
        //因为比较是A.equals(book)
        books.remove(new A());
        System.out.println(books);
        //删除集合中的A对象，再次删除集合的第一个元素
        books.remove(new A());
        System.out.println(books);
    }
}
