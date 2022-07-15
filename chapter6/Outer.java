package chapter6;

/**
 * 非静态内部类对象必须寄生在外部类对象里，而外部类对象
 * 不必一定有非静态内部类对象寄生其中。简单地说，如果存在
 * 一个非静态内部类对象，则一定有一个被他寄生的外部类对象。
 * 但是外部类对象存在时，外部类对象里不一定寄生了非静态内部
 * 类对象。因此外部类对象访问非静态内部类成员时，可能非静态
 * 普通内部类对象根本就不存在。而非静态内部类对象访问外部类
 * 成员时，外部类对象一定存在。
 */

public class Outer {
    private int outProp = 9;

    class Inner {
        private int inprop = 5;

        public void accessOuterProp() {
            // 非静态内部类可以直接访问外部类的private实例变量
            System.out.println("外部类的outProp值：" + outProp);
        }
    }

    public void accessInnerProp() {
        // 外部类不能直接访问非静态内部类的实例变量
        // 下面代码出现编译错误
        // System.out.println("内部类的inProp值："+inProp);

        /**
         * 之所以会这样是因为这时在①处，只是创建了一个外部类对象，并调用外部类对象的accessInnerProp（）方法。此时非静态内部类对象根本就不存在，
         * 如果允许accessInnerProp()方法访问非静态内部类的实例成员，将肯定引发错误
         */



        // 如需访问内部类的实例变量，必须显式创建内部类对象
        System.out.println("内部类的inProp值：" + new Inner().inprop);
    }

    public static void main(String[] args) {
        // 执行下面代码，只创建了外部类对象，还未创建内布类对象
        var out = new Outer();//①
        out.accessInnerProp();
    }
}
