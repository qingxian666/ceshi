package SingleList;

public class ReverseLinkedList {
	//µü´ú·¨
	// Time Complexity: O(n), Space Complexity: O(1)
	 public ListNode reverseList(ListNode head) {
	       if(head==null||head.next==null) return head;
	        ListNode tail=null;
	        ListNode p=head;
	        ListNode q=p.next;
	        while(q!=null){
	            ListNode old=q.next;
	            p.next=tail;
	            q.next=p;
	            
	            tail=p;
	            p=q;
	            q=old;
	        }
	        return p;
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
