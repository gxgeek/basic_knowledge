//package com.gxgeek.leetcode.editor.cn;
//
//import javax.swing.tree.TreeNode;
//import java.util.*;
//
//public class Test {
//    public String t(String s){
//        StringBuilder numberSb = new StringBuilder();
//        Stack<Integer> mulitNumberStack = new Stack<>();
//        Stack<String> strStack = new Stack<>();
//
//        StringBuilder resultSb = new StringBuilder();
//        char[] sChars = s.toCharArray();
//        for(int i = 0;i<sChars.length;i++){
//            char currentChar = sChars[i];
//            if(isNumber(currentChar)){
//                numberSb.append(currentChar);
//            }else if(currentChar == '['){
//                mulitNumberStack.push(Integer.valueOf(numberSb.toString()));
//                strStack.push(resultSb.toString());
//                resultSb = new StringBuilder();
//                numberSb = new StringBuilder();
//            }else if(currentChar == ']'){
//                StringBuilder temp = new StringBuilder();
//                for(int j = 0; i<mulitNumberStack.pop();j++){
//                    temp.append(resultSb.toString());
//                }
//
//                resultSb = new StringBuilder(strStack.pop()+temp.toString());
//            }else{
//                resultSb.append(currentChar);
//            }
//        }
//        return resultSb.toString();
//
//    }
//    private boolean isNumber(char s){
//        if(s >= '0' && s<= '9'){
//            return true;
//        }
//        return false;
//    }
//    public static void main(String[] args) {
//        LinkedList<TreeNode> list = new LinkedList<>();
//        List<Integer> result = new ArrayList<>();
//
//
//        list.add(root);
//        while(!list.isEmpty()){
//            TreeNode node = list.peeKLast();
//            if(node.left != null){
//                list.addLast(node.left);
//                continue;
//            }
//            result.add(node.popLast().val);
//            if(node.right != null){
//                list.addLast(node.right);
//                continue;
//            }
//        }
//        return result;
//
//
//
//
//        while(!list.isEmpty()){
//            int listSize = list.size();
//            for(int i=0; i<listSize;i++){
//                TreeNode node = list.po();
//                TreeNode orignRight =  node.right;
//                node.right = node.left;
//                node.left = orignRight;
//
//                if(node.left != null){
//                    list.addLast(node.left);
//                }
//                if(node.right != null){
//                    list.addLast(node.right);
//                }
//            }
//        }
//        return root;
//
//    }
//
//
//    //    public int maxProfit(int[] prices) {
////        // 1.暴力解
////
////        int minPrice = prices[0];
////        int maxPrice = 0;
////
////        for(int i = 1;i<prices.length ;i++){
////            maxPrice = Math.max(prices[i]-minPrice  ,maxPrice);
////            minPrice = Math.min(prices[i]  ,minPrice);
////        }
////        return maxPrice;
////    }
//
//
//
////    public boolean isAnagram(String s, String t) {
////        if(s.length() != t.length()){
////            return false;
////        }
////        char[] schars = s.toCharArray();
////        char[] tchars = t.toCharArray();
////
////        Map<Character,Integer> map = new HashMap<>();
////        for(char schar : schars){
////            map.put(schar,map.getOrDefault(schar,0)+1);
////        }
////        Arrays.sort();
////        for(char tchar : tchars){
////            if(!map.containsKey(tchar)){
////                return false;
////            }
////            map.put(tchar,map.get(tchar)-1);
////            if(map.get(tchar) == 0){
////                map.remove(tchar);
////            }
////        }
////        return map.isEmpty();
////    }
//
//
////    public List<List<Integer>> combinationSum2(int[] cand, int target) {
////        Arrays.sort(cand);
////        List<List<Integer>> res = new ArrayList<>();
////        Stack<Integer> path = new Stack<>();
////        doSearch(cand, 0, target, path, res);
////        return res;
////    }
////
////    private void doSearch(int[] cand, int currentIndex, int targetValue,
////                          Stack<Integer> stack,List<List<Integer>> resList) {
////
////
////        if (targetValue <0){
////            return;
////        }else if(targetValue == 0){
////            resList.add(new ArrayList<>(stack));
////            return;
////        }
////        Char
////        for(int i = currentIndex; i< cand.length ; i++){
////            //这句话是去重的
////            if (i>currentIndex && cand[i-1] == cand[i]) continue;
////            int currentIndexValue = cand[i];
////            stack.push(currentIndexValue);
////            doSearch(cand,i+1,targetValue - currentIndexValue,stack,resList);
////            stack.pop();
////        }
////    }
////
////    public List<List<Integer>> combinationSum2(int[] cand, int target) {
////        Arrays.sort(cand);
////        List<List<Integer>> res = new ArrayList<List<Integer>>();
////        List<Integer> path = new ArrayList<Integer>();
////        dfs_com(cand, 0, target, path, res);
////        return res;
////    }
////    void dfs_com(int[] cand, int cur, int target, List<Integer> path, List<List<Integer>> res) {
////        if (target == 0) {
////            res.add(new ArrayList(new Stack()));
////            return ;
////        }
////        if (target < 0) return;
////        for (int i = cur; i < cand.length; i++){
////            if (i > cur && cand[i] == cand[i-1]) continue;
////            path.add(path.size(), cand[i]);
////            dfs_com(cand, i+1, target - cand[i], path, res);
////            path.remove(path.size()-1);
////        }
////    }
////
//
//}
