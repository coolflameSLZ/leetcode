package leetcode.easy;

import common.ListNode;

/**
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * <p>
 * <p>
 * 解法
 * https://leetcode-cn.com/problems/reverse-linked-list/solution/dong-hua-yan-shi-206-fan-zhuan-lian-biao-by-user74/
 */
public class _206反转链表 {

    /**
     * {@link alg_wang_zheng.arrayandlink.链表经典题目}
     *
     * @param args
     */
    public static void main(String[] args) {


    }


    /**
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
     * 在更改引用之前，还需要另一个指针来存储下一个节点。
     * 不要忘记在最后返回新的头引用！
     *
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head) {

        // 我们实际上要做的是， 将箭头调转方向
        // 原来的方向为 pre.next = cur
        // 经过处理的方向为 cur.next = pre .
        // 最终我们输出 left即可
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {

            // 再修改方向之前，我们需要临时保存一下 cur.next
            ListNode tmp = cur.next;
            // 调转方向
            cur.next = pre;

            // 因为pre->cur 的方向已经被修改，
            // 所以只能不能使用 x = x.next 只能将指针间赋值
            pre = cur;
            cur = tmp;

        }
        return pre;
    }


    /**
     * 在遍历列表时，将当前节点的 next 指针改为指向前一个元素。
     * 由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
     * 在更改引用之前，还需要另一个指针来存储下一个节点。
     * 不要忘记在最后返回新的头引用！
     *
     * @param head
     * @return
     */
    public static ListNode reverseList2(ListNode head) {


        if (head == null || head.next == null) {
            return head;
        }

        //这里请配合动画演示理解
        //这里的cur就是最后一个节点
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        ListNode cur = reverseList(head.next);
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next = head 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空
        // 现在,既有 5->4 也有 4-> 。所以，我们要删除老的指针，即
        // head.next  = null
        head.next = null;
        return cur;


    }


}
