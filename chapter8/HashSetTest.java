package chapter8;

import java.util.HashSet;

class R{
int count;
public R(int count){
    this.count = count;
}
public String toString(){
    return "R[count:"+count+"]";
}
public boolean equals(Object obj){
    if(this == obj)
    {
        return true;
    }
    if(obj!=null && obj.getClass()==R.class){
        var r = (R) obj;
        return this.count == r.count;
    }
    return false;
}
public int hashCode(){
    return this.count;
}
}

public class HashSetTest {
    public static void main(String[] args) {
        var hs = new HashSet();
        hs.add(new R(5));
        hs.add(new R(-3));
        hs.add(new R(9));
        hs.add(new R(-2));
        //打印HashSet集合，集合元素没有重复
        System.out.println(hs);
        //取出第一个元素
        var it = hs.iterator();
        var first = (R) it.next();
        //为第一个元素的count实例变量赋值
        first.count = -3;//①
        //再次输出HashSet集合，集合元素有重复元素
        System.out.println(hs);
        //删除count为-3的R对象
        hs.remove(new R(-3));//②
        //可以看到被删除了一个R元素
        System.out.println(hs);
                                    // //再一次删除count为-3的R对象
                                    // hs.remove(new R(-3));
                                    // //可以看到删除不了R元素
                                    // System.out.println(hs);
        System.out.println("hs是否包含count为-3的R对象？"+hs.contains(new R(-3)));//为false
        System.out.println("hs是否包含count为-2的R对象？"+hs.contains(new R(-2)));//为false
    }
}
/**
 * 注解：
 * 上面的程序提供了R类，R类重写了equals(Object obj)方法和hashCode()方法，这两个方法都是根据R对象的count实例变量
 * 来判断的。上面程序的①号粗体字打代码处改变了Set集合中第一个R对象的count实例变量的值，这将导致该R对象与集合中的其它
 * 对象相同。
 * 因为HashSet集合中的第一个元素和第二个元素完全相同，这表明两个元素已经重复。此时HashSet会比较混乱：当试图删除count为-3的R对象时，HashSet会计算出该对象的
 * hashcode值，从而找出该对象在集合中的保存位置，然后把此处的对象与count为-3的R对象通过equals比较，如果相等则删除该对象---HashSet只有第二个元素才满足该条件
 * （第一个元素实际上保存在count为-2的R对象对应的位置），所以第二个元素被删除。至于第一个count为-3的R对象，它保存在count为-2的R对象对应的位置，但使用equals
 * （）方法拿他和count为-2的对象比较时又返回false--这将导致HashSet不可能准确访问该元素。
 * 由此
 * 当程序把可变对象添加到HashSet中之后，不要再去修改该集合元素中参与计算的hashCode（）、equals（）实例变量，否则将会导致Hashset无法正确操作这些集合元素
 */
