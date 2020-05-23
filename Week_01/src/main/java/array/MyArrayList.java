package array;

/**
 * @author Echo
 * @date 2020/5/22 10:47 下午
 *
 * 基于数组实现动态数组。
 *
 * 数组可以理解成一段连续的、有限的内存空间，数组能够实现基于 首地址 + 偏移量 的随机访问特性，
 * 所以，如果要实现随机访问，那数组是最好的选择，在数组中进行随机增加 和 删除时，由于需要移动
 * 数据，所以效率并不是很高。
 *
 * 时间复杂度：
 * 查找：O(1)
 * 删除：O(n)
 * 增加：O(n)
 *
 * 数组的最大局限性在于空间有限，所以类似于Java的高级编程语言提供了基于数组的动态数组，比如ArrayList
 * ArrayList 底层基于数组实现，简单理解就是 当数组空间不足时，就开辟出一块更大的空间，然后把数据
 * 复制到新的数组中。
 *
 * 在使用ArrayList时，如果能够提前知道要存储的数据量，可以在初始化时给定一个容量，这样可以避免
 * 底层数组扩容，提升性能。另外，Java的ArrayList提供了一种快速失效的迭代器，即在迭代的过程中
 * 对ArrayList的任何修改都会使得Iterator迭代器快速失败。
 *
 * ArrayList是一个非线程安全的容器，可以通过Collections.synchronized(new ArrayList)来得到一个线程安全的容器
 * 也可以通过CopyOnWriteArrayList来替代ArrayList
 */
public class MyArrayList<T> {

    private T[] data;
    private int size;

    private static int DEFAULT_CAPACITY = 10;

    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        this.data = (T[])new Object[capacity];
        this.size = 0;
    }

    /**
     * 查找
     * */
    public T get(int index) {
        checkBoundExclusive(index);
        return this.data[index];
    }

    /**
     * 更新
     * */
    public T set( int index, T e) {
        checkBoundExclusive(index);
        T ret = this.data[index];
        this.data[index] = e;
        return ret;
    }

    /**
     * 新增
     * */
    public boolean add(T e) {
        //checkBoundExclusive(index);
        //如果没有额外的空间，就扩容
        if (size == data.length) {
            //默认扩容为原来的两倍
            ensureCapacity(size + 1);
        }
        data[size ++] = e;
        return true;
    }

    /**
     * 在指定位置新增
     * */
    public boolean add(int index, T e) {
        checkBoundExclusive(index);
        if (size == data.length) {
            ensureCapacity(size + 1);
        }
        //将所有index极其后面的元素向后移动一个位置
        /**
         *   index = 1 size = 6
         * e e e e e e
         *
         * */
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        this.size ++ ;
        return true;
    }



    private void ensureCapacity(int minCapacity) {
        int current = this.data.length;
        if (minCapacity > current) {
            //这里max是为了防止minCapacity一下子变得很大的情况
            T[] newDate = (T[])new  Object[Math.max(current * 2, minCapacity)];
            //复制数据到新的数组中
            System.arraycopy(data, 0, newDate, 0, size);
            this.data = newDate;
        }
    }

    /**
     * 从指定的位置移除
     * */
    public T remove(int index) {
        checkBoundExclusive(index);
        T ret = data[index]; //拿到待删除的元素
        //如果删除的元素不是最后一个元素，就需要向前移动数据
        if(index != --size) {
            System.arraycopy(data, index + 1, data, index, size - index);
        }
        data[size] = null;   // Help GC
        return ret;
    }


    /**
     * 检查边界是否合法
     * */
    private void checkBoundExclusive(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index: " + index + ", size: " + size);
        }
    }



    public int getSize(){
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

}
