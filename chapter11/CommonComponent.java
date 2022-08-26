package chapter11;

import java.awt.*;

import javax.swing.Box;

public class CommonComponent {
    Frame f = new Frame("测试");
    //定义一个按钮
    Button ok = new Button("确认");
    CheckboxGroup cbg = new CheckboxGroup();
    //定义一个单选框(处于cbg一组)，初始处于被选中状态
    Checkbox male = new Checkbox("男",cbg,true);
    //
    Checkbox female = new Checkbox("女",cbg,false);
    //
    Checkbox married = new Checkbox("是否已婚",true);
    //
    Choice colorChooser = new Choice();
    //
    List colorList = new List(6, true);
    //
    TextArea ta = new TextArea(5,20);
    //
    TextField name = new TextField(50);
    public void init(){
        colorChooser.add("RED");
        colorChooser.add("BLUe");
        colorChooser.add("YELLOW");
        colorChooser.add("BROWN");
        colorList.add("GREEN");
        colorList.add("PURPLE");
        colorList.add("BLUE");
        //
        var bottom = new Panel();
        bottom.add(name);
        bottom.add(ok);
        f.add(bottom,BorderLayout.SOUTH);
        //
        var checkPanel = new Panel();
        checkPanel.add(colorChooser);
        checkPanel.add(male);
        checkPanel.add(female);
        checkPanel.add(married);
        //
        var topLeft = Box.createVerticalBox();
        topLeft.add(ta);
        topLeft.add(checkPanel);
        //
        var top = Box.createHorizontalBox();
        top.add(topLeft);
        top.add(colorList);
        //
        f.add(top);
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new CommonComponent().init();
    }
}
