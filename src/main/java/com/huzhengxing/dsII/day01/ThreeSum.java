/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-25 14:30:29
 * @LastEditTime: 2022-01-25 17:20:05
 * @Description: 
https://leetcode.com/problems/3sum/
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
 */
package com.huzhengxing.dsII.day01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Set<String> sets = new HashSet<>();
		int length = nums.length;
		if (length < 3)
			return result;
		Arrays.sort(nums);
		int first = 0;
		int second = 1;
		int third = 2;
		while (first < length && second < length && third < length) {
			List<Integer> tmp = new ArrayList<>();
			int firstValue = nums[first];
			int secondValue = nums[second];
			int thirdValue = nums[third];
			if (firstValue + secondValue + thirdValue == 0) {
				String s = String.valueOf("" + firstValue + secondValue + thirdValue);
				if (!sets.contains(s)) {
					tmp.add(firstValue);
					tmp.add(secondValue);
					tmp.add(thirdValue);
					sets.add(s);
					result.add(tmp);
				}

			}
			if (third == length - 1) {
				if (second == length - 2) {
					first++;
					second = first + 1;
					third = second + 1;
				} else {
					second++;
					third = second + 1;
				}

			} else {
				third++;
			}
		}
		return result;
	}

	public List<List<Integer>> threeSum1(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int length = nums.length;
		if (length < 3)
			return result;
		int first = 0;
		int second = 1;
		int third = 2;
		while (first < length && second < length && third < length) {
			List<Integer> tmp = new ArrayList<>();
			int firstValue = nums[first];
			int secondValue = nums[second];
			int thirdValue = nums[third];
			if (firstValue + secondValue + thirdValue == 0) {
				tmp.add(firstValue);
				tmp.add(secondValue);
				tmp.add(thirdValue);
				result.add(tmp);
			}

		}
		if (third == length - 1) {
			if (second == length - 2) {
				first++;
				second = first + 1;
				third = second + 1;
			} else {
				second++;
				third = second + 1;
			}

		} else {
			third++;
		}
		return new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(result));

	}

	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int length = nums.length;
		if (length < 3)
			return result;
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		for (int i = 0; i < length; i++) {
			for (int j = i + 1; j < length; j++) {
				int firstValue = nums[i];
				int secondValue = nums[j];
				int thirdValue = 0 - firstValue - secondValue;
				Integer count = map.get(thirdValue);
				if (count == null) {
					continue;
				}
				boolean exist = true;
				if (firstValue == thirdValue || secondValue == thirdValue) {
					exist = count > 1;
				}
				if (firstValue == 0 && secondValue == 0) {
					exist = count > 2;
				}
				if (exist) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(firstValue);
					tmp.add(secondValue);
					tmp.add(thirdValue);
					result.add(tmp);
				}

			}
		}

		return new ArrayList<List<Integer>>(new LinkedHashSet<List<Integer>>(result));

	}

	public List<List<Integer>> threeSum3(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		int length = nums.length;
		if (length < 3)
			return result;
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < length; i++) {
			if (nums[i] > 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < length; j++) {
				// must less 0
				int firstValue = nums[i];
				int secondValue = nums[j];
				if (firstValue + secondValue > 0) {
					break;
				}
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				// must greater 0
				int thirdValue = 0 - firstValue - secondValue;
				if (thirdValue < 0) {
					continue;
				}
				if (map.containsKey(thirdValue) && map.get(thirdValue) > j) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(firstValue);
					tmp.add(secondValue);
					tmp.add(thirdValue);
					result.add(tmp);
				}

			}
		}
		return result;
	}

	public List<List<Integer>> threeSum4(int[] nums) {
		Arrays.sort(nums);// 排序 为了后面去重
		HashMap<Integer, Integer> hm = new HashMap<>();
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {
			hm.put(nums[i], i);// 根据containsKey选择nums[i]为key
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				break;
			if (i > 0 && nums[i] == nums[i - 1])
				continue;// 去重
			int target = nums[i] * (-1);
			for (int j = i + 1; j < nums.length; j++) {
				if (j > i + 1 && nums[j] == nums[j - 1])
					continue;// 去重
				int k = target - nums[j];
				if (hm.containsKey(k)) {
					if (hm.get(k) > j) {
						List<Integer> is = new ArrayList<Integer>();
						is.add(nums[i]);
						is.add(nums[j]);
						is.add(k);
						list.add(is);

					}
				}
			}

		}
		return list;

	}

	public static void main(String[] args) {
		ThreeSum test = new ThreeSum();
		// int[] nums = { -1, 0, 1, 2, -1, -4 };
		int[] nums = { 0, 0, 0, 0 };
		List<List<Integer>> result = test.threeSum3(nums);
		System.out.println(result);
	}
}
