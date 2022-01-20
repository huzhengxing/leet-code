/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-12 20:18:13
 * @LastEditTime: 2022-01-12 20:53:01
 * @Description: 
 */
package com.huzhengxing.array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;

	}

	public int[] twoSum1(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int subNum = target - nums[i];
			Integer subNumIndex = map.get(subNum);
			if (subNumIndex == null)
				map.put(nums[i], i);
			else {
				result[0] = i;
				result[1] = subNumIndex;
				break;
			}
		}
		return result;

	}

	public static void main(String[] args) {
		TwoSum twoSum1 = new TwoSum();
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		twoSum1.twoSum1(nums, target);

	}
}
