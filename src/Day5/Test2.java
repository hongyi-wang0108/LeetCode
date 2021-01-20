package Day5;

public class Test2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(6);
        ListNode l3 = new ListNode(5);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = null;
        ListNode newhead = deleteNode2(l1,6);
        while(newhead != null){
            System.out.print(newhead.val + "  ");
            newhead = newhead.next;
        }
    }
    //给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
    //返回删除后的链表的头节点。
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
    public static ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) return head.next;
        if(head == null)return head;
        ListNode temp = head;
        ListNode pre = temp;
        while (temp != null){
            if(temp.val == val){
                pre.next = temp.next;
                break;
            }
            pre = temp;
            temp = temp.next;
        }
        return head;
    }
    public static ListNode deleteNode2(ListNode head, int val) {
        if(head == null)return head;
        if(head.val == val) return head.next;
        ListNode temp = head;
        while (temp.next != null && temp.next.val != val){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
}
