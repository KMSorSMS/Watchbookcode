package chapter9;

import java.util.ArrayList;
import java.util.Collection;

class A{
    public void printif(){
        System.out.println("I like shit");
    }
}
class B extends A{
    public void printifnot(){
        System.out.println("I don't like shit");
    }
}

public class MyUtils {
    //下面dest集合元素的类型必须与src集合元素的类型相同，或者是其父类
    public static <T> T copy(Collection<? super T> dest,Collection<T> src){
        T last = null;
        for(var ele:src){
            last = ele;
            //逆变的泛型集合添加元素是安全的
            dest.add(ele);
        }
        return last;
    }
    public static void main(String[] args) {
        var ln = new ArrayList<Number>();
        var li = new ArrayList<Integer>();
        li.add(5);
        var la = new ArrayList<A>();
        var lb = new ArrayList<B>();
        lb.add(new B());
        //此处可准确地中的最后一个被复制的元素是Integer类型
        //与src集合元素类型相同
        Integer last = copy(ln,li);
        System.out.println(ln);
        B b = copy(la, lb);
        la.get(0).printif();
        ((B)la.get(0)).printifnot();
    }
}
