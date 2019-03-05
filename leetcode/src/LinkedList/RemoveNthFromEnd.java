package LinkedList;

public class RemoveNthFromEnd {
	//������ָ��p,q����q����n����Ȼ��p��qһ���ߣ�ֱ��q�ߵ�β�ڵ㣬ɾ��p->next���ɡ�
	//ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy, q = dummy;

        for (int i = 0; i < n; i++)  // q����n��
            q = q.next;

        while(q.next != null) { // һ����
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
