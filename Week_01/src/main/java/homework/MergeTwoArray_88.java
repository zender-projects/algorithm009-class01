package homework;

/**
 * @author Echo
 * @date 2020/5/24 4:33 下午
 *
 * 合并两个有序数组
 */
public class MergeTwoArray_88 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        //将nums1中的数据复制到临时数组中
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int p1 = 0;
        int p2 = 0;

        int p = 0;

        while (p1 < m && p2 < n) {
            //把较小的值赋值到num1中
            nums1[p ++] = (nums1Copy[p1] < nums2[p2] ? nums1Copy[p1 ++] : nums2[p2 ++]);
        }
        //处理剩余的数据
        if (p1 < m) {
            System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
        }
        if (p2 < n) {
            System.arraycopy(nums1Copy, p2, nums2, p1 + p2, m + n - p1 - p2);
        }
    }
}
