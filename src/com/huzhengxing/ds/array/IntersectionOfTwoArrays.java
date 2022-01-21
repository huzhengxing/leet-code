/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-13 13:57:08
 * @LastEditTime: 2022-01-13 19:50:59
 * @Description: https://leetcode.com/problems/intersection-of-two-arrays-ii/
 * 
 * Given two integer arrays nums1 and nums2, return an array of their intersection.
 * Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.
 */
package com.huzhengxing.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays {

	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> nums1Map = new HashMap<Integer, Integer>();
		for (int num : nums1) {
			Integer value = nums1Map.get(num);
			if (value == null) {
				nums1Map.put(num, 1);
			} else {
				nums1Map.put(num, value + 1);
			}
		}
		int[] result = new int[1000];
		int index = 0;
		for (int num2 : nums2) {
			Integer value = nums1Map.get(num2);
			if (value == null) {
				continue;
			}
			if (value == 1) {
				result[index++] = num2;
				nums1Map.remove(num2);
			} else if (value > 1) {
				result[index++] = num2;
				nums1Map.put(num2, value - 1);
			}

		}
		return Arrays.copyOfRange(result, 0, index);

	}

	public int[] intersect3(int[] nums1, int[] nums2) {
		// Store nums1 using array
		int[] nums1Store = new int[1001];
		for (int i = 0; i < nums1.length; i++) {
			nums1Store[nums1[i]] += 1;
		}

		int[] intersectionArr = new int[1001];
		int index = 0;
		for (int i = 0; i < nums2.length; i++) {
			int num2 = nums2[i];
			if (nums1Store[num2] > 0) {
				intersectionArr[index++] = num2;
				nums1Store[num2] -= 1;
			}
		}
		return Arrays.copyOfRange(intersectionArr,0,index);

	}

	public int[] getArrayOfIntersection(int[] nums1, int[] nums2, int start, int end) {
		int lengthMax = 0;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int startIdx = 0;
		boolean firstTimeSame = true;
		int numsOfSame = 0;
		for (int i = start; i < end; i++) {
			if (nums1[i] == nums2[i]) {
				if (firstTimeSame) {
					startIdx = i;
					firstTimeSame = false;
				}
				numsOfSame++;
			} else {
				if (!firstTimeSame) {

				}
			}
		}
		Integer value = map.get(numsOfSame);
		if (value == null) {
			map.put(numsOfSame, startIdx);
		}
		int[] result = new int[lengthMax];
		int index = 0;
		for (int i = map.get(lengthMax); i < lengthMax; i++) {
			result[index] = nums1[i];
			index++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = { 4, 7, 9, 7, 6, 7 };
		int[] nums2 = { 5, 0, 0, 6, 1, 6, 2, 2, 4 };
		IntersectionOfTwoArrays intersect = new IntersectionOfTwoArrays();
		int[] nums = intersect.intersect3(nums1, nums2);
		System.out.println(Arrays.toString(nums));

	}

	public int[] intersect1(int[] nums1, int[] nums2) {
		// better than previous -> not using ArrayList directly using array n returning
		int[] freq = new int[1001];
		for (int x : nums1) {
			freq[x]++;
		}
		int[] ar = new int[1001];
		int i = 0;
		for (int x : nums2) {
			if (freq[x] > 0) {
				ar[i++] = x;
				freq[x]--;
			}
		}
		return Arrays.copyOfRange(ar, 0, i); // trick
	}

}
