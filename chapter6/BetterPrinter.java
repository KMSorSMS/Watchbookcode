package chapter6;

public class BetterPrinter implements Output {
    private String[] printData = new String[MAX_CACHE_LINE*2];
    //用以记录当前需要打印的作业数
    private int dataNum = 0;
    /**
     * 实现接口的抽象方法
     */
    public void out(){
        //只要还有作业就继续打印
        while(dataNum > 0){
            System.out.println("高速打印机正在打印："+printData[0]);
            //把作业队列整体前移一位，并将剩下的作业数-1
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }
    public void getData(String msg){
        if(dataNum>=MAX_CACHE_LINE*2){
            System.out.println("输出队列已满，添加失败");
        }
        else{
            //把打印数据添加到队列里，已保存数据的数量+1
            printData[dataNum++] = msg;
        }
    }
}
