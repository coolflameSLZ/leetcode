package lcof;

import java.util.Stack;

public class _9用两个栈实现队列 {

    public static void main(String[] args) {


    }


    static class CQueue {

        Stack<Integer> aStack;
        Stack<Integer> bStack;


        public CQueue() {
            aStack = new Stack<>();
            bStack = new Stack<>();
        }

        // 添加队尾就是塞入a栈
        public void appendTail(int value) {

            if (!bStack.isEmpty()) {
                swapStack();
            }
            aStack.push(value);
        }

        // 删除队伍头，就是把a栈的所有东西放到b站
        // 这样，a栈的所有元素就倒叙了，我们此时弹出b栈的栈顶
        // 即可
        public int deleteHead() {

            if (aStack.isEmpty() && bStack.isEmpty()) {
                return -1;
            }

            if (bStack.isEmpty()) {
                swapStack();
            }


            return bStack.pop();

        }


        private void swapStack() {
            // a未空，b->a
            if (aStack.isEmpty()) {
                while (!bStack.isEmpty()) {
                    Integer curInt = bStack.pop();
                    aStack.push(curInt);
                }
            } else {

                while (!aStack.isEmpty()) {
                    Integer curInt = aStack.pop();
                    bStack.push(curInt);
                }
            }
        }


    }

}

