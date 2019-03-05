package LinkedList;

public class ReverseLinkedList {
	//µü´ú·¨
	// Time Complexity: O(n), Space Complexity: O(1)
	 public ListNode reverseList(ListNode head) {
	       if(head==null||head.next==null) return head;
	        ListNode dummy=null;
	        ListNode cur=head;
	        ListNode nexter=cur.next;
	        while(nexter!=null){
	            ListNode temp=nexter.next;
	            cur.next=dummy;
	            nexter.next=cur;
	            
	            dummy=cur;
	            cur=nexter;
	            nexter=temp;
	        }
	        return cur;
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
