
class MergeBinaryTreeSolution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        TreeNode root = new TreeNode(0);
        internalMerge(t1, t2, root);
        return root;
    }

    private void internalMerge(TreeNode t1, TreeNode t2, TreeNode root){
        if(t1 != null && t2 != null) {
            root.val = t1.val+t2.val;
            root.left = new TreeNode(0);
            root.right = new TreeNode(0);
            internalMerge(t1.left, t2.left, root.left);
            internalMerge(t1.right, t2.right, root.right);
        }else{
            if(t1 != null) {
                root.val = t1.val;
                root.left = new TreeNode(0);
                internalMerge(t1.left, t1.right, root.left);
                return;
            }else if(t2 != null){
                root.val = t2.val;
                root.right = new TreeNode(0);
                internalMerge(t2.left, t2.right, root.right);
                return;
            }else{
                root = null;
                return;
            }
        }
    }
}