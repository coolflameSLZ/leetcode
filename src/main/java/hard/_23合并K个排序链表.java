package hard;

import common.ListNode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _23合并K个排序链表 {

    public static void main(String[] args) {


    }

    /**
     * 优先队列解法
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {


        // 构造优先队列
        PriorityQueue<ListNode> listNodePq =
                new PriorityQueue<>(Comparator.comparing(listNode -> listNode.val));


        // 将所有的链表放入优先队列,注意过滤空元素
        Arrays.stream(lists)
                .filter(Objects::nonNull)
                .forEach(listNodePq::add);


        // 组建返回值 ListNode
        ListNode rHead = new ListNode(0);
        ListNode rTail = rHead;

        // 取出优先级队列中的第一个listNode，拿掉第一个node
        // 把拿掉的node组装进返回值，
        // 把剩下的listNode 放回优先队列
        while (!listNodePq.isEmpty()) {

            ListNode firstNode = listNodePq.poll();

            rTail.next = new ListNode(firstNode.val);
            rTail = rTail.next;

            firstNode = firstNode.next;
            if (firstNode != null) {
                listNodePq.offer(firstNode);
            }
        }
        return rHead.next;
    }
}
