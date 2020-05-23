package leetcode;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Echo
 * @date 2020/5/23 11:35 上午
 */
public class MyLruCache {

    private LinkedHashMap<Integer, Integer> cache;

    public MyLruCache(final int capacity) {
        cache = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        return cache.get(key) == null ? -1 : cache.get(key);
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }

    public static void main(String[] args) {
        MyLruCache cache = new MyLruCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3,3);
        System.out.println(cache.get(2));
    }
}
