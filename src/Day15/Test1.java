package Day15;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        //[[7,null],[13,0],[11,4],[10,2],[1,0]]
        Node a0 = new Node(7);
        //a0.random.next = null;

        Node a1 = new Node(13);
      //  a1.random.next = a0;

        Node a2 = new Node(11);
        //a2.random.next = a3;

        Node a3 = new Node(10);
      //  a3.random.next = a2;


        Node a4 = new Node(1);
        //a4.random.next = a0;
        //a2.random.next = a4;

        a0.next = a1;
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = null;

        Node head = copyRandomList(a0);
        while (head != null){
            System.out.print( head.val + "  ");
            head = head.next;
        }
    }

    private static Node copyRandomList(Node head) {//ON ON
        Node cur = head;
        Map<Node,Node> map = new HashMap<>();
        while (cur != null){
            map.put(cur,new Node(cur.val));//（旧地址，新地址）
            cur = cur.next;
        }
        cur = head;
        while (cur != null){
            map.get(cur).next = map.get(cur.next);//map.get(cur.next)=cur的next的新地址   map.get(cur)=cur的新地址
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);//得到head的新地址
    }
    private static Node copyRandomList2(Node head) {//ON O1
        if (head == null) return null;//如果为空，
        //1,copy node 复制每个节点，跟在源节点后面 1 2 3---》 1 1 2 2 3 3
        Node cur = head;
        while (cur != null){
            Node clone = new Node(cur.val);//造出一样的节点
            clone.next = cur.next;// 1 2 3   新造出来的1指向2
            cur.next = clone;//1 1 2 3
            cur = clone.next;//现在cur从2开始
        }
        //2.random的关系搞好
        cur = head;
        while (cur != null){
            if(cur.random != null){
                cur.next.random = cur.random.next;//复制的节点的random = 原来节点的random指向的地址
            }
            cur = cur.next.next;//从1 1 2 2 3 3 中第一个2开始
        }
        //3.分离
        cur = head.next;
        Node pre = head,res = head.next;//res:new node de head
        while (cur.next != null){//1 1 2 2 3 3
            pre.next = pre.next.next;//pre连接的下一个是2
            cur.next = cur.next.next;//cur也要挎着连接

            //循环进行的条件
            cur = cur.next;//往后移
            pre = pre.next;//往后移
        }
        pre.next = null;//原来链表的善后
        return res;
    }
    public static Node copyOneList(Node head) {//简单链表的深层拷贝
        Node cur = head;
        Node dum = new Node(0), pre = dum;
        while(cur != null) {
            Node node = new Node(cur.val); // 复制节点 cur
            pre.next = node;               // 新链表的 前驱节点 -> 当前节点
            // pre.random = "???";         // 新链表的 「 前驱节点 -> 当前节点 」 无法确定
            cur = cur.next;                // 遍历下一节点
            pre = node;                    // 保存当前新节点
        }
        return dum.next;
    }
}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}