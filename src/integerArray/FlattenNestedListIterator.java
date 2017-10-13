package integerArray;

import java.util.List;
import java.util.Stack;

/**
 * Created by Lenovo on 2017/10/13.
 */

  interface NestedInteger {

     // @return true if this NestedInteger holds a single integer,
     // rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds,
     // if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds,
     // if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
 }
public class FlattenNestedListIterator {

    private Stack<NestedInteger> stack;

    private void pushListToStack(List<NestedInteger> nestedList) {

        Stack<NestedInteger> temp = new Stack<>();
        for (NestedInteger nested : nestedList) {
            temp.push(nested);
        }

        while (!temp.isEmpty()) {
            stack.push(temp.pop());
        }
    }

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        stack = new Stack<>();
        pushListToStack(nestedList);
    }

    // @return {int} the next element in the iteration
//    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        return stack.pop().getInteger();
    }

    // @return {boolean} true if the iteration has more element or false
//    @Override
    public boolean hasNext() {
        while (!stack.isEmpty() && !stack.peek().isInteger()) {
            pushListToStack(stack.pop().getList());
        }

        return !stack.isEmpty();
    }

//    @Override
    public void remove() {}
}
