package Day16;

import javax.swing.tree.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode a =  new TreeNode(9);
        TreeNode b =  new TreeNode(20);
        TreeNode c =  new TreeNode(15);
        TreeNode d =  new TreeNode(7);
        root.left = a;
        root.right = b;
        a.right = null;
        a.left = null;
        b.left = c;
        b.right = d;
       // System.out.println( isBalanced(root));\
        String a1  = "1";
        String a2  = new String("1");
        System.out.println(a1 == a2);
        StringBuilder aaa = new StringBuilder("A");
        aaa.toString();
    }
   /* public static boolean isBalanced(TreeNode root) {//[3,9,20,null,null,15,7]
       int a = cengxu(root.left);
       int b = cengxu(root.right);
        int c = houxu(root.right);
        int d = houxu(root.left);
        if(c == d)return true;
        else if (c-d == -1) return true;
        else if(c-d == 1) return true;
        else  return  false;
       //if(a-b == -1 || a-b == 1 || a==b) //return true;
       return false;
        //System.out.println(a + "  " +b);
        //return false;
        //return (Math.max(a,b)-Math.min(a,b) == 1 ||  Math.max(a,b)-Math.min(a,b) == 0 )? true:false;
    }*/

    private static int cengxu(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = queue.size();
        int res = 0;
        while (!queue.isEmpty()){
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
            }
            res++;
        }
       // System.out.println(res);
        return res;
    }

    private static int houxu(TreeNode root){
        if(root == null) return 0;
        int le = houxu(root.left);
        if(le == -1) return -1;
        int ri = houxu(root.right);
        if(ri == -1)return -1;
        return Math.abs(le-ri) < 2 ? Math.max(le,ri) + 1:-1;

    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
