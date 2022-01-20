/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-19 18:54:24
 * @LastEditTime: 2022-01-20 11:33:57
 * @Description: https://leetcode.com/problems/merge-two-sorted-lists/
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.
 */
package com.huzhengxing.linked_list;

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode result = null;
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		while (list1 != null && list2 != null) {
			ListNode t = new ListNode();
			if (list1.val <= list2.val) {
				t.val = list1.val;
				list1 = list1.next;
				if (list1 == null) {
					t.next = list2;
				}
			} else {
				t.val = list2.val;
				list2 = list2.next;
				if (list2 == null) {
					t.next = list1;
				}

			}
			if (result == null) {
				result = t;
			} else {
				last(result).next = t;
			}
		}

		return result;
	}

	public ListNode last(ListNode node) {
		if (node.next != null) {
			return last(node.next);
		} else {
			return node;
		}
	}

	public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode tmp = list1.val < list2.val ? list1 : list2;
		ListNode result = tmp;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				list1 = list1.next;
				tmp = tmp.next;
			} else {
				tmp.next = new ListNode(list2.val);
				tmp = tmp.next;
				list2 = list2.next;
				if (list2 == null) {
					tmp.next = list1;
				}
			}
		}
		return result;

	}

	public ListNode mergeTwoLists3(ListNode list1, ListNode list2) {
		if (list1 == null)
			return list2;
		if (list2 == null)
			return list1;
		ListNode tmp = list1.val < list2.val ? list1 : list2;
		if (tmp == list1)
			list1 = list1.next;
		else
			list2 = list2.next;
		ListNode result = tmp;
		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				tmp.next = list1;
				tmp = tmp.next;
				list1 = list1.next;

			} else {
				tmp.next = list2;
				tmp = tmp.next;
				list2 = list2.next;

			}
		}

		if (list1 == null) {
			tmp.next = list2;
		}
		if (list2 == null) {
			tmp.next = list1;
		}
		return result;
	}

	public static void main(String[] args) {
		ListNode listA1 = new ListNode(1);
		ListNode listA2 = new ListNode(2);
		ListNode listB1 = new ListNode(1);
		ListNode listA4 = new ListNode(4);
		ListNode listB3 = new ListNode(3);
		ListNode listB4 = new ListNode(4);
		MergeTwoSortedLists merge = new MergeTwoSortedLists();
		ListNode listA = listA1;
		listA1.next = listA2;
		listA2.next = listA4;
		ListNode listB = listB1;
		listB1.next = listB3;
		listB3.next = listB4;
		ListNode result = merge.mergeTwoLists3(listA1, listA2);
		System.out.println(result);
		// ListNode listA1 = new ListNode(1);
		// ListNode listB1 = new ListNode(1);
		// ListNode tmp = listA1;
		// for (int i = 0; i < 3; i++) {
		// ListNode listA2 = new ListNode(2);
		// listA1.next = listA2;
		// listA1 = listA1.next;
		// }
		// System.out.println(tmp.toString());
	}
}
