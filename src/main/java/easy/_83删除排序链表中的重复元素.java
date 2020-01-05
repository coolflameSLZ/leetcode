package easy;

/**
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->1->2
 * 输出: 1->2
 * 示例 2:
 * <p>
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _83删除排序链表中的重复元素 {

    public static void main(String[] args) {

        // 节点1
        _83删除排序链表中的重复元素.ListNode l1 = new _83删除排序链表中的重复元素.ListNode(1);
        l1.next = new _83删除排序链表中的重复元素.ListNode(1);
        l1.next.next = new _83删除排序链表中的重复元素.ListNode(2);
        l1.next.next.next = new _83删除排序链表中的重复元素.ListNode(3);
        l1.next.next.next.next = new _83删除排序链表中的重复元素.ListNode(3);

        // 节点2


        System.out.println(deleteDuplicates(l1));


    }


    public static ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }


        int hold = head.val;
        ListNode slow = head;

        ListNode fast = head.next;


        // 双指针，一前一后
        // 结束条件 ： 快指针走到尽头
        // 快指针每轮逼向后移动
        // 慢指针只在 不删除节点的时候跟着快指针向后移动
        // 有一个位置保存 上一个节点的val 如果当前节点的val 和上一个节点的val相同，那么删除这个节点。
        // 即 上一个节点的next = 此节点的next ， 这时候，上一个指针就相当于往后移动了一位，
        while (fast != null) {

            if (fast.val == hold) {
                slow.next = fast.next;
            } else {
                hold = fast.val;
                slow = slow.next;
            }


            fast = fast.next;

            System.out.println("fast=" + fast);
            System.out.println("slow=" + slow);
            System.out.println("========================");
        }


        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return val + "-->" + next;
        }
    }

}
