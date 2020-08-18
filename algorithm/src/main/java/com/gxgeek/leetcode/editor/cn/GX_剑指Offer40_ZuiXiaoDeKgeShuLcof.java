//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 118 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：最小的k个数
////输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 118 👎 0

import java.util.Arrays;

public class GX_剑指Offer40_ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new GX_剑指Offer40_ZuiXiaoDeKgeShuLcof().new Solution();
        // TO TEST
        solution.getLeastNumbers(new int[]{0, 0, 2, 3, 2, 1, 1, 2, 0, 4}, 10);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr.length < k)return new int[]{};
            int left = 0;
            int right = arr.length - 1;
            for (;;){
                int index = sort(arr,left,right);
                if (index > k) right--;
                else if(index < k)left++;
                else {
                    return Arrays.copyOfRange(arr,0,k);
                }
            }
        }

        int  sort(int[] arr,int left,int right){
            int povit = right;
            int count = left;
            for (int i = left; i <= right; i++) {
                if (arr[povit] > arr[i] ){

                    swap(arr,i,count);
                    count++;
                }
            }
            swap(arr,povit,count);
            return count;
        }

        void swap(int[] arr,int left,int right){
            int t = arr[left];
            arr[left] = arr[right];
            arr[right] = t;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}
