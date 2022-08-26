package chapter8;

import java.util.LinkedList;

public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList<String> books = new LinkedList<>();
        //将字符串元素加入队列的尾部
        books.offer("疯狂Java讲义");
        //将字符串元素添加到栈的顶部
        books.push("wocaonidema");
        //将字符串元素添加到队列的头部（相当于栈的顶部
        books.offerFirst("zheshi diyige");
        for(var i=0;i<books.size();i++){
            System.out.println("遍历中："+books.get(i));
        }
        //访问并不删除栈顶元素
        System.out.println(books.peek());
        System.out.println(books.peekFirst());
        //访问并不删除队列的最后一个元素
        System.out.println(books.peekLast());
        //将栈顶的元素弹出栈
        System.out.println(books.pop());
        //将看到队列的第一个元素被删除
        System.out.println(books);
        //访问并删除队列的最后一个元素
        System.out.println(books.pollLast());
        //下面输出wocaonide ma
        System.out.println(books);
    }
}
