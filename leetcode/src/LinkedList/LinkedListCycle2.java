package LinkedList;

public class LinkedListCycle2 {
	/*当fast与slow相遇时，slow肯定没有遍历完链表，而fast已经在环内循环了n圈(1 \leq n1≤n)。
	 * 假设slow走了s步，则fast走了2s步（fast步数还等于s加上在环上多转的n圈），设环长为r，则：
    2s = s + nr
	s = nr
	设整个链表长L，环入口点与相遇点距离为a，起点到环入口点的距离为x，则
		x + a = nr = (n – 1)r +r = (n-1)r + L - x
		x = (n-1)r + (L – x – a)
		L – x – a为相遇点到环入口点的距离，
	由此可知，从链表头到环入口点等于n-1圈内环+相遇点到环入口点，
	于是我们可以从head开始另设一个指针slow2，两个慢指针每次前进一步，它俩一定会在环入口点相遇。*/
	
	public ListNode detectCycle(ListNode head) {
		// 时间复杂度O(n)，空间复杂度O(1)
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;

                while (slow2 != slow) {
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow2;
            }
        }
        return null;
    }
}
