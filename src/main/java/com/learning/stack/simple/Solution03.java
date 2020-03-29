package com.learning.stack.simple;



import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2020-03-29

 */
public class Solution03 {

    public static void main(String[] args) {
        MyStack02 myStack02 = new MyStack02();
        myStack02.push(1);
        myStack02.push(2);
        myStack02.push(3);
        System.out.println(myStack02.top());
        System.out.println(myStack02.pop());

    }

    //方法一：两个队列，入栈：O(1),出栈：O（N）
    class MyStack01 {
        private Queue<Integer> queque ;
        private Queue<Integer> tempQueue = null ;
        private Integer top = null ;

        /** Initialize your data structure here. */
        public MyStack01() {
            queque = new LinkedList<>();
        }

        /** Push element x onto stack. */
        public void push(int x) {
            queque.offer(x);
            top =x ;

        }

        /** Removes the element on top of the stack and returns that element. */
        public int pop() {
            tempQueue=new LinkedList<>();
            while(queque.size()>1){
                if(queque.size()==2){
                    top = queque.peek();
                }
                tempQueue.offer(queque.poll());

            }
            int popValue = queque.poll();
            queque = tempQueue;
            return popValue ;
        }

        /** Get the top element. */
        public int top() {
            if(top == null ){
                //stack is empty ;
            }
            return top ;
        }

        /** Returns whether the stack is empty. */
        public boolean empty() {
            return queque.isEmpty();
        }
    }



    //方法二：使用单个队列，每次pop和top的时候都把最后一个元素放到对头 比如 12345 变成51234
    static class MyStack02 {
        private Queue<Integer> queue;


        /**
         * Initialize your data structure here.
         */
        public MyStack02() {
            queue = new LinkedList<>();
        }

        /**
         * Push element x onto stack.
         */
        public void push(int x) {
            queue.offer(x);
            reverseLastElement(queue);
        }

        public void reverseLastElement(Queue<Integer> queue) {
            int size = queue.size();
            //将队列反转
            for (int i = 0; i < size - 1; i++) {
                queue.offer(queue.poll());
            }
        }

        /**
         * Removes the element on top of the stack and returns that element.
         */
        public int pop() {
            return queue.poll();
        }

        /**
         * Get the top element.
         */
        public int top() {
            return queue.peek();
        }

        /**
         * Returns whether the stack is empty.
         */
        public boolean empty() {
            return queue.isEmpty();
        }
    }


    //方法三：使用辅助队列：每次队列增加元素的时候把这次加入的元素放在最前面。
        static class MyStack03 {
            private Queue<Integer> queue ;
            private Queue<Integer> tempQueue = null ;


            /** Initialize your data structure here. */
            public MyStack03() {
                queue = new LinkedList<>();
            }

            /** Push element x onto stack. */
            public void push(int x) {
                tempQueue = new LinkedList<>();
                tempQueue.offer(x);
                while(queue.size()!=0){
                    tempQueue.offer(queue.poll());
                }
                queue = tempQueue;
                tempQueue = null ;
            }

            /** Removes the element on top of the stack and returns that element. */
            public int pop() {
                return queue.poll();
            }

            /** Get the top element. */
            public int top() {
                return  queue.peek();
            }

            /** Returns whether the stack is empty. */
            public boolean empty() {
                return queue.isEmpty();
            }
        }





}
