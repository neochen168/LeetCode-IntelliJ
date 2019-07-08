
class MergeBinaryTreeSolution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1 == null){
            t1 = t2;
        }else if(t2 == null){
            return t1;
        }else{
            t1.val += t2.val;
            mergeTrees(t1.left, t2.left);
            mergeTrees(t1.right, t2.right);
        }

        return t1;
    }
}