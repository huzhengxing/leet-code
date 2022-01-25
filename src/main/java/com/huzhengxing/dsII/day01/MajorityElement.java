package com.huzhengxing.dsII.day01;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-25 12:04:08
 * @LastEditTime: 2022-01-25 14:27:53
 * @Description: 
https://leetcode.com/problems/majority-element/

Given an array nums of size n, return the majority element.
The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array
 */
public class MajorityElement {
	public int majorityElement(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int n : nums) {
			map.put(n, map.getOrDefault(n, 0) + 1);
		}
		int result = 0;
		int count = Integer.MIN_VALUE;
		for (Integer n : map.keySet()) {
			if (map.get(n) > count) {
				result = n;
				count = map.get(n);
			}
		}
		return result;
	}

	public int majorityElement1(int[] nums) {
		Arrays.sort(nums);
		int maxNum = nums[0];
		int maxCount = 0;
		int currentCount = 1;
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			if (num == nums[i - 1]) {
				currentCount++;
			} else {
				if (maxCount == 0) {
					maxCount = currentCount;
					currentCount = 1;
				} else if (currentCount > maxCount) {
					maxNum = nums[i - 1];
					maxCount = currentCount;
					currentCount = 1;
				}

			}
		}
		return maxCount > currentCount ? maxNum : nums[nums.length - 1];
	}

	public static void main(String[] args) {
		MajorityElement test = new MajorityElement();
		// int[] nums = { 3, 3, 4 };
		// int[] nums = { 3, 2, 3 };
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int result = test.majorityElement1(nums);
		System.out.println(result);
	}
}
