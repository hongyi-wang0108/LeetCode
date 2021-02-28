package Day24;

import java.util.LinkedList;
import java.util.Queue;

public class Test1 {
    public static void main(String[] args) {

    }

//时间复杂度 O(N)O(N) ： NN 为二叉树的节点数，按层构建二叉树需要遍历整个 vals ，其长度最大为 2N+12N+1 。
//空间复杂度 O(N)O(N) ： 最差情况下，队列 queue 同时存储 (N+1)/2​
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {//层序遍历 变成完全二叉树了有好多null 所以还是用递归吧
        if(root == null) return "null,";
        String res = root.val+",";//添加root的值
        res = res + serialize(root.left);//左子树添加
        res = res + serialize(root.right);//右子树添加
        return  res;
        /*Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp != null) {
                sb.append(temp.val + ",");
                queue.add(temp.left);
                queue.add(temp.right);
            }
            else sb.append("null,");*/
            /*            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                sb.append(temp.val + ",");
                if(temp.left != null) queue.add(temp.left);else sb.append("null,");
                if(temp.right != null) queue.add(temp.right);else sb.append("null,");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("]");
        //sb.replace(sb.length()-2,sb.length()-1,"]");
        return sb.toString();*/
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if (data .equals("[]")) return null;
        String[] str = data.substring(1,data.length()-1).split(",");
        Queue<String > queue = new LinkedList<>();//先把节点全部放入queue
        for (int i = 0; i < str.length; i++) {
            queue.offer(str[i]);
        }
        return help(queue);//建立各个节点
/*        if(data.equals("[]")) return null;
        String[] arr = data.substring(1,data.length()-1).split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root =  new TreeNode(Integer.parseInt(arr[0]));
        queue.add(root);
        int i = 1;
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(!arr[i].equals("null")){
                temp.left = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(temp.left);
            }
            i++;
            if(!arr[i].equals("null")){
                temp.right = new TreeNode(Integer.parseInt(arr[i]));
                queue.add(temp.right);
            }
        }
        return root;*/

    }
    public TreeNode help(Queue<String> queue){
        String val = queue.poll();//先拿出
        if(val.equals("null")){//为null就返回
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(val));//不是空就建造节点
        root.left = help(queue);//建造左右节点
        root.right = help(queue);
        return root;
    }
   /* private TreeNode help(Queue<String> queue) {
        String val = queue.poll();
        if(val.equals("null")) return null;
        TreeNode temp = new TreeNode(Integer.valueOf(val));
        temp.left = help(queue);
        temp.right = help(queue);
        return temp;
    }
    public String serialize(TreeNode root) {
        if(root == null){
            return "null,";
        }
        String res = root.val + ",";
        res += serialize(root.left);
        res += serialize(root.right);
        return res;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<String>();
        for(int i = 0; i < arr.length; i++){
            queue.offer(arr[i]);
        }
        return help(queue);
    }*/

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
