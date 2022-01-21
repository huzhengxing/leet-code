package com.huzhengxing.linked_list;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-19 19:03:15
 * @LastEditTime: 2022-01-19 19:53:23
 * @Description: 
 */
public class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
	}

	ListNode() {
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

}
