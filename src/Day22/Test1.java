package Day22;

import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,6,5};
        System.out.println(verifyPostorder(arr));
    }
    public static boolean verifyPostorder(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int parent = Integer.MAX_VALUE;
        for (int i = postorder.length-1; i >= 0 ; i--) {
            int cur = postorder[i];
            //这用while就是为了找到前面栈中最小的节点
            //因为在遇到降序时，postorder[i] 大于 postorder[i+1]时 ，postorder[0-i]中最小的是postorder[i+1]根节点
            while (!stack.isEmpty() && stack.peek() > cur){//peek：是先对值进行比较，如果满足就会执行出栈，不满足就不出栈
                //现在parent就是多次peek出栈+pop出栈之后的结果，真正的根节点
                parent = stack.pop();
            }
            if(cur > parent) return false;
            stack.push(cur);//每次都要把节点放进去
        }
        return true;
    }
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
