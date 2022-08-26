package chapter8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SortTest {
    public static void main(String[] args) {
        ArrayList<Integer> nums =  new ArrayList<>();
        nums.add(2);
        nums.add(-5);
        nums.add(3);
        nums.add(0);
        System.out.println(nums);
        Collections.reverse(nums);//会将nums集合顺序反转
        System.out.println(nums);
        Collections.sort(nums);//将List集合元素按照自然顺序排列
        System.out.println(nums);
        Collections.shuffle(nums);//将list集合元素随机顺序排列
        System.out.println(nums);
    }
}
