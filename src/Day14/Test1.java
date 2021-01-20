package Day14;

import java.util.ArrayList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        b1.next = b2;
        b2.next = b3;
        b3.next = null;
        /*ListNode head = mergeTwoLists2(a1,b1);
        while (head != null){
            System.out.print( " " + head.val);
            head = head.next;
        }*/
        ListNode copyhead = copyqian(a1);
        //System.out.println("44455");
        /*while (copyhead != null){
            System.out.print(copyhead.val + " ");
            copyhead = copyhead.next;
        }*/
    }

    private static ListNode copyqian(ListNode a1) {//1 2 4
        ListNode cur = a1;//cur zhizhen
        ListNode dum = new ListNode(0);//jeidian
        ListNode pre = dum;//pre zhizhen

        while (cur != null){
            ListNode temp = new ListNode(cur.val);
            pre.next = temp;
            cur = cur.next;
            pre = temp;
        }
        return null;
       // return pre.next;
    }

    public static ListNode mergeTwoLists(ListNode a1, ListNode b1) {
        ListNode tempa = a1;
        ListNode tempb = b1;
        ListNode afterb = tempb.next;
        List<Integer> valb = new ArrayList<>();
        while (tempb != null){
            valb.add(tempb.val);//1 3 4
            tempb = tempb.next;
        }
        tempb = b1;
        int i = 0;
        ListNode newhead = null;
        while (tempa.next != null || valb.size() == i+1){
            if(tempa.val <= valb.get(i) && tempa.next.val > valb.get(i) ){
                ListNode mid = new ListNode( valb.get(i));
                mid.next = tempa.next;
                tempa.next = mid;
            }else {
                ListNode pre = new ListNode( valb.get(i));
                pre.next = tempa;
                newhead = pre;
            }
            tempa = tempa.next;
            i++;
        }
        if(newhead == null) {
            System.out.println(a1.val);
            return a1;
        }
        return newhead;
    }
    public static ListNode mergeTwoLists2(ListNode a1, ListNode b1) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;//cur -> dum
        while (a1 != null && b1 != null){
            if(a1.val <= b1.val){//a xiao
                cur.next = a1;
                a1 = a1.next;
            }else {
                cur.next = b1;
                b1 = b1.next;
            }
            cur = cur.next;
        }
        if(a1 != null)  cur.next = a1;
        if(b1 != null)  cur.next = b1;
        return dum.next;
    }
}
  class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }