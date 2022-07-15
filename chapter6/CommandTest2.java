package chapter6;

/**
 * Lambda表达式时java8的新功能：
 * 将代码块作为方法参数，允许使用更简洁的代码来创建只有一个抽象方法的接口（这种接口被称为函数式接口）的实例
 * 下面先是用匿名内部类改写command
 */
public class CommandTest2 {
    public static void main(String[] args) {
        var pa = new ProcessArray();
        int[] target = {3,-4,6,4};
        //处理数组，具体行为取决于匿名内部类
        pa.process(target, new Command() {
            public void process(int element){
                System.out.println("数组元素的平方是："+element*element);
            }
        });
    }
}
