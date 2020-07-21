package com.gxgeek.leetcode.editor.cn;
//给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。 
//
// 说明：本题中，我们将空字符串定义为有效的回文串。 
//
// 示例 1: 
//
// 输入: "A man, a plan, a canal: Panama"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "race a car"
//输出: false
// 
// Related Topics 双指针 字符串 
// 👍 245 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isPalindrome(String s) {
        s = filterNoneNumberAndChar(s);
        String reverStr = revserStr(s);
        return reverStr.equals(s);
    }

    private String revserStr(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1 ; i >=0  ; i--) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
//        return new StringBuilder(s).reverse().toString();

    }

    private String filterNoneNumberAndChar(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char ca : s.toCharArray()) {
            // 数字
            if (ca > 47 && ca < 58) {
                stringBuilder.append((char)ca) ;
            }

            // 大写字母转换为小写字母
            if (ca > 64 && ca < 91) {
                stringBuilder.append(((char) (ca+32))) ;
            }
            // 小写字母
            if (ca > 96 && ca < 123) {
                stringBuilder.append( ca) ;
            }

        }
        return stringBuilder.toString();
//        return s.replaceAll("[^A-Za-z0-9]", "");
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Solution.class.newInstance().isPalindrome("A man, a plan, a canal: Panama");
    }
}

//leetcode submit region end(Prohibit modification and deletion)
