package homework;

import java.util.HashMap;

/**
 * @author Echo
 * @date 2020/5/24 3:46 下午
 */
public class RotateArray_189 {


    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k % len - 1;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k);
        reverse(nums, k + 1, nums.length - 1);
    }

    public void rotate2(int[] nums, int k) {
        int step = k % nums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length;i ++) {
            hashMap.put((i + step) % nums.length, nums[i]);
        }
        for (int i = 0;i < nums.length;i ++) {
            nums[i] = hashMap.get(i);
        }
    }

    //交换位置
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[end];
            nums[end] = nums[start];
            nums[start] = end;

            start ++ ;
            end -- ;
        }
    }

}
