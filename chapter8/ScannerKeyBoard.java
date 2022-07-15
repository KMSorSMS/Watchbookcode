package chapter8;

import java.io.File;
import java.util.Scanner;

public class ScannerKeyBoard {
    public static void main(String[] args) 
    throws Exception
    {
        //System.in代表标准输入，就是键盘输入。
        // var sc = new Scanner(System.in);
        //增加下面一行将只把回车作为分隔符
        //sc.useDelimiter("\n");
        //判断是否还有下一个输入项
        // while(sc.hasNext()){
        //     //输出刷入项
        //     System.out.println("键盘的输入内容是："+sc.next());
        // }
        // // System.out.println(sc.hasNext());
        // // System.out.println("键盘的输入内容是："+sc.next());
        
        // //判断是否还有下一个long型整数
        // while(sc.hasNextLong()){
        //     //输出输入项
        //     System.out.println("键盘输入的内容是："+sc.nextLong());
        // }

        // //判断是否还有下一行
        // while(sc.hasNextLine()){
        //     //输出输入项
        //     System.out.println("键盘输入的内容是："+sc.nextLine());
        // }

        //将一个File对象作为scanner的构造器参数，Scanner读取文件内容
        var sc = new Scanner(new File("testfile.txt"));
        //判断是否还有下一行
        while(sc.hasNextLine()){
            //输出文件中的下一行
            System.out.println(sc.nextLine());
        }
    }
}
