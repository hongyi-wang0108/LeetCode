package Day15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) {
        Bird bird = new Bird();
        Animal eagle = new Eagle();
        Test2 sd = new Test2();
        sd.sayHello(bird);
        sd.sayHello(eagle);

    }
    static abstract class Animal{

    }

    static class Bird extends Animal{

    }

    static class Eagle extends Animal{

    }

    public void sayHello(Animal animal) {
        System.out.println("hello,animal");
    }

    public void sayHello(Bird bird) {
        System.out.println("hello,I'm bird");
    }

    public void sayHello(Eagle eagle) {
        System.out.println("hello,I'm eagle");
    }
    Node pre,head;
  /*  public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);//深度优先的中序遍历

        //最后的操作，目的是变成双向
        head.left = pre;//pre是5
        pre.right = head;//head是1
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);//1把这这个执行完了之后                    pre是2，cur是3
        if(pre != null)//pre只有在是第一次的时候是null
            pre.right = cur;//现在cur是2，pre右边方向指向cur 1-》2       2-》3
        else
            head = cur;//这时候让头节点变成cur

        cur.left = pre;//第一次指空    1《-2                             2《-3
        pre = cur;//操作完上面之后同时指向一个节点，下次pre就有值了   记住这个自己写的时候忘记了
        dfs(cur.right);//遍历右边
    }*/




    Node1 premy,headmy;
    Node1 doubletest(Node1 root){
       if (root == null) return null;
       dfss(root);
       headmy.left = premy;
       premy.right = headmy;
       return headmy;
    }

    private void dfss(Node1 cur) {
        if(cur == null) return;
        dfss(cur.left);
        if(premy != null){
            premy.right = cur;
        }else
            headmy = cur;
        cur.left = premy;
        premy = cur;//zhegewangle
        dfss(cur.right);
    }
}
class Node1  {
    public int val;
    public Node1 left;
    public Node1 right;

    public Node1() {}

    public Node1(int _val) {
        val = _val;
    }

    public Node1(int _val,Node1 _left,Node1 _right) {
        val = _val;
        left = _left;
        right = _right;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
};