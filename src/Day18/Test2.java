package Day18;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Test2 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(Test1.TreeNode root) {
        //时间复杂度 O(N)O(N) ： NN 为二叉树的节点数量，即 BFS 需循环 NN 次。
        //空间复杂度 O(N)O(N) ： 最差情况下，即当树为平衡二叉树时，最多有 N/2N/2 个树节点同时在 queue 中，使用 O(N)O(N) 大小的额外空间。
        Queue<Test1.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> re = new ArrayList<>();
        if (root == null) return re;
        //int res = 1;不需要计数了 因为re的size就是深度
        while (!queue.isEmpty()) {//层序遍历，每一层的都拿出来
            int size = queue.size();//size应该放在这，因为如果放在外面那么size一直是1
            LinkedList<Integer> arr = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                Test1.TreeNode temp = queue.poll();
                if (re.size() % 2 == 0) {
                    arr.addFirst(temp.val);
                } else
                    arr.addLast(temp.val);
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
            }
            re.add(arr);
        }
        return re;
    }
}
