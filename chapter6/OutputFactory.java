package chapter6;

public class OutputFactory {
    public Output getOutput(){
        return new BetterPrinter();
    }
    public static void main(String[] args) {
        var of = new OutputFactory();
        var c = new Computer(of.getOutput());
        c.KeyIn("轻量级Java EE 企业应用实战");
        c.KeyIn("疯狂Java讲义");
        c.print();
    }
}
