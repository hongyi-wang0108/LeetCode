package Day14;

import java.util.ArrayList;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);

        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);
        ListNode b4 = new ListNode(8);
        ListNode b5 = new ListNode(4);
        ListNode b6 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = null;
        ListNode head = getIntersectionNode2(a1,b1);
        //System.out.println(head.val);
    }
    public static  ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        List<ListNode> alist = new ArrayList<>();
        ListNode a = headA,b = headB;
        while (a != null){
            alist.add(a);
           // System.out.println(" alist.add(a.val);");
            a = a.next;
        }
        int i = 0;
        while (b !=  null && i != alist.size()-1){
           // System.out.println(b.val + "   " + alist.get(i));
            for (int j = 0; j < alist.size() ; j++) {
                if(b == alist.get(j)){
                    System.out.println("+54");
                    return b;
                }
            }
            b = b.next;
        }
        return null;
    }
    public static  ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ListNode nodea = headA;
        ListNode nodeb = headB;
        while (nodea != nodeb){
            //System.out.println(nodea.val);
            if(nodea == null){
                nodea = headB;
            }else {
                nodea = nodea.next;
            }
            if(nodeb == null){
                nodeb = headA;
            }else {
                nodeb = nodeb.next;
            }
        }
        return nodea;

    }
}
