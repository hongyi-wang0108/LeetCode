package Day13;

public class Test2 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode ln1 = new ListNode(2);
        ListNode ln2 = new ListNode(3);
        ListNode ln3 = new ListNode(4);
        ListNode ln4 = new ListNode(5);
        head.next  = ln1;
        ln1.next = ln2;
        ln2.next = ln3;
        ln3.next = ln4;
        ln4.next = null;
        ListNode a = getKthFromEnd(head,3);
        while (a.next != null){
            //System.out.println(a.val);
            a = a.next;
        }
    }
    public static ListNode getKthFromEnd(ListNode head, int k) {
        int i = 0;
        ListNode temp = head;
        //System.out.println(head.val);
        while (temp != null ){//可以算出一共多少个节点
            temp = temp.next;
            i++;
        }
        for (int j = 0; j < i-k; j++) {//让head往后走到倒数第K个节点
            /*if(head == null)
                break;*/
            head = head.next;
        }
        System.out.println(head.val);
        return head;
    }
    public static ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        for (int j = 0; j < k; j++) {
            fast = fast.next;
        }
        while (fast  != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
