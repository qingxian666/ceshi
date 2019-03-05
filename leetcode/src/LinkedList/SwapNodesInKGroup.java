package LinkedList;

public class SwapNodesInKGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k <= 1) return head;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        dummy.next = head;
        ListNode curr = head;
        int len = 0;
        for(ListNode p = head;p!= null; p = p.next) len++;//O(n) to get the length of single list
        int loopCount = len/k;
        for(int i = 0;i< loopCount;i++){
            for(int j = 0;j< k - 1;j++){                  //reverse k group
                ListNode next = curr.next;
                curr.next = next.next;
                next.next = pre.next;
                pre.next = next;
            }
            pre = curr;                                   //move pointer pre and curr
            curr = pre.next;
        }
        return dummy.next;
    }
}
