package chapter9;

class Superfa{
    String name;
    public Superfa(String name){
        this.name = name;
    }
    public Superfa(){}
}


public class TestSub extends Superfa {
    public void setName(String name){
        this.name = name;
    }
}
