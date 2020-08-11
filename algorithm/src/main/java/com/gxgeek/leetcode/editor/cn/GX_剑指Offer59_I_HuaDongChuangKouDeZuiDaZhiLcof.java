//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 82 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：滑动窗口的最大值
////给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。 
//
// 示例: 
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7] 
//解释: 
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7 
//
// 
//
// 提示： 
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。 
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/ 
// Related Topics 队列 Sliding Window 
// 👍 82 👎 0

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class GX_剑指Offer59_I_HuaDongChuangKouDeZuiDaZhiLcof{
    public static void main(String[] args) {
        Solution solution = new GX_剑指Offer59_I_HuaDongChuangKouDeZuiDaZhiLcof().new Solution();
        // TO TEST
        solution.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7},
                3);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {



    public int[] maxSlidingWindow(int[] nums, int k) {
        List list = new ArrayList();
        int[] res = new int[nums.length - k +1];
        int index =0;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i ++) {
            if(!deque.isEmpty() && deque.peekFirst() < i-k+1){
                deque.pollFirst();
            }
            if (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.pollLast();
            }
            deque.addLast(i);
            if (i-k+1 >=0){
                res[index++] = nums[deque.peekFirst()];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


}
