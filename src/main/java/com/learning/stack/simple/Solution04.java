package com.learning.stack.simple;



import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2020-03-29
 使用栈实现队列的下列操作：

 push(x) -- 将一个元素放入队列的尾部。
 pop() -- 从队列首部移除元素。
 peek() -- 返回队列首部的元素。
 empty() -- 返回队列是否为空。

 */
public class Solution04 {

   public static void main(String[] args) {
      Stack<Integer> stack = new Stack<>();
      stack.push(1);
      stack.push(2);
      stack.push(3);
       for (Integer integer : stack) {
           System.out.println(integer);
       }

   }
  static class MyQueue01 {

      private Stack<Integer> dataStack ;
      private Stack<Integer> tempStack = null ;
      /** Initialize your data structure here. */
      public MyQueue01() {
         dataStack = new Stack<>();
      }

      /** Push element x to the back of queue. */
      public void push(int x) {
          dataStack.push(x) ;
          tempStack = new Stack<>();
         for(Integer data:dataStack){
             tempStack.push(data);
         }
         dataStack = tempStack;
      }

      /** Removes the element from in front of queue and returns that element. */
      public int pop() {
         return dataStack.pop();
      }

      /** Get the front element. */
      public int peek() {
         return dataStack.peek();
      }

      /** Returns whether the queue is empty. */
      public boolean empty() {

         return dataStack.isEmpty();
      }
   }


}
