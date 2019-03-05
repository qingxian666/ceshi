package LinkedList;

public class RecorderList {
	/*题目规定要in-place，也就是说只能使用O(1)的空间。
	可以找到中间节点，断开，把后半截单链表reverse一下，再合并两个单链表。
	*/
	//时间复杂度O(n)，空间复杂度O(1)
	public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        ListNode slow = head, fast = head, prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null; // cut at middle

        slow = reverse(slow);

        // merge two lists
        ListNode curr = head;
        while (curr.next != null) {
            ListNode tmp = curr.next;
            curr.next = slow;
            slow = slow.next;
            curr.next.next = tmp;
            curr = tmp;
        }
        curr.next = slow;
    }

    ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head;
        for (ListNode curr = head.next, next = curr.next; curr != null;
            prev = curr, curr = next, next = next != null ? next.next : null) {
                curr.next = prev;
        }
        head.next = null;
        return prev;
    }
}
