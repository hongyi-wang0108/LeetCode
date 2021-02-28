package Day21;

import javax.swing.tree.TreeNode;

public class Test1 {
    public static void main(String[] args) {

    }
    //O(N) ： 其中 N 为二叉树节点数；最差情况下，需要递归遍历树的所有节点。
    //O(N) ： 最差情况下，递归深度达到 N ，系统使用 O(N) 大小的额外空间。
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //1先判断当前节点是否为p q节点，是的话直接返回自己
        //2对于节点来说，除非两边都不为null，才算找到了公共节点

        //如果当前节点为null，或者 p或q 现在匹配上了，就返回r
        if(root == null || p == root || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);//第一步没满足，开始向下递归
        TreeNode right = lowestCommonAncestor(root.right,p,q);//same
        if(right != null && left != null) return root;//两边都有东西，现在root就是祖先公共节点
        if(right != null) return right;//一边匹配上了
        if(left  != null) return left;
        return null;

       // if(left == null) return right;
        //if(right == null) return left;
        //return root;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
