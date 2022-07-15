package chapter6;

import java.io.CharArrayReader;

class CacheImmutable {
    private static int MAX_SIZE = 10;
    // 使用数组来缓存已有的实例
    private static CacheImmutable[] cache = new CacheImmutable[MAX_SIZE];
    // 记录缓存实例在缓存中的位置，cache[pos-1]是最新缓存的实例
    private static int pos = 0;
    private final String name;

    // 把构造器隐藏，留出valueof来创造实例，这样才能去制造缓存过程
    private CacheImmutable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static CacheImmutable valueOf(String name) {
        // 遍历已缓存的对象
        for (var i = 0; i < MAX_SIZE; i++) {
            // 如果已有相同的实例，则直接返回该缓存的实例
            if (cache[i] != null && cache[i].getName().equals(name)) {
                return cache[i];
            }
        }
        // 如果缓存池已满
        if (pos == MAX_SIZE) {
            // 把缓存的第一个对象覆盖，即把刚刚生成的对象放在缓冲池的最开始位置
            cache[0] = new CacheImmutable(name);
            // 把pos设为1
            pos = 1;
        } else {
            // 把新建的对象缓存起来，pos+1
            cache[pos++] = new CacheImmutable(name);
        }
        return cache[pos - 1];
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == CacheImmutable.class) {
            var ci = (CacheImmutable) obj;
            return name.equals(ci.getName());
        }
        return false;
    }

    public int hashCode() {
        return name.hashCode();
    }
}

public class CacheImmutableTest {
    public static void main(String[] args) {
        var c1 = CacheImmutable.valueOf("hello");
        var c2 = CacheImmutable.valueOf("hello");
        //因为缓存机制的原因会输出true
        System.out.println(c1==c2);
    }
}
