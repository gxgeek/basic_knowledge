//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 380 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：单词接龙
////给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索 
// 👍 380 👎 0

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class GX_127_WordLadder{
    public static void main(String[] args) {
        Solution solution = new GX_127_WordLadder().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList == null || wordList.size() == 0){
            return 0;
        }
        Set<String> baseSet = new HashSet<>(wordList);
        Set<Character> changeSet = new HashSet<>();
        for (int i = 0; i < wordList.size(); i++) {
            for (int i1 = 0; i1 < wordList.get(i).length(); i1++) {
                String s = wordList.get(i);
                changeSet.add(s.charAt(i1));
            }
        }

        Set<String> visitSet = new HashSet<>();
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.addLast(beginWord);
        visitSet.add(beginWord);

        Integer count = 1;
        while(!linkedList.isEmpty()){
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                String originStr = linkedList.pollFirst();
                if (originStr.equals(endWord)){
                    return count;
                }
                for (int i1 = 0; i1 < originStr.length(); i1++) {
                    char[] chars = originStr.toCharArray();
                    for (Character character : changeSet) {
                        chars[i1] = character;
                        String newStr = new String(chars);
                        if (baseSet.contains(newStr) && !visitSet.contains(newStr)){
                            visitSet.add(newStr);
                            linkedList.addLast(newStr);
                        }
                    }
                }
            }
            count++;
        }
        return  0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
