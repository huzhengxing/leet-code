package com.huzhengxing.algoI.day01;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-25 17:43:22
 * @LastEditTime: 2022-01-25 18:05:11
 * @Description: 
https://leetcode.com/problems/binary-search/
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
 */
public class BinarySearch {

	public int search(int[] nums, int target) {
		return search(nums, target, 0, nums.length - 1);
	}

	public int search(int[] nums, int target, int start, int end) {
		int idx = (end + start) / 2;
		if (nums[idx] == target) {
			return idx;
		}
		if (end < start) {
			return -1;
		}
		if (target < nums[idx]) {
			idx = search(nums, target, start, idx - 1);
		} else {
			idx = search(nums, target, idx + 1, end);
		}
		return idx;
	}

	public static void main(String[] args) {
		BinarySearch test = new BinarySearch();
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int result = test.search(nums, 9);
		System.out.println(result);

	}
}
