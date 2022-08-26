package chapter11;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

public class TestGraphics {
    static BufferedImage image = new BufferedImage(500,500,BufferedImage.TYPE_INT_RGB);
    static Graphics g = image.getGraphics();

    public static void main(String[] args) {
        Frame f = new Frame("airnm");
        g.setColor(new Color(255,0,0));
        g.fillRect(0,0,500,500);
        DrawCanvas drawArea = new DrawCanvas();
        drawArea.setPreferredSize(new Dimension(500,500));
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
        f.add(drawArea);
        f.pack();
        f.setVisible(true);

    }
    static class DrawCanvas extends Canvas
    {
    // //重写Canvas的paint方法，实现绘画
    // public void paint(Graphics g)
    // {
    //     //将image绘制到该组件上
    //     g.drawImage(image,0,0,null);

    // }
    public void paint(Graphics g)
    {
        g.drawImage(image,0,0,null);    
    }
}
}
