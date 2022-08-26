package chapter9;

import java.util.ArrayList;
import java.util.List;

public class GenericAndArray {
    public static void main(String[] args) {
        List<?>[] lsa = new ArrayList<?>[10];
        ArrayList<String> ls = new ArrayList<>();
        ls.add("fuck");
        ArrayList<Integer> li = new ArrayList<>();
        li.add(3);
        lsa[1] = li;
        lsa[2] = ls;
        Object target = lsa[2].get(0);
        if(target instanceof String){
            //下面代码安全了
            var s = (String) target;
            System.out.println(s);
        }        
    }
}
