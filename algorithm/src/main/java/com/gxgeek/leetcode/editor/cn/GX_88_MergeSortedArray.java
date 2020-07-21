//给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 562 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：合并两个有序数组
////给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 
//
// 说明: 
//
// 
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。 
// 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。 
// 
//
// 
//
// 示例: 
//
// 输入:
//nums1 = [1,2,3,0,0,0], m = 3
//nums2 = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
// Related Topics 数组 双指针 
// 👍 562 👎 0
	
public class GX_88_MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new GX_88_MergeSortedArray().new Solution();
        // TO TEST

//        3
//                [1,2,3]
//        3
        solution.merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            int nums1End = m-1;
            int nums2End = n-1;
            int totalEnd = m+n-1;
            while(nums1End>=0&&nums2End >=0){
                if(nums1[nums1End]> nums2[nums2End]){
                    nums1[totalEnd--] = nums1[nums1End--];
                }else{
                    nums1[totalEnd--] = nums2[nums2End--];
                }
            }
            if(nums2End>=0){
                nums1[totalEnd--] = nums2[nums2End--];
            }

        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
