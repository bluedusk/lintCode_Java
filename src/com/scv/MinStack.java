package com.scv;

import java.util.Stack;

/**
 * Created by Lenovo on 2017/3/9.
 * http://www.lintcode.com/problem/min-stack/
 * http://www.jiuzhang.com/solutions/min-stack/
 */
public class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()){
            minStack.push(number);
        }
        else{
            minStack.push(Math.min(minStack.peek(), number));
        }
    }

    public int pop() {
        // write your code here
        minStack.pop();
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}

// version 2, save space
//
class MinStack2 {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack2() {
        stack = new Stack<Integer>();
        minStack = new Stack<Integer>();
    }

    public void push(int number) {
        // write your code here
        stack.push(number);
        if (minStack.isEmpty()){
            minStack.push(number);
        }
        else{
            // 注意等于的情况下也要push
            if(number <= minStack.peek()){
                minStack.push(number);
            }
        }
    }

    public int pop() {
        // write your code here
        if(minStack.peek().equals(stack.peek())){
            minStack.pop();
        }
        return stack.pop();
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}

