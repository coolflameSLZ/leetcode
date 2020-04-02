package leetcode.easy;

import common.ListNode;

/**
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _21合并两个有序链表 {
    public static void main(String[] args) {

        // 节点1
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        // 节点2
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(l1, l2));
    }



    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode tmp = new ListNode(0);
        ListNode res = tmp;


        // 循环访问node 直到有一个node为null
        while (l1 != null && l2 != null) {

            // 哪个节点小，将哪个节点挂载到tmp指针上
            // 这个节点向后移动一位
            if (l1.val < l2.val) {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                tmp.next = new ListNode(l2.val);
                l2 = l2.next;
            }

            // 临时指针也向后移动一位
            tmp = tmp.next;
        }

        // 总有一个节点还剩一些值，将这个节点挂载到临时指针后面
        if (l1 != null) {
            tmp.next = l1;
        }

        if (l2 != null) {
            tmp.next = l2;
        }


        // 第一个节点是守望节点，返回他到下一个节点
        return res.next;
    }

}
