package com.gxgeek.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class 最小基因变化 {
    public static void main(String[] args) {
        minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"});
    }
    public static int minMutation(String start, String end, String[] bank) {
        char[] changeChars = new char[]{'A','C','G','T'};
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (bankSet.size() == 0 || bankSet.contains(end)){
            return -1;
        }
        Set<String> visited = new HashSet<>();
        LinkedList<String> deque = new LinkedList<>();
        deque.add(start);
        visited.add(start);
        int count = 0;
        while (!deque.isEmpty()) {
            int size = deque.size();
            while (size-- > 0){
                String originStr = deque.pop();
                if (originStr.equals(end)) {
                    return count;
                }
                char [] charArray = originStr.toCharArray();
                for (int i = 0; i < originStr.length(); i++){
                    char originChar = charArray[i];
                    for (char changeChar : changeChars){
                        charArray[i] = changeChar;
                        String changeStr = new String(charArray);
                        if (bankSet.contains(changeStr) && !visited.contains(changeStr)) {
                            deque.add(changeStr);
                            visited.add(changeStr);
                        }
                    }
                    charArray[i] = originChar;
                }
            }
            count++;
        }
        return -1;

    }
    int[]dx = new int[]{1,-1,0,0};
    int[]dy = new int[]{0,0,1,-1};

    boolean dfs(char[][] grid,int row,int col){
        if (grid[row][col] == '0'){
            return false;
        }
        grid[row][col] = '0';

        for (int i = 0; i < dx.length; i++){
            int x = dx[i] + col;
            int y = dy[i] + row;
//            for (x >= 0 && x < grid[row].length && y >= 0 && y < grid.length ){
//                dfs(grid,x,y);
//            }
        }
        Integer c = 1;
        char a = String.valueOf(c).charAt(0);
        return true;
    }



}
