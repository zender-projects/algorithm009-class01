package leetcode;

import java.util.*;

/**
 * @author Echo
 * @date 2020/5/24 9:27 上午
 *
 * 三数之和
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 *
 */
public class ThreeSum_15 {

    /**
     * 暴力求解
     * */
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length <= 2) {
            return Collections.emptyList();
        }

        //这里必须要排序，否则结果又重复
        Arrays.sort(nums);
        Set<List<Integer>> result = new LinkedHashSet<>();
        for (int i = 0;i < nums.length - 2;i ++) {
            for (int j = i + 1; j < nums.length - 1;j ++) {
                for (int k = j + 1; k < nums.length ;k ++) {
                    if (nums[i] + nums[k] + nums[j] == 0) {
                        result.add(Arrays.asList(nums[i] , nums[k] ,nums[j]));
                    }
                }
            }
        }
        return new ArrayList<>(result);

    }


    /**
     * 双指针夹B
     * */
    public List<List<Integer>> threeSum2(int[] nums) {
        //排序是为了避免结果中有重复的
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        //因为是求3数之和，所以右面至少留出两个位置
        for (int k = 0;k < nums.length - 2;k ++ ) {
            //如果nums[k] > 0, 结果不可能 = 0
            if(nums[k] > 0) { break; }
            //这里是跳过相同的值
            if (k > 0 && nums[k] == nums[k + 1]) { continue; }

            //开始真正的表演
            int i = k + 1;  //left point
            int j = nums.length - 1; //right point
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                //如果和<0，说明i和j位置上的值的和小了，所以把左指针往右移动
                if(sum < 0) {
                    while (i < j && nums[i] == nums[++i]);
                } else if (sum > 0) {
                    while (i < j && nums[j] == nums[--j]);
                } else {
                    //找到了
                    result.add(Arrays.asList(nums[k], nums[i], nums[i]));
                    //移动左右指针到下一个位置
                    while (i < j && nums[i] == nums[++i]);
                    while (i < j && nums[j] == nums[--j]);
                }
            }
        }
        return result;
    }

}
