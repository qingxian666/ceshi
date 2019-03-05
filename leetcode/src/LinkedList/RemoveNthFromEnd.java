package LinkedList;

public class RemoveNthFromEnd {
	//设两个指针p,q，让q先走n步，然后p和q一起走，直到q走到尾节点，删除p->next即可。
	//时间复杂度O(n)，空间复杂度O(1)
	public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p = dummy, q = dummy;

        for (int i = 0; i < n; i++)  // q先走n步
            q = q.next;

        while(q.next != null) { // 一起走
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }
}
