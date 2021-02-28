package Day34;

public class Test1 {
    public static void main(String[] args) {

    }
}
class MinStack {
    //时间复杂度 O(1)O(1) ： push(), pop(), top(), min() 四个函数的时间复杂度均为常数级别。
    //空间复杂度 O(N)O(N) ： 当共有 N 个待入栈元素时，最差情况下存储 NN 个元素，使用O(N) 额外空间。
    private Node head;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(head == null) head = new Node(null,x,x);
        else             head = new Node(head,x,Math.min(x,head.min));
    }

    public void pop() {
        head = head.next;

    }

    public int top() {
        return head.val;
    }

    public int min() {
        return head.min;
    }
    private class Node{//用链表实现 空间换时间
        Node next;
        int val;
        int min;
        public Node(Node next, int val, int min) {
            this.next = next;
            this.val = val;
            this.min = min;
        }
    }
}
