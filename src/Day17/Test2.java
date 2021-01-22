package Day17;

public class Test2 {
    public static void main(String[] args) {

    }
    private Test1.TreeNode mirror(Test1.TreeNode root){
        //时间复杂度 O(N)O(N) ： 其中 NN 为二叉树的节点数量，建立二叉树镜像需要遍历树的所有节点，占用 O(N)O(N) 时间。
        //空间复杂度 O(N)O(N) ： 最差情况下（当二叉树退化为链表），递归时系统需使用 O(N)O(N) 大小的栈空间。

       if(root == null) return null;
        Test1.TreeNode temp = root.left;

        //本来是这个意思
//        root.left = mirror(root.right);
//        root.right = mirror(root.left);
        //但是需要把第二个变一下是因为，第一行执行完之后，r.l就被覆盖了，所以创造了temp
        root.left = mirror(root.right);
        root.right = mirror(temp);
        return root;

    }

/*    private boolean isph(Test1.TreeNode l, Test1.TreeNode r) {
        if(l == null && r == null) {
            return true;
        }
        if(l == null|| r == null){
            return false;
        }
        return r.val == l.val && isph(l.left,r.right) && isph(l.right,r.left);
    }*/
}
