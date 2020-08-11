//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// 👍 42 👎 0


package com.gxgeek.leetcode.editor.cn;
//Java：最小基因变化
////一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意: 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 所有的目标基因序列必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 示例 1: 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2: 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3: 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// 👍 42 👎 0

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class GX_433_MinimumGeneticMutation{
    public static void main(String[] args) {
        Solution solution = new GX_433_MinimumGeneticMutation().new Solution();
        // TO TEST
        solution.minMutation("AACCGGTT",
                "AACCGGTA",
                new String[]{"AACCGGTA"});
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String ban : bank){
            bankSet.add(ban);
        }
        if (bankSet.isEmpty() || !bankSet.contains(end)) return -1;
        char[] baseChange = new char[]{'A','C','G','T'};
        int count = 0;

        HashSet<String> startSet = new HashSet<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> endSet = new HashSet<>();
        startSet.add(start);
        visited.add(start);
        endSet.add(end);
        while(startSet.isEmpty() || endSet.isEmpty()) {
            if(startSet.size() > endSet.size()) {
                HashSet<String> temp  = new HashSet<>();
                temp = startSet;
                startSet = endSet;
                endSet = temp;
            }
            HashSet<String> currentSet = new HashSet<>();

            for (String s : startSet) {
                char[] originStrChars = s.toCharArray();
                for (int i = 0; i < originStrChars.length; i++) {
                    char originchar = originStrChars[i];
                    for (char change : baseChange) {
                        originStrChars[i] = change;
                        String changeStr = new String(originStrChars);
                        if (endSet.contains(changeStr)) return count;
                        if (bankSet.contains(changeStr) && !visited.contains(changeStr)){
                            visited.add(changeStr);
                            currentSet.add(changeStr);
                        }
                    }
                    originStrChars[i] = originchar;
                }
            }
            count++;
            startSet = currentSet;
        }
        return -1;

    }
//    public int minMutation(String start, String end, String[] bank) {
//        if (bank.length == 0){
//            return -1;
//        }
//        Set<String> baseSet = new HashSet<>(Arrays.asList(bank));
//        Set<Character> changeSet = new HashSet<>();
//        changeSet.add('A');
//        changeSet.add('C');
//        changeSet.add('G');
//        changeSet.add('T');
//
//
//        Set<String> visitSet = new HashSet<>();
//        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.addLast(start);
//        visitSet.add(start);
//
//        Integer count = 0;
//        while(!linkedList.isEmpty()){
//            int size = linkedList.size();
//            for (int i = 0; i < size; i++) {
//                String originStr = linkedList.pollFirst();
//                if (originStr.equals(end)){
//                    return count;
//                }
//                for (int i1 = 0; i1 < originStr.length(); i1++) {
//                    char[] chars = originStr.toCharArray();
////                    char originC = originStr.charAt(i1);
//                    for (Character character : changeSet) {
//                        chars[i1] = character;
//                        String newStr = new String(chars);
//                        if (baseSet.contains(newStr) && !visitSet.contains(newStr)){
//                            visitSet.add(newStr);
//                            linkedList.addLast(newStr);
//                        }
//                    }
////                    chars[i1] = originC;
//                }
//            }
//            count++;
//        }
//        return  -1;
//
//    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
