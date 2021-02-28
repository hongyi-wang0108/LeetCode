package Day22;

public class Test2 {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(3);
        TreeNode r1 = new TreeNode(4);
        TreeNode r2 = new TreeNode(5);
        TreeNode r3 = new TreeNode(1);
        TreeNode r4 = new TreeNode(2);
        r.left = r1;
        r.right = r2;
        r1.left = r3;
        r1.right = r4;

        TreeNode r11 = new TreeNode(4);
        TreeNode r12 = new TreeNode(1);
        r11.left = r12;
        System.out.println(isSubStructure(r,r11));
    }
    public static boolean isSubStructure(TreeNode A, TreeNode B) {//是不是一样的结构，得先判断是不是一样的节点
        if(B == null || A == null)  return false;
        if(A.val == B.val && doestree1have2(A.left,B.left) && doestree1have2(A.right,B.right))
            //当满足第一个节点匹配上了，才进行其他节点的判断
            return true;
        return isSubStructure(A.left,B) || isSubStructure(A.right,B);
            //这就是遍历A，先找到与B第一个节点 相匹配的第一个节点4
    }

    private static boolean doestree1have2(TreeNode ra, TreeNode rb) {//是不是一样的节点
        if(rb == null) return true;
        if (ra == null) return false;
        if(ra.val == rb.val)
            return doestree1have2(ra.left,rb.left)  && doestree1have2(ra.right,rb.right);
        return false;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
