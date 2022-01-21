package com.huzhengxing.linked_list;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-19 17:33:51
 * @LastEditTime: 2022-01-19 19:03:32
 * @Description:  https://leetcode.com/problems/linked-list-cycle/
Given head, the head of a linked list, determine if the linked list has a cycle in it.
There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. 
Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
Return true if there is a cycle in the linked list. Otherwise, return false.


 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		Map<ListNode, Integer> map = new HashMap<ListNode, Integer>();
		int i = 0;
		while (head != null) {
			Integer idx = map.get(head);
			if (idx == null) {
				map.put(head, i);
				head = head.next;
			} else {
				return true;
			}
		}
		return false;
	}
	public boolean hasCycle1(ListNode head) {
		Set<ListNode> sets = new HashSet<>();
		while (head != null) {
			if (!sets.contains(head)) {
				sets.add(head);
				head = head.next;
			} else {
				return true;
			}
		}
		return false;
	}

}

