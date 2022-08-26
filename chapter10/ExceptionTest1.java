package chapter10;

/**
 * 检测抛出异常后，后面的程序是否会执行
 * 
 */

public class ExceptionTest1 {
    public static void main(String[] args) {
        try{
            System.out.println("我下面就抛出exception异常");
            throw new Exception("我出错了");
        }
         

        catch(Exception e){
            System.out.println(e.getMessage());

        }
        System.out.println("我还会被执行吗？");
    }
}
