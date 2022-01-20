package com.huzhengxing.queue;

import java.util.Stack;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-20 17:33:45
 * @LastEditTime: 2022-01-20 20:06:27
 * @Description: 

Implement a first in first out (FIFO) queue using only two stacks. The implemented queue should support all the functions of a normal queue (push, peek, pop, and empty).
Implement the MyQueue class:
void push(int x) Pushes element x to the back of the queue.
int pop() Removes the element from the front of the queue and returns it.
int peek() Returns the element at the front of the queue.
boolean empty() Returns true if the queue is empty, false otherwise.
Notes:
You must use only standard operations of a stack, which means only push to top, peek/pop from top, size, and is empty operations are valid.
Depending on your language, the stack may not be supported natively. You may simulate a stack using a list or deque (double-ended queue) as long as you use only a stack's standard operations. 


 */
public class ImplementQueueUsingStacks {

	class MyQueue {

		Stack<Integer> st;
		Stack<Integer> tmp;

		public MyQueue() {
			st = new Stack<>();
			tmp = new Stack<>();
		}

		public void push(int x) {
			while (!st.isEmpty()) {
				tmp.push(st.pop());
			}
			tmp.push(x);
			while (!tmp.isEmpty()) {
				st.push(tmp.pop());
			}
		}

		public int pop() {
			return st.pop();
		}

		public int peek() {
			return st.peek();
		}

		public boolean empty() {
			return st.isEmpty();
		}

	}

}
