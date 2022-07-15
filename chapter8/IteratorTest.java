package chapter8;

import java.util.Collection;
import java.util.HashSet;
import java.util.function.Predicate;
import java.util.stream.IntStream;

public class IteratorTest {
    public static void main(String[] args) {
    //     //创建一个集合
    //     var books = new HashSet();
    //     String str = "8";
    //     str.equals("8");
    //     str.hashCode();
    //     books.add("轻量级Java EE企业级应用实战");
    //     books.add("疯狂Java讲义");
    //     books.add("疯狂Android讲义");
    //     books.add("疯狂ios讲义");
    //     books.add("疯狂Ajax讲义");
    //     // //调用forEach（）方法遍历集合
    //     // books.forEach(obj -> System.out.println("迭代元素"+obj))
    //     /*
    //      * 2
    //      */
    //     //获取books集合对应的迭代器
    //     // var it = books.iterator();
    //     // while(it.hasNext()){
    //     //     //it.next()方法返回的数据类型是object类型，因此需要强制类型转换
    //     //     var book = (String) it.next();
    //     //     System.out.println(book);
    //     //     if(book.equals("疯狂Java讲义")){
    //     //         //从集合中删除上一次next()方法返回的元素
    //     //         it.remove();
    //     //     }
    //     //     //对book变量赋值，不会改变集合元素本身
    //     //     book = "测试字符串";
    //     // }
    //     // var is = IntStream.builder().add(2).build();
    //     // System.out.println(books);
    //     /**
    //      * 3、不用Stream操作
    //      */
    //     //统计书名包含"疯狂"字串的图书数量
    //     // System.out.println(calAll(books, ele->((String) ele).contains("疯狂")));
    //     /**
    //      * 使用Stream操作
    //      */
    //     System.out.println(books.stream().filter(ele->((String) ele).contains("疯狂")).count());
    //     //先用Collection对象的Stream（）方法将集合转换为Stream，
    //     //再调用Stream的mapToInt方法获取原有的Stream对应的IntStream
    //     books.stream().mapToInt(ele -> ((String) ele).length()).forEach(System.out::println);
    //     books.stream().forEach(System.out::println);
    //     books.stream().forEach(ele -> System.out.println((String)ele));
    // }

    // // public static int calAll(Collection books, Predicate p){
    // //     int total = 0;
    // //     for(var obj: books){
    // //         //使用Predicate的test()方法判断对象是否满足Predicate指定的条件
    // //         if(p.test(obj)){
    // //             total++;
    // //         }
    // //     }
    // //     return total;
    // // }

    
}
