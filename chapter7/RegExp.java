package chapter7;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegExp {
    public static void main(String[] args) {

        // String content = "abcaBc\u004138";
        // String content = "123-abc";
        // String content = "oiajfi o7789 nn1189han";
        String content = "Yzw教育 Yzw同学 Yzw老师";
        // String regStr = "^[0-9]+[a-z]*";
        // //以至少一个数字开头，必须以至少一个小写字母结束； 
        // String regStr = "^[0-9]+\\-[a-z]+$";
        /*
         * 下面就是非命名分组
         * 说明：
         * 1.matcher.group(0)得到匹配到的字符串
         * 2.matcher.group(1)得到匹配到的字符串的第1个分组内容
         * 3.matcher.group(2)得到匹配到的字符串的第2个分组内容
         */
        // String regStr = "(\\d\\d)(\\d\\d)";
        /**
         * 命名分组：即可以给分组取名
         */
        // String regStr = "(?<g1>\\d\\d)(?<g2>\\d\\d)";
        // String regStr = "Yzw(老师|同学|教育)";
        String regStr = "Yzw(?:老师|同学|教育)";
        Pattern pattern = Pattern.compile(regStr);
        Matcher matcher = pattern.matcher(content);
        while(matcher.find()){
            System.out.println("找到 "+matcher.group(0));
            // System.out.println("通过编号找到 "+matcher.group(1));
            // System.out.println("通过组名找到 "+matcher.group("g1"));
            // System.out.println("通过编号找到 "+matcher.group(2));
            // System.out.println("通过组名找到 "+matcher.group("g2"));

        }
    }
}
