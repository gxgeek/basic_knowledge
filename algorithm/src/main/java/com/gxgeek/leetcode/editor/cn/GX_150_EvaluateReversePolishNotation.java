//根据 逆波兰表示法，求表达式的值。 
//
// 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 
//
// 
//
// 说明： 
//
// 
// 整数除法只保留整数部分。 
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 
// 
//
// 
//
// 示例 1： 
//
// 输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 输入: ["4", "13", "5", "/", "+"]
//输出: 6
//解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//输出: 22
//解释: 
//该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
//
// 
//
// 逆波兰表达式： 
//
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。 
//
// 
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。 
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。 
// 
//
// 逆波兰表达式主要有以下两个优点： 
//
// 
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。 
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。 
// 
// Related Topics 栈 
// 👍 176 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：逆波兰表达式求值
////根据 逆波兰表示法，求表达式的值。 
//
// 有效的运算符包括 +, -, *, / 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。 
//
// 
//
// 说明： 
//
// 
// 整数除法只保留整数部分。 
// 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。 
// 
//
// 
//
// 示例 1： 
//
// 输入: ["2", "1", "+", "3", "*"]
//输出: 9
//解释: 该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
// 
//
// 示例 2： 
//
// 输入: ["4", "13", "5", "/", "+"]
//输出: 6
//解释: 该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
// 
//
// 示例 3： 
//
// 输入: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
//输出: 22
//解释: 
//该算式转化为常见的中缀算术表达式为：
//  ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
//= ((10 * (6 / (12 * -11))) + 17) + 5
//= ((10 * (6 / -132)) + 17) + 5
//= ((10 * 0) + 17) + 5
//= (0 + 17) + 5
//= 17 + 5
//= 22 
//
// 
//
// 逆波兰表达式： 
//
// 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。 
//
// 
// 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。 
// 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。 
// 
//
// 逆波兰表达式主要有以下两个优点： 
//
// 
// 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。 
// 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中。 
// 
// Related Topics 栈 
// 👍 176 👎 0

import java.util.*;

public class GX_150_EvaluateReversePolishNotation{
    public static void main(String[] args) {
        Solution solution = new GX_150_EvaluateReversePolishNotation().new Solution();
        // TO TEST
        solution.generate(5);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int evalRPN(String[] tokens) {
        return 0;
    }

        public List<List<Integer>> generate(int numRows) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(Arrays.asList(1));

            for(int i = 1; i < numRows; i++) {
                List<Integer> sub = new ArrayList<>();
                sub.add(1);
                for (int j = 1; j < i; i++){
                    sub.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
                sub.add(1);
                res.add(sub);
            }
            return res;

        }


        public int[][] findContinuousSequence(int target) {
            int i = 1;
            int j = 1;
            int sum = 0;
            List<int[]> res = new ArrayList<>();
            while(i <= target/2){
                if (sum  < target){
                    sum+=j;
                    j++;
                }else if (sum > target){
                    sum-=i;
                    i++;
                }else{

                    int[] sub = new int[j-i+1];
                    for (int k = i ; k <=j; k++){
                        sub[j-i] = i;
                    }
                    res.add(sub);
                    sum-=i;
                    i++;
                }
            }
            return res.toArray(new int[res.size()][]);
        }

    }


    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        if (wordSet.size() == 0)return false;
        if (s.length()==0)return true;

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                dp[i] = dp[j] && wordSet.contains(s.substring(j,i));
                if (dp[i])break;
            }
        }
        return dp[s.length()];
    }

//leetcode submit region end(Prohibit modification and deletion)

}
