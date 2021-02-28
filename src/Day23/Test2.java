package Day23;

import javax.swing.tree.TreeNode;
import java.util.HashMap;

public class Test2 {
    public static void main(String[] args) {

    }
    //时间复杂度 O(N)O(N) ： 其中 NN 为树的节点数量。初始化 HashMap 需遍历 inorder ，占用 O(N)O(N) 。递归共建立 NN 个节点，每层递归中的节点建立、搜索操作占用 O(1)O(1) ，因此使用 O(N)O(N) 时间。
    //空间复杂度 O(N)O(N) ： HashMap 使用 O(N)O(N) 额外空间。最差情况下，树退化为链表，递归深度达到 NN ，占用 O(N)O(N) 额外空间；最好情况下，树为满二叉树，递归深度为 \log NlogN ，占用 O(\log N)O(logN) 额外空间。
    HashMap<Integer,Integer> map = new HashMap<>();//为了知道先序中的root在中序数组下标在哪
    int[] preo ;//为了让第二个函数也知道preorder
    //先序：第一个节点是root，第二个是root左节点，第一个节点之后+左子树长度+1为root的右节点
    //中序：先找到先序中第一个节点的下标，左子树最左边的下标到root为左子树
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preo = preorder;
        //先给中序放到hashmap里，方便以后知道下标
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i],i);//key是inorder中的值，val是在数组下标，为了以后好递归，顶范维
        }
        //第一次：第一个节点：先序中的第一个。第二个节点：中序中左子树的左边界0。第三个节点：中序中右子树的右边界（中序最后一位）；
        return  recur(0,0,inorder.length-1);
    }

    private TreeNode recur(int pre_root, int mid_left, int mid_right) {
        if(mid_left > mid_right ) return null;//循环终止条件
        int mid_root = map.get(preo[pre_root]);//通过map得到中序里root的index；
        TreeNode root = new TreeNode(preo[pre_root]);//建立根节点
        root.left = recur(pre_root+1,mid_left,mid_root-1);
        //第一次：第一个参数：先序中的第一个root。第二个参数：中序中左子树的左边界0。第三个参数：中序中右子树的右边界（中序最后一位）；
        //第一个参数：root的左子树的根节点 是先序中 root的下一个   pre_root+1
        //第二个参数：左子树最左边界没变，还是题中传来的参数，      mid_left
        //第三个参数：左子树最右边界 是 中序中 root的前一个        mid_root-1
        root.right = recur(pre_root + (mid_root - mid_left ) + 1,mid_root + 1,mid_right);
        //第一次：第一个节点：先序中的第一个。第二个节点：中序中左子树的左边界0。第三个节点：中序中右子树的右边界（中序最后一位）；
        //第一个参数：root的右子树的根节点 根据先序中 根节点位置+左子树的长度  左子树的长度算的时候用中序里root的位置-左子树最左边界 因为是索引计算所以+1   pre_root + (mid_root - mid_left ) + 1
        //第二个参数：右子树最左边界，是中序里root下标+1           mid_root + 1
        //第三个参数：右子树最有边界，还是函数传进来的参数          mid_right
        return  root;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
