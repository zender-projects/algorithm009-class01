package leetcode;

/**
 * @author Echo
 * @date 2020/5/24 10:20 上午
 *
 * 两两交换链表中的节点
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class SwapPairs {

    /***
     *  递归
     *  利用递归，能够轻松操作三个指针  head  next   next.next
     */
    public ListNode swapPairs(ListNode head) {
        //遍历到最后，head == null
        if (head == null || head.next == null) {
            //return null
            return head;
        }
        //持有next
        ListNode next = head.next;
        //持有next.next
        ListNode nextNext = swapPairs(next.next);
        head.next = nextNext;
        next .next = head;
        return next;
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
