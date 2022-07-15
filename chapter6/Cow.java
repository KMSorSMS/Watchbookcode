package chapter6;

public class Cow {
    private double weight;

    // 外部类的两个重载的构造器
    public Cow() {
    }

    public Cow(double weight) {
        this.weight = weight;
    }

    // 定义一个非静态内部类
    private class Cowleg {
        // 非静态内部类的两个实例变量
        private double length;
        private String color;

        // 非静态内部类的两个重载的构造器
        public Cowleg() {
        }

        public Cowleg(double length, String color) {
            this.length = length;
            this.color = color;
        }
        public void setLength(double length) {
            this.length = length;
        }
        public double getLength() {
            return length;
        }
        public void setColor(String color) {
            this.color = color;
        }
        public String getColor() {
            return color;
        }
        //非静态内部类的private修饰的成员变量
        public void info(){
            System.out.println("当前牛腿的颜色是："+color+",高："+length);
            //直接访问外部类的private修饰的成员变量
            System.out.println("本牛腿所在奶牛重："+weight);
        }
    }
    public void test(){
        var cl = new Cowleg(1.12,"黑白相间");
        cl.info();
    }
    public static void main(String[] args) {
        var cow = new Cow(378.9);
        cow.test();
    }
}
