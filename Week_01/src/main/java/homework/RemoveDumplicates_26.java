package homework;

/**
 * @author Echo
 * @date 2020/5/24 2:48 下午
 */
public class RemoveDumplicates_26 {

    public int removeDuplicates(int[] nums) {
        /**
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }

        int i = 0;
        int len  = nums.length;
        for (int j = 1;j < len;j ++) {
            if (nums[i] != nums[j] && j - i > 1) {
                //向前移动数据
                int tempLen = nums.length - j;
                System.arraycopy(nums, j, nums, i + 1, tempLen);
                //更新j的位置
                i ++ ;
                j = i + 1;
                len = len - (j - i);
            }
        }
        return len;
         */
        int len = nums.length;
        for (int i = 0;i < len - 1;) {
            if (nums[i] == nums[i + 1]) {
                del(nums, i);
                len -- ;
            }else {
                i ++ ;
            }
        }
        return len;
    }

    private void del(int[] nums, int index) {
        for (int j = index;j < nums.length - 1;j ++) {
            nums[j] = nums[j + 1];
        }
    }

    public static void main(String[] args) {
        int[] arr  = new int[]{1,1,2};
        RemoveDumplicates_26 removeDumplicates_26 = new RemoveDumplicates_26();
        removeDumplicates_26.removeDuplicates(arr);
    }

}
