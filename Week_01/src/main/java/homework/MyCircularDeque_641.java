package homework;

/**
 * @author Echo
 * @date 2020/5/24 4:48 下午
 *
 * 设计一个双端循环队列
 */
public class MyCircularDeque_641 {

    private MyArrayList arrayList;
    public MyCircularDeque_641(int k) {
        arrayList = new MyArrayList(k);
    }

    public boolean insertFront(int value) {
        return arrayList.addFirst(value);
    }

    public boolean insertLast(int value) {
        return arrayList.addLast(value);
    }

    public boolean deleteFront() {
        arrayList.removeFirst();
        return true;
    }
    public boolean deleteLast() {
        arrayList.removeLast();
        return true;
    }
    public int getFront() {
        return arrayList.getFirst();
    }
    public int getRear() {
        return arrayList.getLast();
    }
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }
    public boolean isFull() {
        return arrayList.isFull();
    }

}

class MyArrayList {
    private int[] data;
    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int capacity) {
        this.data = new int[capacity];
        this.size = 0;
    }

    public int get(int index) {
        checkExclusive(index);
        return data[index];
    }

    public int getFirst() {
        return get(0);
    }

    public int getLast() {
        return get(size - 1);
    }

    public boolean add(int index, int value) {
        checkExclusive(index);
        if (size == data.length) {
            ensureCapacity(size + 1);
        }
        /*for (int j = size ; j > index;j --) {
            this.data[j] = this.data[j - 1];
        }*/
        System.arraycopy(data, index, data, index + 1, size - index );
        data[index] = value;
        this.size ++ ;
        return true;
    }

    public boolean addFirst(int value) {
        return add(0, value);
    }
    public boolean addLast(int value) {
        return add(size, value);
    }

    public int remove(int index) {
        checkExclusive(index);
        int ret = data[index];
        //不是最后一个元素，就移动数据
        if(index != -- size) {
            System.arraycopy(data, index + 1, data, index, size - index);
        }
        this.size -- ;
        return ret;
    }

    public int removeFirst() {
        return remove(0);
    }

    public int removeLast() {
        return remove(size - 1);
    }

    private void ensureCapacity(int minCapacity) {
        int newSize = Math.max(2 * size, minCapacity);
        int[] newDate = new int[newSize];
        System.arraycopy(data, 0, newDate, 0, size);
        this.data = newDate;
    }

    private void checkExclusive(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean isFull() {
        return this.size == data.length;
    }

    public int getSize() {
        return size;
    }
}
