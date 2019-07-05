

public class MaxDepthSolution {

    private int maxDepth2 = 1;
    private int maxDepth = 1;
    public int maxDepth(Node root) {
        if(root == null) return 0;
        findDepth2(root);
        return maxDepth;
    }

    private int findDepth2(Node root){
        if(root.children == null || root.children.size() == 0) {
            maxDepth = maxDepth2 > maxDepth ? maxDepth2 : maxDepth;
            return maxDepth;
        }

        this.maxDepth2++;
        for(int i = 0; i < root.children.size(); i++){
            findDepth2(root.children.get(i));
        }
        --this.maxDepth2;
        return maxDepth;
    }
}