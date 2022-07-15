package chapter6;

public class GenderTest {
    public static void main(String[] args) {
        //为什么可以这样？？？
        Gender g = Gender.valueOf("FEMALE");
        // g.setName("女");
        System.out.println(g+"代表："+g.getName());
        //此时设置name值时将会提示参数错误
        // g.setName("男");
        System.out.println(g + "代表："+g.getName());
        g = Gender.FEMALE;
        System.out.println(g + "代表："+g.getName());
        g.info();

    }
}
