//给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
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
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 293 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：单词接龙 II
////给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换
//需遵循如下规则： 
//
// 
// 每次转换只能改变一个字母。 
// 转换后得到的单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回一个空列表。 
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
//输出:
//[
//  ["hit","hot","dot","dog","cog"],
//  ["hit","hot","lot","log","cog"]
//]
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: []
//
//解释: endWord "cog" 不在字典中，所以不存在符合要求的转换序列。 
// Related Topics 广度优先搜索 数组 字符串 回溯算法 
// 👍 293 👎 0

import java.util.*;

public class GX_126_WordLadderIi {
    int[] dx = new int[] {1,-1,0,0};
    int[] dy = new int [] {0,0,1,-1};

    public static void main(String[] args) {
        Solution solution = new GX_126_WordLadderIi().new Solution();
        // TO TEST
        solution.findLadders("hit", "cog"

                , Arrays.asList("hot", "dot", "dog", "lot", "log", "cog"));
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            Set<String> wordSet = new HashSet<>(wordList);
            if (wordSet.isEmpty() || !wordSet.contains(endWord)) return res;

            LinkedList<List<String>> deque = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            visited.add(endWord);
            List<String> list = new ArrayList<>();
            list.add(beginWord);
            deque.add(list);
            boolean falg = true;
            while(!deque.isEmpty() && falg) {
                Set<String> subVisited = new HashSet<>();
                int size = deque.size();
                while (size-- > 0) {
                    List<String> popList =  deque.pop();
                    String popStr = popList.get(popList.size()-1);
                    char[] popChars = popStr.toCharArray();
                    for (int i = 0; i < popChars.length; i++) {
                        char originC = popChars[i];
                        for (char changeC = 'a' ; changeC <= 'z'; changeC++){
                            popChars[i] = changeC;
                            String changeStr = new String(popChars);
                            if (wordSet.contains(changeStr) && !visited.contains(changeStr)){
                                if (changeStr.equals(endWord)){
                                    popList.add(endWord);
                                    res.add(popList);
                                    falg = false;
                                }else{
                                    popList.add(endWord);
                                    deque.add(popList);
                                }
                                subVisited.add(changeStr);
                            }
                        }
                        popChars[i] = originC;
                    }
                }
                visited.addAll(subVisited);
            }
            return res;

        }
//        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
//            List<List<String>> res = new ArrayList<>();
//            if (wordList == null || wordList.size() == 0 || !wordList.contains(endWord)) {
//                return res;
//            }
//            Set<String> wordSet = new HashSet<>(wordList);
//
//
//            Set<String> visitList = new HashSet<>();
//            LinkedList<List<String>> linkedList = new LinkedList<>();
//            visitList.add(beginWord);
//            linkedList.addLast(Arrays.asList(beginWord));
//            boolean falg = true;
//
//            while (!linkedList.isEmpty() && falg) {
//                int size = linkedList.size();
//                // 该层添加的所有元素：每层必须在所有结果都添加完新的单词之后，再将这些单词统一添加到已使用单词集合
//                // 如果直接添加到 visited 中，会导致该层本次结果添加之后的相同添加行为失败
//                // 如：该层遇到目标单词，有两条路径都可以遇到，但是先到达的将该单词添加进 visited 中，会导致第二条路径无法添加
//                Set<String> subVisit = new HashSet(visitList);
//                while (size-- > 0) {
//                    List<String> popList = linkedList.pop();
//                    String popStr = popList.get(popList.size() - 1);
//                    char[] popStrChars = popStr.toCharArray();
//                    for (int i = 0; i < popStrChars.length; i++) {
//                        char temp = popStrChars[i];
//                        for (char ch = 'a'; ch <= 'z'; ch++) {
//                            popStrChars[i] = ch;
//                            String changeStr = new String(popStrChars);
//                            if (wordSet.contains(changeStr) && !visitList.contains(changeStr)) {
//                                ArrayList<String> newPopList = new ArrayList<>(popList);
//                                newPopList.add(changeStr);
//                                if (changeStr.equals(endWord)) {
//                                    res.add(newPopList);
//                                    falg = false;
//                                }
//                                linkedList.addLast(newPopList);
//                                subVisit.add(changeStr);
//                            }
//                        }
//                        popStrChars[i] = temp;
//                    }
//
//                }
//                visitList.addAll(subVisit);
//            }
//            return res;
//
//        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}
