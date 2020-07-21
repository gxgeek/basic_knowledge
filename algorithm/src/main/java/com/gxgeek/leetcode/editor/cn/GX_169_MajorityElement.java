//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 670 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：多数元素
////给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1: 
//
// 输入: [3,2,3]
//输出: 3 
//
// 示例 2: 
//
// 输入: [2,2,1,1,1,2,2]
//输出: 2
// 
// Related Topics 位运算 数组 分治算法 
// 👍 670 👎 0
	
public class GX_169_MajorityElement{
    public static void main(String[] args) {
        Solution solution = new GX_169_MajorityElement().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int majorityElement(int[] nums) {
//        if (nums.length <0){
//            return
//        }
        int cuttrntCount = 0;
        Integer res = null;
        for (int i = 0; i < nums.length; i++) {
            if (cuttrntCount == 0){
                res = nums[i];
                cuttrntCount++;
            }else {
                if (res == nums[i]){
                    cuttrntCount++;
                }else {
                    cuttrntCount--;
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
