/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-20 09:55:23
 * @LastEditTime: 2022-01-20 14:50:09
 * @Description: https://leetcode.com/problems/remove-linked-list-elements/
Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 */
package com.huzhengxing.linked_list;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null) {
			return head;
		}
		// find first diff
		while (head != null) {
			if (head.val == val) {
				head = head.next;
			} else {
				break;
			}
		}
		if (head == null) {
			return head;
		}
		ListNode tmp = head;
		head = head.next;
		ListNode result = tmp;
		while (head != null) {
			if (head.val != val) {
				tmp.next = head;
				tmp = tmp.next;
			} else {
				if (head.next == null) {
					tmp.next = null;
				}
			}
			head = head.next;
		}

		return result;
	}

	public ListNode removeElements2(ListNode head, int val) {
		while (head != null && head.val == val) {
			head = head.next;
		}
		ListNode result = head;	
		while (head != null && head.next != null) {
			if (head.next.val == val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RemoveLinkedListElements test = new RemoveLinkedListElements();
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
		ListNode result = test.removeElements2(listA, 4);
		System.out.println("Finished");
	}
}
