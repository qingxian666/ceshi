package LinkedList;

public class PartitionList {
	 public ListNode partition(ListNode head, int x) {
	        final ListNode BiggerDummy = new ListNode(0);
		        final ListNode SmallerDummy = new ListNode(0);
		        ListNode Bigger = BiggerDummy;
		        ListNode Smaller = SmallerDummy;

		        int index = 1;
		        while (head != null) {
		            if (head.val >= x) {
		                Bigger.next = head;
		                Bigger = Bigger.next;
		            } else {
		                Smaller.next = head;
		                Smaller = Smaller.next;
		            }

		            ListNode tmp = head.next;
		            head.next = null;
		            head = tmp;
		            ++index;
		        }

		        Smaller.next = BiggerDummy.next;
		        return SmallerDummy.next;
	    }
}
