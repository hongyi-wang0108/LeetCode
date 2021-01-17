package Day13;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test1 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        ListNode ln1 = new ListNode(2);
        ListNode ln2 = new ListNode(3);
        ListNode ln3 = new ListNode(4);
        ListNode ln4 = new ListNode(5);
        head.next  = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = null;
        ListNode a = reverseList(head);
        while (a.next != null){
            System.out.println(a.val);
            a = a.next;
        }
    }
    public static ListNode reverseList(ListNode head) {
      ListNode pre = null;
      ListNode cur = head;
      while (cur != null){
          ListNode nextnode = cur.next;
          cur.next = pre;
          pre = cur;
        //  cur = cur.next;
          cur = nextnode;
      }
      return pre;
    }
}


class ListNode{
    ListNode next;
    int val;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }
}