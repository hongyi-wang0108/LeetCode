package Day2;

import java.lang.reflect.Array;
import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(333);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;
        int[] arr = reversePrint(n1);
        System.out.print("[");
        for (int i = 0; i < arr.length ; i++) {
            System.out.print(arr[i]+",");
        }

    }
    public static int[] reversePrint(ListNode head) {
        //int i =  0;
        List<Integer> integerSet = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int node = 0;   //bierensilu
        ListNode rehead = head;
        while(head != null){
            node++;
            sb.append(head.val + " ");
            integerSet.add(head.val);
            head = head.next;
        }
        int i2 =0;
        int[] arr2 = new int[node];
        while (rehead != null){
            arr2[node-1-i2] = rehead.val;
            i2++;
             rehead=rehead.next;
        }
        System.out.println(sb);
        return arr2;
        /*int[] arr = new int[integerSet.size()];
        int i = 0;
        for (Integer integer : integerSet) {
            System.out.println(integer);
            arr[arr.length-1-i] = integer;
            i++;
        }
        return arr;*/
    }

}

class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
}