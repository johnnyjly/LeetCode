import java.util.*;


public class AddTwoNumbers_2 {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // Initialize the return Node and Get the given two nodes.
        ListNode result = new ListNode(0);
        ListNode list1 = l1, list2 = l2, curr = result;
        int increment = 0;
        while (list1 != null || list2 != null) {
            int x, y;
            // Check if list1 has reached its end
            if(list1 != null) {
                x = list1.val;
            }else{
                x = 0;
            }
            // Check if list2 has reached its end
            y = (list2 != null) ? list2.val : 0; // Another way of writing if-else by using ? (ternary operator)
            int sum = increment + x + y;
            increment = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (list1 != null) list1 = list1.next;
            if (list2 != null) list2 = list2.next;
        }
        if (increment > 0) {
            curr.next = new ListNode(increment);
        }
        return result.next;

    }

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
