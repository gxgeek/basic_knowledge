//你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
//版本都是错的。 
//
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。 
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。 
//
// 示例: 
//
// 给定 n = 5，并且 version = 4 是第一个错误的版本。
//
//调用 isBadVersion(3) -> false
//调用 isBadVersion(5) -> true
//调用 isBadVersion(4) -> true
//
//所以，4 是第一个错误的版本。  
// Related Topics 二分查找 
// 👍 185 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：第一个错误的版本
////你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有
//版本都是错的。 
//
// 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。 
//
// 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误
//的版本。你应该尽量减少对调用 API 的次数。 
//
// 示例: 
//
// 给定 n = 5，并且 version = 4 是第一个错误的版本。
//
//调用 isBadVersion(3) -> false
//调用 isBadVersion(5) -> true
//调用 isBadVersion(4) -> true
//
//所以，4 是第一个错误的版本。  
// Related Topics 二分查找 
// 👍 185 👎 0
	
public class GX_278_FirstBadVersion{
    public static void main(String[] args) {
        Solution solution = new GX_278_FirstBadVersion().new Solution();
        // TO TEST
        solution.firstBadVersion(5);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution  {
    public int firstBadVersion(int n) {
        int leaf = 1;
        int right = n;
        while (leaf+1<right){
            int mid = leaf + (right - leaf) / 2;
            boolean badVersion = isBadVersion(mid);
            if (badVersion){
                right = mid;
            }else {
                leaf = mid;
            }
        }

        if (isBadVersion(leaf)){
            return leaf;
        }
        if (isBadVersion(right)) {
            return right;
        }
        return -1;
        
    }

    private boolean isBadVersion(int mid) {
        return mid>=4;
    }
}
//leetcode submit region end(Prohibit modification and deletion)


    public int[] searchRange(int[] A, int target) {
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;

        int start = 0;
        int end = A.length;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }


        if (A[start] == target) {
            res[0] = start;
        } else if (A[end] == target) {
            res[0] = end;
        } else {
            return res;
        }

        start = 0;
        end = A.length;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (A[mid] > target) {
                end = mid;
            } else if (A[mid] < target) {
                start = mid;
            } else {
                start = mid;
            }
        }


        if (A[end] == target) {
            res[1] = end;
        } else if (A[start] == target) {
            res[1] = start;
        } else {
            return res;
        }

        return res;
    }
    }
