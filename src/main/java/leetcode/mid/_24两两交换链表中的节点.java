package leetcode.mid;

import alg_wang_zheng.arrayandlink.链表经典题目;
import common.ListNode;

/**
 * {@link 链表经典题目}
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * <p>
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _24两两交换链表中的节点 {

    /**
     * {@link alg_wang_zheng.arrayandlink.链表经典题目}
     *
     * @param args
     */
    public static void main(String[] args) {


    }


    /**
     * 两两交换 迭代做法
     * ________n1   n2  next
     * dummy-> 1 -> 2 -> 3 -> 4
     * <p>
     * dummy-> 2 -> 1 -> 4 -> 3
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        // dummy
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // 迭代指针
        ListNode cur = dummy;

        while (cur.next != null && cur.next.next != null) {

            //定义三个临时指针
            ListNode n1 = cur.next;
            ListNode n2 = n1.next;
            ListNode next = n2.next;

            //反转 反转的时候一般从后往前处理 n2,n1,迭代指针
            n2.next = n1;
            n1.next = next;
            cur.next = n2;

            //迭代后移
            cur = cur.next.next;
        }
        return dummy.next;


    }
}
