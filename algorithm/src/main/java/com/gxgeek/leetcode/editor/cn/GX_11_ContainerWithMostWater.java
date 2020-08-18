//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1710 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：盛最多水的容器
////给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器，且 n 的值至少为 2。 
//
// 
//
// 
//
// 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 
//
// 示例： 
//
// 输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
// Related Topics 数组 双指针 
// 👍 1710 👎 0
	
public class GX_11_ContainerWithMostWater{
    public static void main(String[] args) {
        Solution solution = new GX_11_ContainerWithMostWater().new Solution();
        // TO TEST
        solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxArea(int[] height) {

        int[] newHeight = new int[height.length+2];
        newHeight[0] = 0;
        newHeight[newHeight.length-1] = 0;


        int i = 0;
        int j = newHeight.length-1;
        int max = 0;
        while (i < j) {
            int minHeight = Math.min(newHeight[i],newHeight[j]);
            int len = j-1 - i;
            max = Math.max(max,minHeight*len);
            if (newHeight[i] > newHeight[j])j--;
            else i++;
        }
        return max;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
