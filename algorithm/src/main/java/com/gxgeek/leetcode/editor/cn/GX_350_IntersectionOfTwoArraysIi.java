//给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 370 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：两个数组的交集 II
////给定两个数组，编写一个函数来计算它们的交集。 
//
// 
//
// 示例 1： 
//
// 输入：nums1 = [1,2,2,1], nums2 = [2,2]
//输出：[2,2]
// 
//
// 示例 2: 
//
// 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
//输出：[4,9] 
//
// 
//
// 说明： 
//
// 
// 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。 
// 我们可以不考虑输出结果的顺序。 
// 
//
// 进阶： 
//
// 
// 如果给定的数组已经排好序呢？你将如何优化你的算法？ 
// 如果 nums1 的大小比 nums2 小很多，哪种方法更优？ 
// 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？ 
// 
// Related Topics 排序 哈希表 双指针 二分查找 
// 👍 370 👎 0

import java.util.*;

public class GX_350_IntersectionOfTwoArraysIi{
    public static void main(String[] args) {
        Solution solution = new GX_350_IntersectionOfTwoArraysIi().new Solution();
        // TO TEST
        solution.intersect(new int[]{1,2,2,1}, new int[]{2,2});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return new int[]{};
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums2[j] == nums1[i]){
                res.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] > nums2[j]) j++;
            else if (nums1[i] < nums1[j])i++;
        }
        int[] resInt = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            resInt[k] = res.get(k);
        }
        return resInt;

    }


        public int[] searchRange(int[] A, int target) {
            // write your code here'
            int first = findFirst(A,target);
            if (first < 0 || first >= A.length || A[first] != target){
                return new int[]{-1,-1};
            }
            return new int[]{first,findFirst(A,target+1)-1};
        }
        int findFirst(int[]A,int target) {
            int start = 0;
            int end = A.length;
            while (start < end) {
                int mid = start + (end- start) /2;
                if (A[mid] > target) {
                    end = mid;
                }else {
                    start = mid+1;
                }
            }
            return start;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
