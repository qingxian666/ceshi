package LinkedList;

public class ReverseLinkedList2 {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		//https://leetcode.com/problems/reverse-linked-list-ii/discuss/30666/Simple-Java-solution-with-clear-explanation
        if(head == null && head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        while(pre.next != null && m!= 1){
            pre = pre.next;
            m--;
            n--;
        }
        ListNode curr = pre.next;
        while(curr.next != null && n != 1){
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
            n--;
        }
        return dummy.next;
    }
}
