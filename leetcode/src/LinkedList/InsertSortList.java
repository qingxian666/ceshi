package LinkedList;

public class InsertSortList {
	public ListNode insertionSortList(ListNode head) {
	      ListNode dummy = new ListNode(0);
	        // 这个dummy的作用是，把head开头的链表一个个的插入到dummy开头的链表里
	        // 所以这里不需要dummy.next = head;

	        while (head != null) {
	            ListNode curr = dummy;
	            while (curr.next != null && curr.next.val < head.val) {
	                curr = curr.next;
	            }
	            ListNode temp = head.next;
	            head.next = curr.next;
	            curr.next = head;
	            head = temp;
	        }

	        return dummy.next;
	    }
}
