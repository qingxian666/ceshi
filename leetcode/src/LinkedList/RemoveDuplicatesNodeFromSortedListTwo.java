package LinkedList;

public class RemoveDuplicatesNodeFromSortedListTwo {
	public ListNode deleteDuplicates(ListNode head) {
	    if(head==null) return null;
	    ListNode Dummy=new ListNode(0);
	    Dummy.next=head;
	    ListNode pre=Dummy;
	    ListNode cur=head;
	    while(cur!=null){
	        while(cur.next!=null && cur.val==cur.next.val){
	            cur=cur.next;
	        }
	        if(pre.next==cur){
	            pre=pre.next;
	        }
	        else{
	            pre.next=cur.next;
	        }
	        cur=cur.next;
	    }
	    return Dummy.next;
	}
}
