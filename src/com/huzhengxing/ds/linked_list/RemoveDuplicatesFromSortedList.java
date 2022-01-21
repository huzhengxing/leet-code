package com.huzhengxing.linked_list;

import java.util.HashSet;
import java.util.Set;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-20 15:49:20
 * @LastEditTime: 2022-01-20 16:21:43
 * @Description: 
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode deleteDuplicates(ListNode head) {
		Set<Integer> duplicates = new HashSet<>();
		// push the first element to sets
		if (head != null) {
			duplicates.add(head.val);
		}
		ListNode result = head;
		while (head != null && head.next != null) {
			if (duplicates.contains(head.next.val)) {
				head.next = head.next.next;
			} else {
				duplicates.add(head.next.val);
				head = head.next;
			}
		}
		return result;
	}

	public ListNode deleteDuplicates1(ListNode head) {
		ListNode result = head;
		while (head != null && head.next != null) {
			if (head.val == head.next.val) {
				head.next = head.next.next;
			} else {
				head = head.next;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		RemoveDuplicatesFromSortedList test = new RemoveDuplicatesFromSortedList();
		ListNode listA1 = new ListNode(1);
		ListNode listA2 = new ListNode(1);
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
		ListNode result = test.deleteDuplicates1(listA1);
		System.out.println("Finished");
	}
}
