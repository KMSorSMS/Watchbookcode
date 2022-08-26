package chapter8;


class A {
public void print(){
    System.out.println("google");
}
}
class B extends A{
    public void SayHello(){
        System.out.println("good");
    }
}

public class TestJavahw {
    public static void main(String[] args) {
        Object[] obj = new Object[10];
        obj[1] = new String();
        obj[2] = 11.0;
        A[] a = new A[3];
        a[0] = new B();
        a[1] = new A();
        a[0].print();
        ((B)a[0]).SayHello();
        a[1].print();
        

    }
}
