package chapter8;

import java.util.ArrayDeque;

public class ArrayDequeStack {
    public static void main(String[] args) {
        ArrayDeque<String> stack = new ArrayDeque<>();
        //依次将三个元素push入“栈”
        stack.push("疯狂Java讲义");
        stack.push("我艹啊，好烦哦");
        stack.push("我去，看看这是什么");
        //LIFO后进先出，[我去，看看这是什么,我艹啊，好烦哦,疯狂Java讲义]
        System.out.println(stack);
        //访问第一个元素，但并不将其pop出“栈”，输出：我去，看看这是什么
        System.out.println(stack.peek());
        //依然输出：[我去，看看这是什么,我艹啊，好烦哦,疯狂Java讲义]
        System.out.println(stack);
        //pop出第一个元素，输出：我去，看看这是什么
        System.out.println(stack.pop());
        //输出：[我艹啊，好烦哦,疯狂Java讲义]
        System.out.println(stack);
    }
}
/**
 * 上面程序显示了ArrayDeque作为栈的行为，因此当程序中需要使用“栈”这种数据结构时
 * 推荐使用ArrayDeque，尽量避免使用Stack--因为古老，性能差
 */
