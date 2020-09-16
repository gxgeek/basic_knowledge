package com.gxgeek.ms;


import java.util.*;

public class Test {
  static class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }
    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        if(intervals.size() <= 1)return intervals.size();

        Collections.sort(intervals,(a1, a2)-> a1.start - a2.start);

        int size = 1;
        Interval max = intervals.get(0);

        for (int i = 1; i < intervals.size(); i++) {
            Interval next = intervals.get(i);
            if (next.start < max.start){
                size++;
            }
            max.end = Math.max(max.end,next.end);
        }
        return size;

    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();

        System.out.println(getCharList(new char[]{'B','F','A','3','&','f'},new char[]{'F','*','D'}));
    }
    public static List<Character> getCharList(char[] char1,char[] char2){
        int i  = 0 ,  j = 0;
        int[] base = new int[26];
        while(i < char1.length || j < char2.length) {
            if (i < char1.length){
                char c1 = char1[i];
                if ((c1>= 'a' && c1 <= 'z') || (c1 >= 'A' && c1 <= 'Z')){
                    if (c1 >= 'A' && c1 <= 'Z'){
                        c1 = (char)(c1 + 32);
                    }
                    base[c1-'a']++;
                }
            }
            if (j < char2.length){
                char c2 = char2[j];
                if ((c2>= 'a' && c2 <= 'z') || (c2 >= 'A' && c2 <= 'Z')){
                    if (c2 >= 'A' && c2 <= 'Z'){
                        c2 = (char)(c2 + 32);
                    }
                    base[c2-'a']++;
                }
            }
            i++;
            j++;

        }
        List<Character> res = new ArrayList<>();
        for (int k = 0 ; k < base.length; k++) {
            if (base[k] > 0) {
                char sub = ((char)( k + 'a'));
                res.add(sub);
            }
        }
        return res;
    }
}