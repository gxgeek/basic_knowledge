//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 804 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：柱状图中最大的矩形
////给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。 
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。 
//
// 
//
// 
//
// 以上是柱状图的示例，其中每个柱子的宽度为 1，给定的高度为 [2,1,5,6,2,3]。 
//
// 
//
// 
//
// 图中阴影部分为所能勾勒出的最大矩形面积，其面积为 10 个单位。 
//
// 
//
// 示例: 
//
// 输入: [2,1,5,6,2,3]
//输出: 10 
// Related Topics 栈 数组 
// 👍 804 👎 0

import java.util.Stack;

public class GX_84_LargestRectangleInHistogram{
    public static void main(String[] args) {
        Solution solution = new GX_84_LargestRectangleInHistogram().new Solution();
        // TO TEST
        solution.largestRectangleArea(new int[]{1, 3, 3, 5, 1});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int largestRectangleArea(int[] heights) {


        int[] newHeights = getNewHights(heights);

        int max = 0;
        Stack<Integer> indexStack = new Stack<>();
        indexStack.push(0);
//        Stack<Integer> heightStack = new Stack<>();
        for(int i = 1;i<newHeights.length;i++){
            while (newHeights[indexStack.peek()] > newHeights[i]){
                int currentHight = newHeights[indexStack.pop()];
                Integer last = indexStack.peek();
                int len = i - last - 1;
                int currentMarea = len * currentHight;
                max = Math.max(max, currentMarea);
            }
            indexStack.push(i);
        }
        return max;

    }

        private int[] getNewHights(int[] heights) {
            int [] newHeights = new int[heights.length+2];
            newHeights[0] = 0;
            newHeights[heights.length+1] = 0;
            for (int i = 1; i <= heights.length; i++) {
                newHeights[i] = heights[i - 1];
            }
            return newHeights;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
