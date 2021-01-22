package Day16;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test2 {
    public static void main(String[] args) {
        Test1.TreeNode root = new Test1.TreeNode(3);
        Test1.TreeNode a =  new Test1.TreeNode(9);
        Test1.TreeNode b =  new Test1.TreeNode(20);
        Test1.TreeNode c =  new Test1.TreeNode(15);
        Test1.TreeNode d =  new Test1.TreeNode(7);
        root.left = a;
        root.right = b;
        a.right = null;
        a.left = null;
        b.left = c;
        b.right = d;
        String a1  = "1";
        String a2  = new String("1");
        System.out.println(a1 == a2);
        String a11 = "b";
        String b1 = "b2";
        String c1 = "b"+2;
        System.out.println(b1==c1);
    }
    public static int maxDepth(TreeNode root) {//ON O（N）后序
        if(root == null) return 0;//找到左子树或者右子树的最大值+1
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

    public static int maxDepth2(TreeNode root) {//层序  O(N) O(N)
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int res = 0;
        int size = queue.size();
        while (!queue.isEmpty()){
            for (int i = 0; i < size; i++) {//不用i《 queue。size是因为 queue的size是变化的，n先确定了
                TreeNode temp = queue.poll();//不用remove是因为 ，remove当是null的时候会报错
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
            }
            res++;
        }
        return res;
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
