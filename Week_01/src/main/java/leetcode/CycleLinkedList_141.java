package leetcode;

import java.util.HashSet;

/**
 * @author Echo
 * @date 2020/5/23 11:15 下午
 *
 * 判断链表中是否有环
 */
public class CycleLinkedList_141 {


    /**
     * 计数的实现方式，如果存在环，那么在遍历链表的过程中
     * Set中一定会首先发现入环节点重复
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * */
    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            }else {
                set.add(head);
                head = head.next;
            }
        }
        return false;
    }


     /**
      * 快慢指针
      * 时间复杂度：O(n)
      * 空间复杂度：O(1)
      * */
    public boolean hasCycle2(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slowPoint = head;
        ListNode fastPoint = head.next;
        while (slowPoint != fastPoint) {
            //没有环的话，fast指针最终就会变为null
            //由于下面要用到next.next 所以要对fastPoint.next 判空
            if (fastPoint == null || fastPoint.next == null) {
                return false;
            }
            slowPoint = slowPoint.next;
            fastPoint = slowPoint.next.next;
        }
        //找到了 slow == fast
        return true;

    }



    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
