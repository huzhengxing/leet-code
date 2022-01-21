/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-19 15:48:37
 * @LastEditTime: 2022-01-19 17:01:02
 * @Description: https://leetcode.com/problems/ransom-note/
 * Given two stings ransomNote and magazine, return true if ransomNote can be constructed from magazine and false otherwise.
	Each letter in magazine can only be used once in ransomNote.
 */
package com.huzhengxing.string;

import java.util.HashMap;
import java.util.Map;

public class RansomNode {
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		while (i < ransomNote.length()) {
			map.put(ransomNote.charAt(i), map.getOrDefault(ransomNote.charAt(i), 0) + 1);
			i++;
		}
		int j = 0;
		while (j < magazine.length()) {
			if (map.isEmpty()) {
				return true;
			}
			char c = magazine.charAt(j);
			Integer count = map.get(c);
			if (count != null) {
				if (count == 1) {
					map.remove(c);
				} else {
					map.put(c, count - 1);
				}
			}
			j++;

		}

		return map.isEmpty();
	}

	public boolean canConstruct3(String ransomNote, String magazine) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		while (i < magazine.length()) {
			map.put(magazine.charAt(i), map.getOrDefault(magazine.charAt(i), 0) + 1);
			i++;
		}
		int j = 0;
		while (j < ransomNote.length()) {
			char c = ransomNote.charAt(j);
			Integer count = map.get(c);
			if (count == null) {
				return false;
			} else {
				if (count == 1) {
					map.remove(c);
				} else {
					map.put(c, count - 1);
				}
			}
			j++;

		}
		return true;
	}

	public boolean canConstruct1(String ransomNote, String magazine) {
		int[] nums = new int[26];
		for (int i = 0; i < magazine.length(); i++) {
			int idx = magazine.charAt(i) - 'a';
			nums[idx]++;
		}

		for (int i = 0; i < ransomNote.length(); i++) {
			int idx = ransomNote.charAt(i) - 'a';
			if (nums[idx] == 0) {
				return false;
			} else if (nums[idx] > 0) {
				nums[idx]--;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		RansomNode ransomNote = new RansomNode();

		String ransom = "aa";
		String magazine = "aab";
		// String ransom = "aa";
		// String magazine = "ab";
		// String ransom = "a";
		// String magazine = "b";
		boolean result = ransomNote.canConstruct3(ransom, magazine);
		System.out.println(result);
	}
}
