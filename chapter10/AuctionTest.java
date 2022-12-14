package chapter10;

class AuctionException extends Exception
{
    //无参数构造器
   public AuctionException(){}
   //带一个字符串参数的构造器
   public AuctionException(String msg){
    super(msg);
   }
}

public class AuctionTest {
    private double initPrice = 30.0;
    //因为该方法中显式抛出了AuctionException异常
    //所以此处需要声明抛出AuctionException异常
    public void bid(String bidPrice) throws AuctionException {
        var d = 0.0;
        try{
            d = Double.parseDouble(bidPrice);
        }
        catch(Exception e){
            //此处完成本方法中可以对异常执行的修复处理
            //此处仅仅是在控制台打印异常的跟踪栈信息
            e.printStackTrace();
            //再次抛出自定义异常
            throw new AuctionException("竞拍价格必须是数值，不能包含其它字符");
        }
        if(initPrice>d){
            throw new AuctionException("竞拍价格比起拍价格低，不允许竞拍");
        }
        initPrice = d;
    }
    public static void main(String[] args) {
        var at = new AuctionTest();
        try{
            at.bid("-11");
        }
        catch(AuctionException ae){
            //再次捕获到bid()方法中的异常，并对该异常进行处理
            System.err.println(ae.getMessage());
        }
    }
}
