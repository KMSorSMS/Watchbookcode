package chapter8;

import java.util.TreeSet;

class R implements Comparable {
    int count;

    public R(int count) {
        this.count = count;
    }

    public String toString() {
        return "R[count:" + count + "]";
    }

    // 重写equals方法，根据count来判断是否相等
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == R.class) {
            var r = (R) obj;
            return r.count == this.count;
        }
        return false;
    }

    // 重写compareTo方法，根据count来比较大小
    public int compareTo(Object obj) {
        var r = (R) obj;
        return count > r.count ? 1 :
             count < r.count ? -1 : 0;
    }
}

public class TreeSetTest3 {
    public static void main(String[] args) {
        var ts = new TreeSet();
        ts.add(new R(5));
        ts.add(new R(-3));
        ts.add(new R(9));
        ts.add(new R(-2));

        //无法添加重复元素
        System.out.println(ts.add(new R(-2)));
        //打印TreeSet集合，集合元素是有序排列的
        System.out.println(ts);//①
        //取出第一个元素
        var first = (R) ts.first();
        //对第一个元素的count重新赋值
        first.count = 20;
        //取出最后一个元素的count赋值，与第二个元素的count相同
        var last = (R) ts.last();
        last.count = -2;
        //再次输出将看到TreeSet里的元素处于无序状态，且有重复元素
        System.out.println(ts);//②
        //删除实例变量被改变的元素，删除失败
        System.out.println(ts.remove(new R(-2)));
        System.out.println(ts);
        //删除实例变量没有被改变的元素，删除成功
        System.out.println(ts.remove(new R(5)));
        System.out.println(ts);

    }
}
/**
 * 上面程序中的R对象对应的类重写了equals方法和compareTo（）方法，这两个方法都以R对象的count实例变量作为判断的依据。
 * 当程序执行①时，看到输出的Set集合元素处于有序状态；因为R类时一个可变类，因此可以改变R对象的count实例变量的值，程序通过
 * 改变了集合里第一个元素和最后一个元素的count实例变量的值，在②处看到，集合处于无序状态，而且集合中包含了重复元素
 * 
 * 一旦改变了TreeSet集合里可变元素的实例变量，当再试图删除该对象时，TreeSet也会删除失败（甚至集合中原有的、实例变量
 * 没有被修改但与修改后元素相等的元素也无法删除），所以再上面程序试图删除count值为-2的R对象时，没有任何元素被删除
 * 程序执行删除count值为5的R对象时，是可以的，表明TreeSet可以删除没有被修改实例变量、且不与其它修改实例变量的对象
 * 重复的对象。
 */