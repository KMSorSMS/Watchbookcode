package chapter11;

import java.awt.*;
import java.awt.event.*;

public class MultiListener {
    private  Frame f = new Frame("测试");
    private TextArea ta = new TextArea(6,40);
    private Button b1 = new Button("按钮1");
    private Button b2 = new Button("按钮2");
    public void init()
    {
        //
        var f1 = new FirstListener();
        //
        b1.addActionListener(f1);
        b1.addActionListener(new SecontListener());
        //
        b2.addActionListener(f1);
        b2.addActionListener(f1);
        f.add(ta);
        var p = new Panel();
        p.add(b1);
        p.add(b2);
        f.add(p,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
    class FirstListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e){
            ta.append("第一个事件监听器被触发，事件源是："+e.getActionCommand()+"\n");

        }

    }
    class SecontListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e){
            ta.append("第二个事件监听器被触发，事件源是："+e.getActionCommand()+"\n");

        }
        
    }
    public static void main(String[] args) {
        new MultiListener().init();
    }
}
