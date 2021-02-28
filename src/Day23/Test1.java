package Day23;

import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        TreeNode r = new TreeNode(5);
        TreeNode r1 = new TreeNode(4);
        TreeNode r2 = new TreeNode(8);
        TreeNode r3 = new TreeNode(11);
        TreeNode r4 = new TreeNode(13);
        TreeNode r5 = new TreeNode(4);
        TreeNode r6 = new TreeNode(7);
        TreeNode r7 = new TreeNode(2);
        TreeNode r8 = new TreeNode(5);
        TreeNode r9 = new TreeNode(1);
        r.left = r1;
        r.right = r2;
        r1.left = r3;
        r3.left = r6;
        r3.right = r7;
        r2.left = r4;
        r2.right = r5;
        r5.left = r8;
        r5.right = r9;

        System.out.println(pathSum(r,22));
    }
    //时间复杂度 O(N)O(N) ： NN 为二叉树的节点数，先序遍历需要遍历所有节点。
    //空间复杂度 O(N)O(N) ： 最差情况下，即树退化为链表时，path 存储所有树节点，使用 O(N)O(N) 额外空间。
    //值得注意的是，记录路径时若直接执行 res.append(path) ，
    // 则是将 path 对象加入了 res ；后续 path 改变时， res 中的 path 对象也会随之改变。
    //正确做法：res.append(list(path)) ，相当于复制了一个 path 并加入到 res 。
    private static LinkedList<Integer> path = new LinkedList<>();
    private static LinkedList<List<Integer>> res = new LinkedList<>();

    public  static List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root,sum);//因为pathSum返回值是List<List<Integer>>，所以创建一个函数得到List<Integer>
        return res;
    }

    private static void recur(TreeNode root, int sum) {
        if(root == null) return;//空的时候不用做下面操作，放在第一步
        path.add(root.val);//先添加上
        sum = sum - root.val;//走一个路径，sum减少一点，每个递归的sum不一样，所以不用担心
        if(sum == 0 && root.left == null && root.right == null){
            //如果sum为0，必须走到子节点的时候才满足条件
            res.add(new LinkedList<>(path));//添加new LinkedList是因为 如果直接添加path，后面path变的时候res里面也会变
        }
        //如果满足上面条件了就说明，路走完了，这时候下面两个函数返回两个null然后path去除这个节点去寻找别的路径就好
        recur(root.left,sum);
        recur(root.right,sum);
        path.removeLast();//这就是为什么path是linkedList
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

}
