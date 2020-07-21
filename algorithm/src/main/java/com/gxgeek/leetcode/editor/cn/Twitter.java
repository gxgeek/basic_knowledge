package com.gxgeek.leetcode.editor.cn;

import java.util.*;

public class Twitter {
    private Map<Integer,LinkedList<Integer>> userSeeTweetMap = new HashMap<>();
    private Map<Integer,Set<Integer>> userSeeUserMap = new HashMap<>();
    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        pushUserViewList(userId,tweetId);
        for(Map.Entry<Integer,Set<Integer>> entry :userSeeUserMap.entrySet()){
            if(entry.getValue().contains(userId)){
                pushUserViewList(entry.getKey(),tweetId);
            }
        }

    }

    private void pushUserViewList(int userId,int tweetId){
        LinkedList<Integer> deque = userSeeTweetMap.getOrDefault(userId,new LinkedList());
        deque.addLast(tweetId);
        if(deque.size()>10){
            deque.removeFirst();
        }
        userSeeTweetMap.put(userId, deque);

        LinkedList<Integer> s=  userSeeTweetMap.getOrDefault(userId,new LinkedList());
        ArrayList ss =  new ArrayList();
        for(int i = s.size() -1 ; i>=0;i--){
            ss.add(s.get(i));
        }

    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        return userSeeTweetMap.getOrDefault(userId,new LinkedList());
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        Set<Integer> followUserSet = userSeeUserMap.getOrDefault(followerId,new HashSet());
        followUserSet.add(followeeId);
        userSeeUserMap.put(followerId,followUserSet);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followUserSet = userSeeUserMap.getOrDefault(followerId,new HashSet());
        followUserSet.remove(followeeId);
        userSeeUserMap.put(followerId,followUserSet);
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();

// 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        twitter.postTweet(1, 5);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
        twitter.getNewsFeed(1);

// 用户1关注了用户2.
        twitter.follow(1, 2);

// 用户2发送了一个新推文 (推文id = 6).
        twitter.postTweet(2, 6);

// 用户1的获取推文应当返回一个列表，其中包含两个推文，id分别为 -> [6, 5].
// 推文id6应当在推文id5之前，因为它是在5之后发送的.
        twitter.getNewsFeed(1);

// 用户1取消关注了用户2.
        twitter.unfollow(1, 2);

// 用户1的获取推文应当返回一个列表，其中包含一个id为5的推文.
// 因为用户1已经不再关注用户2.
        twitter.getNewsFeed(1);


    }
}
