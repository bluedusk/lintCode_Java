package com.scv;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by openworld on 17/3/18.
 */


 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
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

public class FlattenList {

    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here


        List<Integer> result = new ArrayList<Integer>();


        for (NestedInteger item : nestedList){
            if (item.isInteger()){
                result.add(item.getInteger());
            }
            else{
                // add all
                result.addAll(flatten(item.getList()));
            }
        }

        return result;
    }

    public List<Integer> flatten1(List<NestedInteger> nestedList) {
        // Write your code here
        boolean isFlat = true;
        List<NestedInteger> ls = nestedList;
        // 层层解开，直到再没有list为止
        while (isFlat) {
            isFlat = false;
            List<NestedInteger> newLs = new ArrayList<NestedInteger>();
            for (NestedInteger ni : ls) {
                if (ni.isInteger()) {
                    newLs.add(ni);
                } else {
                    newLs.addAll(ni.getList());
                    isFlat = true;
                }
            }
            ls = newLs;
        }
        List<Integer> r = new ArrayList<Integer>();
        for (NestedInteger ni : ls) {
            r.add(ni.getInteger());
        }
        return r;
    }
}
