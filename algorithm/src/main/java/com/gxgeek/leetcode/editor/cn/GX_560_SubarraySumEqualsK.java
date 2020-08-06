//给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 526 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：和为K的子数组
////给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。 
//
// 示例 1 : 
//
// 
//输入:nums = [1,1,1], k = 2
//输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。
// 
//
// 说明 : 
//
// 
// 数组的长度为 [1, 20,000]。 
// 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。 
// 
// Related Topics 数组 哈希表 
// 👍 526 👎 0
	
public class GX_560_SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new GX_560_SubarraySumEqualsK().new Solution();
        // TO TEST
        solution.subarraySum(new int[]{1, 1, 1}, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        int needSum;
        int res = 0;
        public int subarraySum(int[] nums, int k) {
            needSum = k;
            dfs(nums,0,0);
            return res;
        }

        void dfs(int[] nums,int start,int currentValue){
            if (currentValue == needSum) res++;
            if (start >= nums.length) return;

            for (int i = start;i < nums.length; i++) {
                dfs(nums,start+1,currentValue + nums[i]);
            }
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
