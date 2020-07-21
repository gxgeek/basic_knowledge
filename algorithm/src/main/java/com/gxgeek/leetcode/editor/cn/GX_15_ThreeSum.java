//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2387 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：三数之和
////给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复
//的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例： 
//
// 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]
// 
// Related Topics 数组 双指针 
// 👍 2387 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GX_15_ThreeSum{
    public static void main(String[] args) {
        Solution solution = new GX_15_ThreeSum().new Solution();
        // TO TEST
        solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            if (nums.length < 3) {
                return res;
            }
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] > nums[i - 1]) continue;

                int j = i + 1;
                int k = nums.length - 1;
                while (j < k) {
                    int sum = nums[j] + nums[k] + nums[i];
                    if (sum > 0) {
                        while (j < k && nums[k] == nums[--k]) ;
                    } else if (sum < 0) {
                        while (j < k && nums[j] == nums[++j]) ;

                    } else {
                        res.add(new ArrayList(Arrays.asList(nums[i], nums[j], nums[k])));
                        while (j < k && nums[k] == nums[--k]) ;
                        while (j < k && nums[j] == nums[++j]) ;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
