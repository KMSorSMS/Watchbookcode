package chapter8;

import java.lang.reflect.Array;
import java.util.ArrayDeque;

public class ArrayDequeQueue {
    public static void main(String[] args) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        //依次将三个元素加入队列
        queue.offer("疯狂Java讲义");
        queue.offer("fuck you bitch");
        queue.offer("what's the hour");
        System.out.println(queue);
        //访问队列头部的元素，但并不将其poll出队列,输出“疯狂Java讲义”
        System.out.print(queue.peek());
        //依然输出：[疯狂Java讲义,fuck you bitch,what's the hour]
        System.out.println(queue);
        //poll出第一个元素，输出：疯狂Java讲义
        System.out.println(queue.poll());
        //输出[fuck you bitch,what's the hour]
        System.out.println(queue);

    }
}
