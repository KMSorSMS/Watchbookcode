package chapter6;

/**
 * 在java8之前，Java要求被局部内部类、匿名内部类访问的局部变量必须使用final修饰，从Java8开始这个限制被取消了
 * java8更加智能：如果局部变量被匿名内部类访问，那么局部变量相当于自动使用了final修饰。例如如下程序：
 */
interface A {
    void test();
}

public class Atest {
    public static void main(String[] args) {
        int age = 8;//1
        //如果加上这条语句就会报错：因为age相当于被final修饰了，它被匿名内部类访问过后
        // age = 2;//必须把age当成 final修饰的用才能被匿名内部类访问
        var a = new A() {
            public void test() {
                // 在java8以前下面语句将提示错误：age必须使用final修饰
                // 从java8开始，匿名内部类、局部内部类允许访问非final的局部变量
                System.out.println(age);
            }
        };
        a.test();
    }
}
