package chapter8;

import java.util.ArrayList;

public class ListTest3 {
    public static void main(String[] args) {
        var books = new ArrayList();
        //向books集合中添加4个元素
        books.add("轻量级Java EE企业应用实战");
        books.add("疯狂Java讲义");
        books.add("疯狂Android讲义");
        books.add("疯狂ios讲义");
        //使用目标类型为Comparator的Lambda表达式对List集合排序
        books.sort((o1,o2)-> ((String) o1).length()-((String)  o2).length());
        System.out.println(books);
        //使用目标类型为UnaryOperator的Lambda表达式来替代集合中的所有元素
        //该Lambda表达式控制使用每个字符串长度作为新的集合元素
        books.replaceAll(ele -> ((String) ele).length());
        System.out.println(books);
    }
}
/**
 * 传给sort（）方法的lambda表达式指定的规则是：字符串长度越长，字符串越大，因此执行完sort
 * 之后，List集合中的字符串会按由短到长的顺序排列
 * 程序中传给replaceALL（）方法的Lambda表达式指定了替换集合元素的规则：直接用集合元素（字符串）
 * 的长度作为新的集合元素。
 */
