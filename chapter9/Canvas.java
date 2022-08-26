package chapter9;

import java.util.ArrayList;
import java.util.List;

public class Canvas {
    ///同时在画布上绘制多个形状
    public void drawAll(List<? extends Shape> shapes){
        for(var s: shapes){
            s.draw(this);
        }
    }
    public static void main(String[] args) {
        List<Circle> circles = new ArrayList<>();
    }
}
