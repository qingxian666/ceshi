package LinkedList;

public class LinkedListCycle2 {
	/*��fast��slow����ʱ��slow�϶�û�б�����������fast�Ѿ��ڻ���ѭ����nȦ(1 \leq n1��n)��
	 * ����slow����s������fast����2s����fast����������s�����ڻ��϶�ת��nȦ�����軷��Ϊr����
    2s = s + nr
	s = nr
	����������L������ڵ������������Ϊa����㵽����ڵ�ľ���Ϊx����
		x + a = nr = (n �C 1)r +r = (n-1)r + L - x
		x = (n-1)r + (L �C x �C a)
		L �C x �C aΪ�����㵽����ڵ�ľ��룬
	�ɴ˿�֪��������ͷ������ڵ����n-1Ȧ�ڻ�+�����㵽����ڵ㣬
	�������ǿ��Դ�head��ʼ����һ��ָ��slow2��������ָ��ÿ��ǰ��һ��������һ�����ڻ���ڵ�������*/
	
	public ListNode detectCycle(ListNode head) {
		// ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
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
