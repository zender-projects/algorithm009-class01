package leetcode;

/**
 * @author Echo
 * @date 2020/5/23 5:45 下午
 *
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZero_283 {

    /**
     * 利用额外数组来存储处理后的数据，
     * 非0放在前面，0放在后面，
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     * */
    public void moveZeroes1(int[] nums) {

        int[] temp = new int[nums.length];
        int i = 0, j = nums.length - 1;
        for (int k = 0 ;k < nums.length;k ++) {
            if (nums[k] != 0) {
                temp[i  ++] = nums[k];
            } else {
                temp[j --] = nums[k];
            }
        }
        print(temp);
    }

    /**
     * 夹逼法
     * j 记录为0的位置，当i处不为零时，i 和 j上的元素调换位置 j ++
     * */
    public void moveZeroes2(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length;i ++) {
            if (nums[i] != 0) {
                if (nums[i] != nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
                //j 向前移动，假定下一个位置为0，如果i 和 j 相等就说明下一个位置不为0，i 和 j 同时向前推进
                j ++ ;
            }
        }
        print(nums);
    }

    /**
     * 将所有非0元素移动到前面，后面的自动补0
     * */
    public void moveZeroes3(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length;i ++) {
            if (nums[i] != 0) {
                nums[j ++] = nums[i];
            }
        }
        //补0
        while (j < nums.length) {
            nums[j++] = 0;
        }

        print(nums);
    }


    public void print(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MoveZero_283 moveZero_283 = new MoveZero_283();
        int[] arr = {0,1,0,3,12};
        moveZero_283.moveZeroes3(arr);
    }

}
