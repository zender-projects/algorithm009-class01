package leetcode;

/**
 * @author Echo
 * @date 2020/5/23 6:59 下午
 *
 * 链表翻转.
 */
public class LinkedListReverse_206 {

    /**
     * 递归实现
     * */
    public ListNode reverseList(ListNode node) {

        if (node.next == null) {
            return node;
        }

        ListNode n = reverseList(node.next);
        node.next.next = node;
        node.next = null;
        return n;
    }

    /**
     * 循环实现
     * */
    public ListNode reverseList2(ListNode node) {

        ListNode newRoot = null;
        ListNode cur = node;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = node.next;
            //找到了最后一个节点
            if (next == null) {
                newRoot = cur;
            }
            //向前推进
            cur.next = prev;
            prev = cur;
            cur = newRoot;
        }
        return newRoot;
    }


    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}
