package chapter6;

abstract class Device{
    /**
     * 回忆：
     * 有抽象方法的类一定是抽象类
     * 抽象类不一定有抽象方法，但他就不能制造实例，这种就是只有abstract修饰类
     */
    private String name;
    //抽象方法
    public abstract double getprice();
    //Device的无参数构造器
    public Device(){}
    public Device(String name){
        this.name = name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

}

public class AnonymousInner {
    public void test(Device d){
        System.out.println("购买了一个"+d.getName()+"，花掉了"+d.getprice());
    }
    public static void main(String[] args){
        var ai = new AnonymousInner();
        //调用有参数的构造器创建Device匿名实现类的对象
        ai.test(new Device("电子示波器"){
            public double getprice(){
                return 67.8;
            }
        });
        ai.test(new Device() {
            {
                System.out.println("匿名内部类的初始化块");
         super.setName("键盘"); 
            }
            public double getprice(){
                return 99.9;
            }  
        });
    }
}
