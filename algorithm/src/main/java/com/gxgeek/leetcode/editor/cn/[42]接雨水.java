package com.gxgeek.leetcode.editor.cn;
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Mar
//cos 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 1449 👎 0


import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public int trap(int[] height) {
        int sum = 0;
        Stack<Integer> stack = new Stack<>();
        for ( int current = 0 ;current< height.length;current++ ){


            while (!stack.empty() &&  height[stack.peek()]  > height[current] ){

                int endHeight = stack.pop();
                if (stack.empty()){
                    break;
                }
                int length = current - stack.peek() - 1;
                int minHigtht = Math.min(height[stack.peek()], height[current]);
                sum += length * (endHeight - minHigtht);

            }
            stack.push(current);
        }

        return sum;



    }
}
//leetcode submit region end(Prohibit modification and deletion)
