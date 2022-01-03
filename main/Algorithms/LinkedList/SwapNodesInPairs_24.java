package LinkedList;

import LinkedList.AddTwoNumbers_2;

public class SwapNodesInPairs_24 {

    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode curr = head;
        while(curr != null && curr.next != null){
            ListNode temp = curr.next;
            curr.next = temp.next;
            prev.next = temp;
            temp.next = curr;
            prev = curr;
            curr = curr.next;
        }
        return head;
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
}
