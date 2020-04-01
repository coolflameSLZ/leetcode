package hard;

import common.ListNode;

public class _23合并K个排序链表 {

    public static void main(String[] args) {


    }


    public ListNode mergeKLists(ListNode[] lists) {

        int length = lists.length;
        if (length==0){
            return null;
        }

        ListNode list = lists[0];

        for (int i = 1; i < length; i++) {

            list = mergeTwo(list, lists[i]);
        }

        return list;


    }

    public static ListNode mergeTwo(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode resultListNodes = new ListNode(Integer.MIN_VALUE);
        ListNode idx = resultListNodes.next;

        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                idx.next = new ListNode(l2.val);
                l2 = l2.next;
            } else {
                idx.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            idx = idx.next;
        }

        if (l1 != null) {
            idx.next = l1;
        }
        if (l2 != null) {
            idx.next = l2;
        }

        return resultListNodes.next;
    }


}
