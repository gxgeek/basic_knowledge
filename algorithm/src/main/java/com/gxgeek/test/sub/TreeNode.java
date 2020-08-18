package com.gxgeek.test.sub;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    protected int id;

    protected int parentId;

    private String title;

    protected List<TreeNode> children = new ArrayList<TreeNode>();

    public void add(TreeNode node) {
        children.add(node);
    }

    public static void main(String[] args) {
        List<TreeNode> list = new ArrayList<>();
        String str = "[{\"id\": 1,\"title\": \"111\",\"parentId\": null,\"parentName\": null},"+
                "{\"id\": 2,\"title\": \"测试\",\"parentId\": 1,\"parentName\": \"111\"},"+
                "{\"id\": 3,\"title\": \"123\",\"parentId\": 2,\"parentName\": \"测试\"}"+
                "]";
        List<TreeNode> TestVos = new Gson().fromJson( str, new TypeToken<List<TreeNode>>(){}.getType() );
        List<TreeNode> TestVoTree = getTree( TestVos);
    }

    public static List<TreeNode> getTree(List<TreeNode> sources) {
        List<TreeNode> rootList = getTreeRoot(sources);
        int len = rootList.size();
        for (int i = 0; i < len; i++) {
            getTreeChildNode(sources, rootList.get(i));
        }
        return rootList;
    }

    private static List<TreeNode> getTreeRoot(List<TreeNode> sources) {

        List<TreeNode> list = new ArrayList<>();
        for (TreeNode source : sources) {
            if (source.parentId == 0) {
                list.add(source);
            }
        }
        return list;
    }


    private static void getTreeChildNode(List<TreeNode> childList, TreeNode root) {
        for (TreeNode source : childList) {
            if (source.parentId == root.id) {
                root.add(findChildren(source,childList));
            }
        }
    }

    private static TreeNode  findChildren(TreeNode treeNode, List<TreeNode> treeNodes) {
        for (TreeNode it : treeNodes) {
            if (treeNode.id == it.parentId) {
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }











}
