package LinkedList;

public class RemoveNthNodeFromEndOfList_19 {
    /**
     * Given the head of a linked list, remove the nth node from the end of the list and return the head.
     * @param head head of a linked list
     * @param n the position of the node
     * @return the final head
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(n + 1 > 0){
            fast = fast.next;
            n --;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
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
    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        ListNode result = removeNthFromEnd(a, 4);
        System.out.println(result.val);
        ListNode lst = result;
        while(lst.next != null){
            lst = lst.next;
            System.out.println(lst.val);
        }
    }
}
