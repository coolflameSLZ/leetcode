package mid;

import common.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网x络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _2两数相加 {

    public static void main(String[] args) {

        int i = 15;

        System.out.println(i / 10);
        System.out.println(i % 10);

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(0);
        ListNode rIdx = result;
        int carry = 0;

        // l1 ,l2 , 任何一个有数据，都向下执行
        while (l1 != null || l2 != null || carry > 0) {

            int l1Val = l1 != null ? l1.val : 0;

            int l2Val = l2 != null ? l2.val : 0;

            // 本轮的和
            int sum = l1Val + l2Val + carry;

            // 和 大于10 就保存进位
            carry = sum / 10;

            // 组装结果listNode
            rIdx.next = new ListNode(sum % 10);
            rIdx = rIdx.next;

            // 指针后移
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        return result.next;
    }


}
