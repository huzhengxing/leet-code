package com.huzhengxing.dsII.day01;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-25 11:18:39
 * @LastEditTime: 2022-01-25 13:13:12
 * @Description: 
https://leetcode.com/problems/single-number/
Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
public class SingleNumber {

	public int singleNumber(int[] nums) {
		Set<Integer> sets = new HashSet<Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (sets.contains(nums[i])) {
				sets.remove(nums[i]);
			} else {
				sets.add(nums[i]);
			}
		}
		return sets.iterator().next();
	}

	public int singleNumber1(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			Integer num = map.get(nums[i]);
			if (num == null) {
				map.put(nums[i], i);
			} else {
				map.remove(nums[i]);
			}
		}
		return map.keySet().iterator().next();
	}

	public int singleNumber2(int[] nums) {
		int result = 0;
		for (int i : nums)
			result ^= i;
		return result;
	}
}
