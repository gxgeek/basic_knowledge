//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找 
// 👍 207 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：搜索二维矩阵
////编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 示例 1: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//输出: true
// 
//
// 示例 2: 
//
// 输入:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//输出: false 
// Related Topics 数组 二分查找 
// 👍 207 👎 0
	
public class GX_74_SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new GX_74_SearchA2dMatrix().new Solution();
        // TO TEST
        int[][] a = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
//        int[][] a = new int[][] {{1}};
        solution.searchMatrix(a, 3);


}
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0){
            return false;
        }
        int start=  0;
        int end = matrix.length -1;
        while (start +1<end){
            int mid = start + (end - start) / 2;
//            if (matrix[mid][0] > target){
//                end = mid;
//            }else
            if (matrix[mid][0] < target){
                start = mid;
            }else {
                end = mid;
//                break;
            }
        }

        for (int i = start ;i<=end;i++){
            int[] subMatrix = matrix[i];
            if (subMatrix.length == 0) {
                continue;
            }
            int subStart=  0;
            int subEnd = subMatrix.length -1;
            while (subStart<=subEnd){
                int mid = subStart + (subEnd - subStart) / 2;
                if (subMatrix[mid]  > target){
                    subEnd = mid -1;
                }else if (subMatrix[mid] < target){
                    subStart = mid+1;
                }else {
//                    subStart = mid;
                    return true;
                }
            }
        }
        return false;

    }

        public int findMin(int[] nums) {
            if(nums.length == 0){
                return 0;
            }
            int left = 0;
            int right = nums.length -1;
            while (left +1<right){
                int mid = left +(right -left)/2;
                if(nums[mid]>nums[right]){
                    left = mid;
                }else{
                    right = mid;
                }
            }
            return nums[right];
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
