package Sort;

import java.util.*;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        List<ListNode> nodeList = new ArrayList<>();        
        for(ListNode l: lists) nodeList.add(l);             //store lists into nodeList
        while(nodeList.size() >=2){                         //if size() >= 2 loop
            List<ListNode> nextNodeList = new ArrayList<>();//temp list which store ans after merge, size will be only half.
            for(int i = 0;i< nodeList.size();i = i+2){
                if(i + 1 < nodeList.size()){                //if there are 8 ListNode in the nodeList,
                    nextNodeList.add(mergeTwoLists(nodeList.get(i),nodeList.get(i+1)));//merge 0,1;2,3;3,4;
                }else nextNodeList.add(nodeList.get(i));    //deal with odd number of lists
            }
            nodeList = nextNodeList;                        
        }
        return nodeList.get(0);                             //in the end there will be only 1 ListNode.
    }
    private ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }else {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            }
        }
        if(l1 == null) curr.next = l2;
        else if(l2 == null) curr.next = l1;
        return dummy.next;
    }
}
