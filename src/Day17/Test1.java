package Day17;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
    public static void main(String[] args) {
        TreeNode root  = new TreeNode(1);
        TreeNode a =  new TreeNode(2);
        TreeNode b =  new TreeNode(2);
        TreeNode c =  new TreeNode(3);
        TreeNode d =  new TreeNode(4);
        TreeNode e =  new TreeNode(4);
        TreeNode f =  new TreeNode(3);

        root.left = a;
        root.right = b;
        a.right = d;
        a.left = c;
        b.left = e;
        b.right = f;
        //System.out.println(111);
        cengxuduicheng(root);
    }
    private  static boolean cengxuduicheng(TreeNode root){//O(N),O(N)

        if (root == null) return false;
        return duicheng(root.left,root.right);
    }

    private static boolean duicheng(TreeNode l, TreeNode r) {
        if(r == null && l == null) return true;//这块比较的节点都为空所以他们是对称的
        if(r == null || l == null) return false;//其中一个为null，不对称

        //return r == l && duicheng(l.left,r.right) && duicheng(l.right,r.left);//都得满足
        return r.val == l.val && duicheng(l.left,r.right) && duicheng(l.right,r.left);//都得满足
        //注意时val比较不是节点本身比较
    }
   // ThreadLocal
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
