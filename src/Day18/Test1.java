package Day18;


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
    public static List<  List<Integer>   > levelOrder(TreeNode root) {
        //时间复杂度 O(N)O(N) ： NN 为二叉树的节点数量，即 BFS 需循环 NN 次。
        //空间复杂度 O(N)O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2N/2 个树节点同时在 queue 中，使用 O(N)O(N) 大小的额外空间。
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> re = new ArrayList<>();
        if(root == null) return re;
        while (!queue.isEmpty()){//层序遍历，每一层的都拿出来
            int size = queue.size();//size应该放在这，因为如果放在外面那么size一直是1
            List<Integer> arr = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                arr.add(temp.val);
                if(temp.left != null)   queue.add(temp.left);
                if(temp.right != null)  queue.add(temp.right);
            }
            re.add(arr);
        }
        return re;
        /*Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> re = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        arr.add(root.val);
        re.add(arr);
        arr.remove(0);
        int size = queue.size();
        while (queue!= null){
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                if(temp.left != null) {
                    queue.add(temp.left);
                    arr.add(temp.left.val);
                }
                if(temp.right != null){
                    queue.add(temp.right);
                    arr.add(temp.right.val);
                }
            }
            //System.out.println(arr;
            re.add(arr);
            arr = new ArrayList<>();
        }
        for (int i = 0; i < re.size(); i++) {
            System.out.println(re.get(i).toString());
        }
        return re;*/
    }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
