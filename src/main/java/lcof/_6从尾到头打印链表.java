package lcof;

import common.ListNode;

/**
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _6从尾到头打印链表 {

    public static void main(String[] args) {


    }


    public static int[] reversePrint(ListNode head) {

        int count = 0;
        ListNode pre = null;
        ListNode cur = head;

        // 反转链表， 口诀 tmpcn，cp，pc，ct.
        while (cur != null) {
            count++;

            ListNode tmp = cur.next;

            cur.next = pre;
            pre = cur;
            cur = tmp;
        }


        int[] result = new int[count];

        // 将反转的链表填入数组
        for (int i = 0; i < count; i++) {
            result[i] = pre.val;
            pre = pre.next;

        }
        return result;
    }


}
