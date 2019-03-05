package LinkedList;

public class RotateList {
	// ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
	
	    public ListNode rotateRight(ListNode head, int k) {
	        if (head == null || k == 0) return head;

	        int len = 1;
	        ListNode p = head;
	        while (p.next != null) { // �󳤶�
	            len++;
	            p = p.next;
	        }
	        k = len - k % len;

	        p.next = head; // ��β����
	        for(int step = 0; step < k; step++) {
	            p = p.next;  //����������
	        }
	        head = p.next; // �µ��׽ڵ�
	        p.next = null; // �Ͽ���
	        return head;
	    }
	
}
