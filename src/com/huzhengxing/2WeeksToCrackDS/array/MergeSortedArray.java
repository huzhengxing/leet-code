/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-12 21:05:05
 * @LastEditTime: 2022-01-13 00:14:57
 * @Description: https://leetcode.com/problems/merge-sorted-array/
 */
package com.huzhengxing.array;

public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// 1. Iterate n of inserted
		int startIndex = -1;
		for (int i = 0; i < n; i++) {
			// 2. The nums2 of n insert to array of nums1
			int insertNum = nums2[i];
			int indexOfSearch = binarySearch(nums1, insertNum, startIndex);
			if (indexOfSearch == -1) {
				nums1[m + i] = insertNum;
			} else {
				for (int j = m + i; j > indexOfSearch; j--) {
					nums1[j] = nums1[j - 1];
				}
				nums1[indexOfSearch] = insertNum;
			}

		}
	}

	public int binarySearch(int[] nums, int target, int startIndex) {
		for (int i = startIndex + 1; i < nums.length; i++) {
			if (target < nums[i]) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums1 = { 2, 0 };
		int[] nums2 = { 1 };
		int m = 1;
		int n = 1;
		MergeSortedArray merge = new MergeSortedArray();
		merge.merge(nums1, m, nums2, n);
	}
}
