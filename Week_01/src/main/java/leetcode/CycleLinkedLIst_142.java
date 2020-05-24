package leetcode;

import java.util.HashSet;

/**
 * @author Echo
 * @date 2020/5/24 8:38 上午
 *
 * 唤醒链表，找到入环节点
 */
public class CycleLinkedLIst_142 {


    /**
     * 利用set，找到第一个重复的节点，即为入环节点
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     * */
    public ListNode detectCycle(ListNode head) {
            HashSet<ListNode> set = new HashSet<>();
            while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }


    /**
     * 双指针夹B法
     * */
    public ListNode detectCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            //找到了 fast 追上 slow的点
            if (fast == slow) {
                //slow 退回到head，然后 slow 和fast向中间夹B，相遇的位置即为入环点
                slow  = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return fast;
            }
        }
        return null;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
