package com.huzhengxing.stack;

import java.util.Stack;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-20 16:33:03
 * @LastEditTime: 2022-01-20 17:25:16
 * @Description: 
https://leetcode.com/problems/valid-parentheses/
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char val = s.charAt(i);
			if (val == '(') {
				stack.push(')');
				continue;
			}
			if (val == '{') {
				stack.push('}');
				continue;
			}
			if (val == '[') {
				stack.push(']');
				continue;
			}
			if (stack.isEmpty())
				return false;
			else {
				if (stack.peek() == val) {
					stack.pop();
				} else {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParentheses test = new ValidParentheses();
		// String s = "()[]{}";
		// String s = "([)]";
		String s = "()[](}";
		boolean result = test.isValid(s);
		System.out.println(result);
	}
}
