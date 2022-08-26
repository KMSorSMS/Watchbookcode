package chapter11;

import java.awt.Canvas;
import java.awt.*;

public class TestPos {
    private MyCanvas2 table = new MyCanvas2();
    private int ballx = 0;
    private int bally = 100;
    private int ballSize = 20;
    private int size = 500;
    private Frame f = new Frame("Test");
    
    class MyCanvas2 extends Canvas{
        //重写Canvas的paint()方法,实现绘画
        public void paint(Graphics g){
          g.setColor(new Color(240,240,80));
            g.fillOval(ballx, bally, ballSize, ballSize);
        }
    }
    public void init(){
        f.add(table);
        table.repaint();
        table.setPreferredSize(new Dimension(size,size));
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new TestPos().init();
    }
}
