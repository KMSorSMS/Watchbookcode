package chapter6;

public interface Output {
    //接口里面定义的成员变量只能是常量
    //因为相当于是加了public static final修饰符，对于final：
    //要么非static初始化块，构造器，定义处赋值，interface没有前两个，所以仅能在定义处赋值
    int MAX_CACHE_LINE = 50;
    //接口里定义的普通方法（不是默认方法，不是类方法，不是私有方法）只能是public的抽象方法
    //没有修饰都会加上public abstract
    void out();
    void getData(String msgs);
    //在接口里定义默认方法，需要使用default修饰符
    //其实这里的很像抽象类里面的实例方法、public可以省略，但是还是会默认补充，访问权限就是public，default只是为了不和之前的定义：
    //interface里面的普通方法不能有方法体，  冲突，从而专门标识default方法。所谓默认方法
    public default void print(String... msgs){
        for(var msg:msgs){
            System.out.println(msg);
        }
    }
    //在接口中定义默认方法，需要使用default修饰
    default void test(){
        System.out.println("默认的test（）方法");
    }
    //在接口中定义类方法，需要使用static修饰
    static String staticTest(){
        return "接口里的类方法";
    }
    //定义私有方法、好像并不是public的访问权限
    private void foo(){
        System.out.println("foo私有方法");
    }
    //定义私有静态方法
    private static void bar(){
        System.out.println("bar私有静态方法");
    }


}
