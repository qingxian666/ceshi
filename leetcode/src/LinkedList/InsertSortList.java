package LinkedList;

public class InsertSortList {
	public ListNode insertionSortList(ListNode head) {
	      ListNode dummy = new ListNode(0);
	        // ���dummy�������ǣ���head��ͷ������һ�����Ĳ��뵽dummy��ͷ��������
	        // �������ﲻ��Ҫdummy.next = head;

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
