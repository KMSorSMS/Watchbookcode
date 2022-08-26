package chapter8;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String,Integer> map = new HashMap<>();
        //成对的放入多个Key-value对
        map.put("疯狂Java讲义",109);
        map.put("疯狂ios讲义",10);
        map.put("疯狂Ajax讲义",79);
        //多次放入的key-value对中value可以重复
        map.put("轻量级Java EE企业级实战", 79);
        //放入重复的key时，新的value会覆盖原有的value
        //如果该新的value覆盖了原有的value，该方法返回被覆盖的value
        System.out.println(map.put("疯狂ios讲义",99));//输出10
        System.out.println(map);//输出的Map集合包含4个key-value对
        //判断是否包含指定的key
        System.out.println("是否包含值为疯狂ios讲义的key："+map.containsKey("疯狂ios讲义"));
        //判断是否包含指定的value
        System.out.println("是否包含值为99的value："+map.containsValue(99));
        //获取Map集合的所有key组成的集合，通过遍历key来实现遍历所有的key-value对
        for(var key:map.keySet()){
            //map.get(key)方法获取指定key对应的value
            System.out.println(key + "-->" + map.get(key));
        }
        for(Map.Entry<String,Integer> mentry :map.entrySet()){
           System.out.println(mentry.getKey()); 
        }
        map.remove("疯狂Ajax讲义");//根据key来删除key-value对
        System.out.println(map);//输出的结构就不包含疯狂Ajax讲义=79的key-value对
    }
}
