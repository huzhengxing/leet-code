package com.huzhengxing.array;

import java.util.HashSet;
import java.util.Set;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-11 15:44:15
 * @LastEditTime: 2022-01-13 19:59:45
 * @Description: 
 * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct. 
 * https://leetcode.com/problems/contains-duplicate/
 */
public class ContainsDuplicate {

	static class Solution {
		public boolean containsDuplicate(int[] nums) {
			// for (int i = 0; i < nums.length; i++ ){
			// 	for (int j = i+1; j < nums.length; j++){
			// 		if (nums[i] == nums[j]) {
			// 			return true;
			// 		}
			// 	}
			// }


			Boolean bl = false;
			Set<Integer> set = new HashSet<Integer>();
			for (int i = 0; i < nums.length; i++) {
				if (set.contains(nums[i])){
					return true;
				} else {
					set.add(nums[i]);
				}	
			}
			return bl;
		}
		
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int [] nums = {1,2,3,1};
		System.out.println(solution.containsDuplicate(nums)); 
	}	

}
