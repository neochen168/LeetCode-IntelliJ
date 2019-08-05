package com.leetcode.src;

public class MergeBinaryTreeSolution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null){
            t1 = t2;
        }else if(t2 == null){
            return t1;
        }else{
            t1.setVal(t1.getVal() + t2.getVal());
            mergeTrees(t1.getLeft(), t2.getLeft());
            mergeTrees(t1.getRight(), t2.getRight());
        }

        return t1;
    }
}