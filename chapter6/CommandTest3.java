package chapter6;
/*
 * 在CommandTest2中为了向process方法中传递具体的command接口的实现操作
 * 创建了匿名内部类，语法很繁琐
 */

public class CommandTest3 {
    public static void main(String[] args) {
        var pa = new ProcessArray();
        int[] array = {3,-4,6,4};
        //处理数组，具体行为取决于Lambda表达式
        pa.process(array, (int element)->{System.out.println("数组元素的平方是："+element*element);});
    }
}
