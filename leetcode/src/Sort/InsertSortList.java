package Sort;

public class InsertSortList {
	 public ListNode insertionSortList(ListNode head) {
	      ListNode dummy = new ListNode(0);
	        // ���dummy�������ǣ���head��ͷ������һ�����Ĳ��뵽dummy��ͷ��������
	        // �������ﲻ��Ҫdummy.next = head;

	        while (head != null) {
	            ListNode node = dummy;
	            while (node.next != null && node.next.val < head.val) {
	                node = node.next;
	            }
	            ListNode temp = head.next;
	            head.next = node.next;
	            node.next = head;
	            head = temp;
	        }

	        return dummy.next;
	    }
}
