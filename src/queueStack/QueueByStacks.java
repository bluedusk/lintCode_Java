package queueStack;

import java.util.Stack;

/**
 * Created by Lenovo on 2017/9/15.
 * 关键点：
 * 需要pop或者top的时候，当stack2为空才需要从stack1导入stack2;
 * push一直在stack1;
 */

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        // do intialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }
    void shiftStack() {
        if (stack2.empty()) {
            while (!stack1.empty()) {
                stack2.push(stack1.peek());
                stack1.pop();
            }
        }
    }
    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        shiftStack();
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        shiftStack();
        return stack2.peek();
    }
}

