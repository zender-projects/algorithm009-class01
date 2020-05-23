package linked;

/**
 * @author Echo
 * @date 2020/5/23 9:58 上午
 *
 * 链表 和 数组一样，都是线性数据结构，但与数组不同的是，链表中的数据不是存在在一块连续的内控空间
 * 而是通过指针将不同的内存地址链接起来，所以，链表不存在扩容问题。
 *
 * 链表通过Node节点来存储数据和与其他Node节点进行连接，相对于数组，链表对于新增和删除操作更加高效
 * 因为它不需要移动数据，但链表不适合随机查找，因为链表内部本质是只只持有了头结点的指针，查找任何一个
 * 元素都需要从头节点开始向后遍历。
 *
 * 时间复杂度：
 * 查找：O(n)
 * 删除：O(1)
 * 增加：O(1)
 */
public class MyLinkedList<E> {

    /** dummy head 用于统一对链表的操作逻辑 */
    private Node<E> dummyHead;
    private int size;


    public MyLinkedList() {
        this.dummyHead = new Node<E>();
        this.size = 0;
    }

    /**
     * 查找
     * */
    public E get(int index) {
        checkBoundExclusive(index);
        Node<E> cur = dummyHead;
        for (int i = 0;i <= index;i ++) {
            cur = cur.next;
        }
        return cur.data;
    }

    /**
     * 修改
     * */
    public E set(int index, E e) {
        checkBoundExclusive(index);
        Node<E> cur = dummyHead;
        for (int i = 0;i <= index;i ++) {
            cur = cur.next;
        }
        E ret = cur.data;
        cur.data = e;
        return ret;
    }

    /**
     * 在指定位置 增加
     * */
    public void add(int index, E e) {
        checkBoundInclusive(index);
        Node<E> cur = dummyHead;
        //找到index的前一个节点
        for (int i = 0;i < index;i ++) {
            cur = cur.next;
        }
        cur.next = new Node(e, cur.next);
        this.size ++ ;
    }

    /**
     * 在指定位置删除
     * */
    public E remove(int index) {
        checkBoundExclusive(index);
        Node<E> cur = dummyHead;
        //找到待删除位置的前一个节点
        for (int i = 0;i < index;i ++) {
            cur = cur.next;
        }
        Node<E> delNode = cur.next;
        cur.next = delNode.next;
        delNode.next = null;
        this.size -- ;
        return delNode.data;
    }

    private void checkBoundInclusive(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }

    private void checkBoundExclusive(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Node节点，单链表
     * */
    static class Node<E> {
        E data;
        Node<E> next;
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
        public Node(E data) {
            this(data, null);
        }
        public Node() {
            this(null, null);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Linked List [ ");
        Node<E> cur = dummyHead.next;
        while (cur != null) {
            stringBuilder.append(cur.data + " ");
            cur = cur.next;
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(0, 1);
        linkedList.add(0, 2);
        linkedList.add(0, 3);
        linkedList.add(1, 5);
        System.out.println(linkedList);
        linkedList.remove(2);
        System.out.println(linkedList);
    }
}
