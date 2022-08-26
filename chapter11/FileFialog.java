package chapter11;

import java.awt.*;

public class FileFialog {
    Frame  f = new Frame("测试");
    FileDialog d1 = new FileDialog(f,"选择需要打开的文件",FileDialog.LOAD);
    FileDialog d2 = new FileDialog(f,"选择文件的保存路径",FileDialog.SAVE);
    Button b1 = new Button("打开文件");
    Button b2 = new Button("保存文件");
    public void init()
    {
        b1.addActionListener(e -> {
            d1.setVisible(true);
            
            String str = d1.getDirectory()+d1.getFile();
            if(str.matches(".+\\.(jpg|png|gif)$")){
            System.out.println("匹配上了");
            }
            System.out.println(d1.getDirectory()+d1.getFile());
        });
        b2.addActionListener(e -> {
            d2.setVisible(true);
            //
            System.out.println(d2.getDirectory()+d2.getFile());

        });
        f.add(b1);
        f.add(b2,BorderLayout.SOUTH);
        f.pack();
        f.setVisible(true);
    }
    public static void main(String[] args) {
        new FileFialog().init();
    }
}
