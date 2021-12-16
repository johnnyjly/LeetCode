import java.util.*;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Add the first value in l1 and l2 and create the first node for the return ListNode
        int increment = 0;
        int iVal = l1.val + l2.val;
        if(iVal > 9) {
            iVal -= 10;
            increment = 1;
        }
        ListNode result = new ListNode(iVal);
        ListNode temp = result;

        // Add each value in l1 and l2, until one of them has no next Node
        while(l1.next!= null && l2.next!= null){
            int tempVal = l1.next.val + l2.next.val + increment;
            if(tempVal > 9) {
                tempVal -= 10;
                increment = 1;
            }
            else{
                increment = 0;
            }
            temp.next = new ListNode(tempVal);
            temp = temp.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        //Check and add the remaining list
        if(l1.next == null && l2.next == null){
            if(increment == 1){
                temp.next = new ListNode(1);
            }
            return result;
        }
        else if(l1.next == null){
            getListNode(l2, increment, temp);
            return result;
        }
        else{
            getListNode(l1, increment, temp);
            return result;
        }
    }

    private static void getListNode(ListNode l1, int increment, ListNode temp) {
        temp.next = l1.next;
        while(increment == 1 && temp.next != null){
            if(temp.next.val < 9){
                increment = 0;
            }
            else{
                temp.next.val -= 10;
            }
            temp.next.val += 1;
            temp = temp.next;
        }
        if(increment == 1){
            temp.next = new ListNode(1);
        }

    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {

    }
}
