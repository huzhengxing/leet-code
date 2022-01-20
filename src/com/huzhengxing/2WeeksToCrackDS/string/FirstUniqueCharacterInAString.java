/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-19 14:03:28
 * @LastEditTime: 2022-01-19 15:45:52
 * @Description: 
 */
package com.huzhengxing.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstUniqueCharacterInAString {

	public int firstUniqChar5(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int i = 0;
		while (i < s.length()) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			i++;
		}
		int j = 0;
		while (j < s.length()) {
			if (map.get(s.charAt(j)) == 1) {
				return j;
			}
			j++;
		}
		return -1;

	}

	public int firstUniqChar(String s) {
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = s.toCharArray();
		int i = 0;
		while (i < chars.length) {
			Integer charIndex = map.get(chars[i]);
			if (charIndex != null) {
				chars[i] = ' ';
				chars[charIndex] = ' ';
			} else {
				map.put(chars[i], i);
			}
			i++;

		}
		int result = -1;
		for (int j = 0; j < chars.length; j++) {
			if (chars[j] != ' ') {
				result = j;
				break;
			}
		}
		return result;
	}

	public int firstUniqChar4(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int[] freq = new int[s.length()];
		int i = 0;
		while (i < s.length()) {
			Integer charIndex = map.get(s.charAt(i));
			if (charIndex != null) {
				int f = freq[charIndex];
				freq[i] = f + 1;
				freq[charIndex] = f + 1;
			} else {
				map.put(s.charAt(i), i);
			}
			i++;

		}
		int result = -1;
		for (int j = 0; j < freq.length; j++) {
			if (freq[j] == 0) {
				result = j;
				break;
			}
		}
		return result;
	}

	public int firstUniqChar1(String s) {
		Map<Character, Integer> map = new HashMap<>();
		List<Integer> idx = new ArrayList<>();
		char[] chars = s.toCharArray();
		int i = 0;
		while (i < chars.length) {
			Integer charIndex = map.get(chars[i]);
			if (charIndex != null) {
				idx.remove(charIndex);
			} else {
				map.put(chars[i], i);
				idx.add(i);
			}
			i++;

		}
		return idx.isEmpty() ? -1 : idx.get(0);
	}

	public int firstUniqChar3(String s) {
		Map<Character, Integer> map = new HashMap<>();
		char[] chars = s.toCharArray();
		int i = 0;
		int result = -1;
		while (i < chars.length) {
			Integer charIndex = map.get(chars[i]);
			if (charIndex != null && charIndex == result) {
				result = -1;
			} else {
				map.put(chars[i], i);
				if (result == -1)
					result = i;
			}
			i++;

		}
		return result;
	}

	public static void main(String[] args) {
		FirstUniqueCharacterInAString charString = new FirstUniqueCharacterInAString();
		// String s = "Leetcode";
		// String s = "loveleetcode";
		String s = "aabb";
		int result = charString.firstUniqChar5(s);
		System.out.println(result);
	}
}
