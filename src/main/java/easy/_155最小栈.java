package easy;

import java.util.*;

/**
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 * <p>
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 * 示例:
 * <p>
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _155最小栈 {

    public static void main(String[] args) {


    }


    private Stack<Integer> stack = new Stack<>();
    private List<Integer> minList = new ArrayList<>();


    /**
     * initialize your data structure here.
     */
    public _155最小栈() {

    }

    public void push(int x) {

        stack.push(x);
        minList.add(x);
        minList.sort(Comparator.naturalOrder());
    }

    public void pop() {
        Integer pop = stack.pop();
        minList.removeIf(numInList -> Objects.equals(numInList, pop));
    }

    public int top() {
        Integer peek = stack.peek();
        return peek;

    }

    public int getMin() {

        return minList.get(0);
    }


}
