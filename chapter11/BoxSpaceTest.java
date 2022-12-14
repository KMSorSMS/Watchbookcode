package chapter11;

import java.awt.*;

import javax.swing.Box;

public class BoxSpaceTest {
    private Frame f = new Frame("测试");
    //定义水平摆放组件的Box对象
    private Box horizontal = Box.createHorizontalBox();
    //
    private Box vertical = Box.createVerticalBox();
    public void init()
    {
        horizontal.add(new Button("水平按钮一"));
        horizontal.add(Box.createHorizontalGlue());
        horizontal.add(new Button("水平按钮二"));
        //
        horizontal.add(Box.createHorizontalStrut(10));
        horizontal.add(new Button("水平按钮三"));
        vertical.add(new Button("垂直按钮一"));
        vertical.add(Box.createVerticalGlue());
        vertical.add(new Button("垂直按钮二"));
        //
        vertical.add(Box.createVerticalStrut(10));
        vertical.add(new Button("垂直按钮三"));
        f.add(horizontal,BorderLayout.NORTH);
        f.add(vertical);
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new BoxSpaceTest().init();
    }
}
