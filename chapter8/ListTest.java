package chapter8;

import java.util.ArrayList;

public class ListTest {
    public static void main(String[] args) {
        var books = new ArrayList();
        //向books集合中添加三个元素
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        System.out.println(books);
        //将新字符串对象插入在第二个位置
        books.add(1,new String("疯狂Ajax讲义"));
        for(var i = 0;i < books.size();i++){
            System.out.println(books.get(i));
        }
        //删除第三个元素
        books.remove(2);
        System.out.println(books);
        //判断指定元素在List集合中的位置：输出1，表明位于第二位
        System.out.println(books.indexOf(new String("疯狂Ajax讲义")));
        //将第二个元素替换成新的字符串对象
        books.set(1,"疯狂Java讲义");
        System.out.println(books);
        //将books集合的第二个元素（包括）
        //到第三个元素（不包括）截取成子集合
        System.out.println(books.subList(1,2));
    }
}
/**
 * 当调用List的set(int index, Object element)方法来改变List集合指定索引处元素时，
 * 指定的索引必须时List集合的有效索引。例如集合长度是4，就不能指定替换所有为4处
 * 的元素----也就是说，这个set方法不会改变List集合的长度
 * 
 */
