package Day19;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        //TreeNode root = new TreeNode(3);
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
        levelOrder(root);
    }
    public static int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> arr = new ArrayList<>();
        if(root == null)return new int[0];
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                arr.add(temp.val);
                if(temp.left !=null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
        int[] a = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++) {
            a[i] = arr.get(i);
            System.out.println(arr.get(i));
        }
        return a;
    }
     static class TreeNode {
        int val;
        TreeNode left;
       TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
