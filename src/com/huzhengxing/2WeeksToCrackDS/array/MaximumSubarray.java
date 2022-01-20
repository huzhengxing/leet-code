/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-11 18:00:59
 * @LastEditTime: 2022-01-11 20:30:13
 * @Description: 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 * A subarray is a contiguous part of an array.
 */
package com.huzhengxing.array;

public class MaximumSubarray {

	static class Solution {
		public int maxSubArray(int[] nums) {
			int n = nums.length;
			int max = Integer.MIN_VALUE, sum = 0;

			for (int i = 0; i < n; i++) {
				sum += nums[i];
				max = Math.max(sum, max);

				if (sum < 0)
					sum = 0;
			}

			return max;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		// int[] nums = { 5, 4, -1, 7, 8 };
		// int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] nums = { -2, -1 };
		int sum = solution.maxSubArray(nums);
		System.out.println(sum);
	}

}
