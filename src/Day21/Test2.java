package Day21;

public class Test2 {
    public static void main(String[] args) {

    }
    //时间复杂度 O(N)O(N) ： 其中 NN 为二叉树节点数；每循环一轮排除一层，
    // 二叉搜索树的层数最小为logN （满二叉树），最大为 NN （退化为链表）。
    //空间复杂度 O(1)O(1) ： 使用常数大小的额外空间。
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null){
            //他的跳出点，筛选到pq分布在root的两边，此时退出就行
            if (root.val > p.val && root.val > q.val) root = root.left;
            if (root.val < p.val && root.val < q.val) root = root.right;
            else break;
        }
        return root;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
