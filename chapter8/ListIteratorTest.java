package chapter8;

import java.util.ArrayList;

/**
 * 拿ListIterator与普通的Iterator进行对比，
 * 不难发现ListIterator增加了向前迭代的功能（Iterator只能向后迭代）
 * 而且ListIterator还可以通过add（）方法向List集合中添加元素（Iterator
 * 只能删除元素）。
 * 下面示范了ListIterator的用法
 */

public class ListIteratorTest {
    public static void main(String[] args) {
        String[] books = {
            "疯狂Java讲义","疯狂ios讲义",
            "轻量级Java EE企业级应用实战"
        };
        var bookList = new ArrayList();
        for(var i=0;i<books.length;i++){
            bookList.add(books[i]);
        }
        var lit = bookList.listIterator();
        //从前向后遍历
        while(lit.hasNext())
        {
            System.out.println(lit.next());
            lit.add("---------分隔符---------");
        }
        System.out.println("======下面开始反向迭代======");
        //从后向前遍历
        while(lit.hasPrevious()){
            System.out.println(lit.previous());
        }


    }
}
