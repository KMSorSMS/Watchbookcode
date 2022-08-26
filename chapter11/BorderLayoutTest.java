package chapter11;

import java.awt.*;

public class BorderLayoutTest {
    public static void main(String[] args) {
        Frame f = new Frame("Test Window");
        //设置Frame容器用BorderLayout布局管理器
        f.setLayout(new BorderLayout(30,5));
        f.add(new Button("south"), BorderLayout.SOUTH);
        f.add(new Button("North"),BorderLayout.NORTH);
        //默认添加到中间区域
        f.add(new Button("中"),BorderLayout.CENTER);
        f.add(new Button("东"),BorderLayout.EAST);
        f.add(new Button("西"),BorderLayout.WEST);
        //设置窗口为最佳大小
        f.pack();
        //将窗口显示出来(Frame对象默认处于隐藏状态)
        f.setVisible(true);
    }
}
