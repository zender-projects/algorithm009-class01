package homework;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Echo
 * @date 2020/5/24 5:30 下午
 */
public class RewriteDeque {

    public static void main(String[] args) {

        Deque<String> deque = new LinkedList<>();

        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);

        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);

        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }
}
