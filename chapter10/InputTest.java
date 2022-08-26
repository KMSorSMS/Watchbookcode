package chapter10;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String str = "";

        // while (sc.hasNext()) {
        //     try {
        //         if (((str = sc.next()) instanceof String)) {
        //             break;
        //         }
        //         throw new Exception("应该输入字符串");
        //     } 
        //     catch (Exception e) {
        //         System.out.println(e.getMessage());
        //         continue;
        //     }
        // }

    //     /**
    //      * 是catch放在while里面
    //      */

    //     Scanner sc = new Scanner(System.in);
    //     String inpuString = null;
    //     while ((inpuString = sc.nextLine()) != null) {
    //         try {
    //             String[] posStrArr = inpuString.split(",");
    //             var xPos = Integer.parseInt(posStrArr[0]);
    //             var yPos = Integer.parseInt(posStrArr[1]);
    //         } catch (Exception e) {
    //             System.out.println("不合法输入");
    //             continue;
    //         }
    //     }
    }
}
