package chapter7;

public class IdentityHashCode {
    public static void main(String[] args) {
        //下面程序中s1和s2是两个不同的对象
        var s1 = new String("Hello");
        var s2 = new String("Hello");
        //因为String重写了hashCode（）方法----改为根据字符序列计算hashCode值
        //因为s1和s2的字符序列相同，所以它们的hashCode（）返回值相同
        System.out.println(s1.hashCode()+"------"+s2.hashCode());
        System.out.println(s1+"-------------------------------------"+s2);
        //s1和s2是不同的字符串对象，所以它们的identityHashCode值不同
        System.out.println(System.identityHashCode(s1)+"------"+System.identityHashCode(s2));
        var s3 = "Java";
        var s4 = "Java";
        //s3和s4 是相同的字符串对象，在常量吃里面，所以它们的identityHashCode值相同
        System.out.println(System.identityHashCode(s3)+"----------------------"+System.identityHashCode(s4));
    }
}
