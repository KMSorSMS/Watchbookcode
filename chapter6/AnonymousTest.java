package chapter6;

interface Product{
    double getprice();
    String getName();
}

public class AnonymousTest {
    public void test(Product p){
        System.out.println("购买了一个"+p.getName()+",花掉了"+p.getprice());
    }
    public static void main(String[] args) {
        var ta = new AnonymousTest();
        //此处调用test方法时，需要传入一个Product参数
        //此处传入其匿名实现类的实例
        ta.test(new Product() {
         public double getprice(){
            return 567.8;
         }   
         public String getName(){
            return "AGP显卡";
         }
        });
    }
}
