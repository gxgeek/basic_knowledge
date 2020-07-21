//给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
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
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 455 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：滑动窗口最大值
////给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。 
//
//
// 返回滑动窗口中的最大值。 
//
// 
//
// 进阶： 
//
// 你能在线性时间复杂度内解决此题吗？ 
//
// 
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
// 
// 1 <= nums.length <= 10^5 
// -10^4 <= nums[i] <= 10^4 
// 1 <= k <= nums.length 
// 
// Related Topics 堆 Sliding Window 
// 👍 455 👎 0

import java.util.LinkedList;
import java.util.Stack;

public class GX_239_SlidingWindowMaximum{
    public static void main(String[] args) {
        Solution solution = new GX_239_SlidingWindowMaximum().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length-k+1];

        LinkedList<Integer> list = new LinkedList<>();

        int index =0;
        for(int i = 0; i < nums.length;i++){
            //删除掉最前面的
            while(!list.isEmpty() &&  list.peekFirst()<i-k+1){
                list.pollFirst();
            }
            while(!list.isEmpty() && nums[i]>nums[list.peekLast()]){
                list.pollLast();
            }
            list.addLast(i);

            if(i-k+1>=0){
                res[index++] = nums[list.peekFirst()];
            }


        }
        return res;
    }
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        LinkedList<Integer> indexList = new LinkedList<>();
//        int resIndex = 0;
//        int[] res = new int[nums.length - k +1];
//        for (int i = 0; i < nums.length-1; i++) {
//            //移除再圈定范围外的
//            while (!indexList.isEmpty() && indexList.peekFirst() <i-k+1 ){
//                indexList.pollFirst();
//            }
//            //移除当前值大的
//            while (!indexList.isEmpty() &&  indexList.peekLast() > nums[i]){
//                indexList.pollLast();
//            }
//            indexList.addLast(i);
//            if (i-k+1>0){
//                res[i++] = nums[indexList.peekFirst()];
//            }
//        }
//        return res;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
