package chapter6;

public class EnumTest {
    public void fuck(String name){
        System.out.println("fuck"+name);
    }
    public void fuck(int name){
        System.out.println("fuck you "+name);
    }
    public void judge(SeasonEnum s){
        //switch语句里的表达式可以是枚举类
        switch(s){
            case SPRING:
                System.out.println("春暖花开，正好踏青");
                break;
            case SUMMER:
                System.out.println("夏日炎炎，适合游泳");
                break;
            case FALL:
                System.out.println("秋高气爽，进补及时");
                break;
            case WIHTER:
                System.out.println("冬日雪飘，围炉赏雪");
                break;
        }
    }
    public static void main(String[] args) {
        //枚举类默认有一个values()方法，返回该枚举类的所有实例
        for(var s:SeasonEnum.values()){
            System.out.println(s);
            new EnumTest().judge(s);
        }

        //使用枚举实例时，可通过EnumClass.variable形式来访问
        new EnumTest().judge(SeasonEnum.SPRING);
        new EnumTest().fuck("happy");
        new EnumTest().fuck(8);
    }
}
