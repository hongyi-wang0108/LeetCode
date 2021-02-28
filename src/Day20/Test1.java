package Day20;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {

    }
    public int kthLargest(TreeNode root, int k) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if(temp.left != null) queue.add(temp.left);
                if(temp.right != null) queue.add(temp.right);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if(arr[i] < arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr[k-1];
    }

//时间复杂度 O(N)O(N) ： 当树退化为链表时（全部为右子节点），
//                      无论 kk 的值大小，递归深度都为 NN ，占用 O(N)O(N) 时间。
//空间复杂度 O(N)O(N) ： 当树退化为链表时（全部为右子节点），系统使用 O(N)O(N) 大小的栈空间。
    int count = 0,ans = 0;
    public int kthLargest2(TreeNode root, int k){
        dfs(root,k);
        return ans;
    }

    private void dfs(TreeNode root, int k) {
        //中序 先l在r为顺序 ，先r在l为倒序
        if(root.right != null) dfs(root.right,k);
        if(++count == k) {
            ans = root.val;
            return;
        }
        if(root.left != null) dfs(root.left,k);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
