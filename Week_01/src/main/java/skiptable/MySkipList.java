package skiptable;

import java.util.Arrays;
import java.util.Random;

/**
 * @author Echo
 * @date 2020/5/23 1:21 下午
 *
 * 跳表 实现
 * https://www.geeksforgeeks.org/skip-list/
 *
 * 跳表，是为了解决有序链表的 查找 操作的性能问题，具体的思路是通过建立多级索引 实现对原始链表中元素的快速定位。
 *
 * 理想情况下，第一级索引的节点个数为 原始链表的 1/2，也就是说每隔一个节点就存在一个索引，这样再查找原始链表中的
 * 数据的时候，就类似于二分搜索。
 *
 * 在具体实现的时候，如果维护索引层节点数量的绝对1/2关系会比较困难，但从概率上来讲，当原始链表中的数量足够多是，即使
 * 节点层中节点数量的关系不是严格意义的1/2关系，也是可以保证整个跳表的时间复杂度为O(n)，这样再添加数据的时候，要不要将
 * 这个节点添加到索引层，就通过随机的方式来决定，每种情况的概率都是1/2、
 *
 * 跳表的实现：
 *
 * redis的有序集合为什么使用跳表实现：
 */
public class MySkipList {

    //最大索引层级
    private static final int MAX_LEVEL = 16;

    private Random random;

    private int levelCount;

    private Node head; // 表头，表头内部包含了一个Node类型的数组，这个数组就存储了索引层

    public MySkipList() {
        levelCount = 1;
        head = new Node();
        random = new Random();
    }

    /**
     * 向跳表中插入数据
     * */
    public void insert(int data) {
        int level = randomLevel();  //拿到随机的索引层

        /**
         * 创建一个新的节点
         * 设置数据
         * 设置当前节点被添加到的索引层的最大层数
         * */
        Node newNode = new Node();
        newNode.data = data;
        newNode.maxLevel = level;// 这里用Node节点的maxNode记录当天Node对应的索引层

        /**
         *
         * 初始化索引
         * */
        Node[] forward = new Node[level]; //创建一个leve大小的数组，用来存储索引
        for(int i = 0;i < level;i ++) {
            forward[i] = head;
        }


        Node p = head;
        for (int i = level - 1;i >= 0;i ++) {
            while (p.forwards[i] != null && p.forwards[i].data < data) {
                p = p.forwards[i];
            }
            forward[i] = p;
        }
    }



    /**
     * 这个函数决定了将新加入的值放到那一层索引中
     * */
    private int randomLevel() {
        int level = 1;
        for (int i = 1;i < MAX_LEVEL;i ++) {
            //如果是基数level + 1
            if(random.nextInt() % 2 == 1) {
                ++ level;
            }
        }
        return level;
    }

    static class Node {
        private int data = -1;
        private Node[] forwards = new Node[MAX_LEVEL];
        private int maxLevel= 0;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", forwards=" + Arrays.toString(forwards) +
                    ", maxLevel=" + maxLevel +
                    '}';
        }
    }
}
