package Day20;

public class Test2 {

    public static void main(String[] args) {


    }

    public boolean verifyPostorder(int[] preorder,int[] midorder) {
        int rootindex = 0;
        for (int i = 0; i < midorder.length; i++) {
            if(preorder[0] == midorder[i]){
                rootindex = i;
            }
        }
       // if(preorder)
        return false;
    }

    static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
    }

}
