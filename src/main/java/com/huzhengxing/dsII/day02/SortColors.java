/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-26 18:21:10
 * @LastEditTime: 2022-02-09 19:12:54
 * @Description: 
 */
package com.huzhengxing.dsII.day02;

/**
 * @Author: zhengxing.hu
 * @Date: 2022-01-26 18:21:10
 * @LastEditTime: 2022-01-26 18:21:11
 * @Description:
 *               https://leetcode.com/problems/sort-colors/
 * 
 *               Given an array nums with n objects colored red, white, or blue,
 *               sort them in-place so that objects of the same color are
 *               adjacent, with the colors in the order red, white, and blue.
 *               We will use the integers 0, 1, and 2 to represent the color
 *               red, white, and blue, respectively.
 *               You must solve this problem without using the library's sort
 *               function.
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int length = nums.length;
		int zeroSize = 0;
		int oneSize = 0;
		int twoSize = 0;
		for (int i = 0; i < length; i++) {
			int value = nums[i];
			if (value == 0) {
				zeroSize++;
				continue;
			}
			if (value == 1) {
				oneSize++;
				continue;
			}
			if (value == 2) {
				twoSize++;
				continue;
			}
		}
		for (int i = 0; i < length; i++) {
			if (i < zeroSize) {
				nums[i] = 0;
				continue;
			}
			if ((i - zeroSize) < oneSize) {
				nums[i] = 1;
				continue;
			}
			if ((i - zeroSize - oneSize) < twoSize) {
				nums[i] = 2;
				continue;
			}
		}
	}

	public void sortColors1(int[] nums) {
		// 0 -> [0,m)
		// 1 -> [m,n)
		// 2 -> (n,length-1]
		int length = nums.length;
		if (length < 2) {
			return;
		}
		int m = 0;
		int n = length - 1;
		int i = 0;
		while (i <= n) {
			if (nums[i] == 0) {
				swap(nums, m, i);
				i++;
				m++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				swap(nums, n, i);
				n--;
			}
		}
	}

	public void swap(int[] nums, int index1, int index2) {
		int tmp = nums[index1];
		nums[index1] = nums[index2];
		nums[index2] = tmp;
	}

	public static void main(String[] args) {
		SortColors test = new SortColors();
		int[] nums = { 2, 0, 2, 1, 1, 0 };
		test.sortColors1(nums);

	}
}
