package com.huzhengxing.linked_list;
/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-20 14:58:40
 * @LastEditTime: 2022-01-20 15:44:19
 * @Description: 
 https://leetcode.com/problems/reverse-linked-list/
 Given the head of a singly linked list, reverse the list, and return the reversed list.
 */

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		ListNode result = null;
		while (head != null ) {
			ListNode cur = new ListNode(head.val);
			cur.next = result;
			result = cur;
			head = head.next;

		}
		return result;
	}

	public static void main(String[] args) {
		ReverseLinkedList test = new ReverseLinkedList();
		ListNode listA1 = new ListNode(1);
		ListNode listA2 = new ListNode(2);
		ListNode listB1 = new ListNode(1);
		ListNode listA4 = new ListNode(4);
		ListNode listB3 = new ListNode(3);
		ListNode listB4 = new ListNode(4);
		ListNode listA = listA1;
		listA1.next = listA2;
		listA2.next = listA4;
		ListNode listB = listB1;
		listB1.next = listB3;
		listB3.next = listB4;
		ListNode result = test.reverseList(listA);
		System.out.println("1");
	}
}
