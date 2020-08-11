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

import java.util.HashMap;
import java.util.Map;

public class GX_560_SubarraySumEqualsK{
    public static void main(String[] args) {
        Solution solution = new GX_560_SubarraySumEqualsK().new Solution();
        // TO TEST
        solution.subarraySum(new int[]{1, 1, 1}, 2);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//        int res = 0;

        public int subarraySum(int[] nums, int k) {
            int prevSum = 0;
            int res = 0;
            Map<Integer, Integer> prevMap = new HashMap<>();
            prevMap.put(0, 1);
            for (int i = 0; i < nums.length ; i++) {
                prevSum += nums[i];
                if (prevMap.containsKey(prevSum - k)){
                    res += prevMap.get(prevSum - k);
                }
                prevMap.put(prevSum, prevMap.getOrDefault(prevSum, 0)+1);
            }
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
