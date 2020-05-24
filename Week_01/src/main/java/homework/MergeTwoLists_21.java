package homework;

/**
 * @author Echo
 * @date 2020/5/24 4:11 下午
 */
public class MergeTwoLists_21 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode res = null;
        if (l2.val > l1.val) {
            //res = l1;
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            //res = l2;
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
}
