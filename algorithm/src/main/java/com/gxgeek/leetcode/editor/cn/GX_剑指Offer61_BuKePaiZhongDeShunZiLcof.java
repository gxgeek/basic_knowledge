//从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 48 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：扑克牌中的顺子
////从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任
//意数字。A 不能视为 14。 
//
// 
//
// 示例 1: 
//
// 输入: [1,2,3,4,5]
//输出: True 
//
// 
//
// 示例 2: 
//
// 输入: [0,0,1,2,5]
//输出: True 
//
// 
//
// 限制： 
//
// 数组长度为 5 
//
// 数组的数取值为 [0, 13] . 
// 👍 48 👎 0

import java.util.Arrays;

public class GX_剑指Offer61_BuKePaiZhongDeShunZiLcof{
    public static void main(String[] args) {
        Solution solution = new GX_剑指Offer61_BuKePaiZhongDeShunZiLcof().new Solution();
        // TO TEST
        solution.isStraight(new int[]{0, 12, 11, 11, 0});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int zeroCount = 0,diffCount = 0;
        if(nums[0] == 0) zeroCount++;
        for (int i = 1; i < nums.length -1;i++){
            if (nums[i] == 0)zeroCount++;
            else if( nums[i]-nums[i-1] != 1) diffCount++;
        }
        return zeroCount>=diffCount ?true:false;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
