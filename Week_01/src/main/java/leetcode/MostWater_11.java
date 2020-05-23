package leetcode;

/**
 * @author Echo
 * @date 2020/5/23 6:20 下午
 *
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class MostWater_11 {

    /**
     * 暴力求解，两层循环,
     * 时间复杂度：O(n^2)
     * */
    public int maxArea1(int[] height) {
        int maxArea = 0;
        for (int i = 0;i < height.length - 1;i ++) {
            for (int j = i + 1;j < height.length;j ++) {
                // 面积 = 长 * 宽
                int currentArea = (j - 1) * Math.min(height[i], height[j]);
                maxArea = Math.max(maxArea, currentArea);
            }
        }
        return maxArea;
    }


    /**
     * 双指针夹B法
     * */
    public int maxArea2(int[] height) {
        int maxArea = 0;
        //i j 前后两个指针
        for (int i = 0, j = height.length - 1; i < j;) {
            //计算i和j上较小的高度，因为容积取决于较小的那个高
            int min = height[i] < height[j] ? height[i ++] : height[j --] ;
            //计算面积， 由于 i 和 j在前一步已经调整了位置，所以要 + 1 进行补偿
            int currentArea = (j - i + 1) * min;
            maxArea = Math.max(currentArea, maxArea);
        }
        return maxArea;
    }

}
