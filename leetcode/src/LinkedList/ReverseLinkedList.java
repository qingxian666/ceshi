package LinkedList;

public class ReverseLinkedList {
	//µü´ú·¨
	// Time Complexity: O(n), Space Complexity: O(1)
	public ListNode reverseList(ListNode head) {
        ListNode dummy = null;
        while(head!=null){
            ListNode tmp = head.next;
            head.next = dummy;
            dummy = head;
            head = tmp;
        }
        return dummy;
    }
	 //µÝ¹é·¨
	// Time Complexity: O(n), Space Complexity: O(n)
	 public ListNode reverseList2(ListNode head) {
	        if (head == null || head.next == null) return head;

	        ListNode tail = head.next;
	        head.next = null;
	        ListNode newHead = reverseList(tail);
	        tail.next = head;
	        
	        return newHead;
	    }
}
