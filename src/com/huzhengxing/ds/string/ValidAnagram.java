/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-19 17:09:50
 * @LastEditTime: 2022-01-19 17:28:05
 * @Description: https://leetcode.com/problems/valid-anagram/ 
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
package com.huzhengxing.string;

public class ValidAnagram {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}
		int[] letters = new int[26];
		for (int i = 0; i < s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			letters[idx]++;
		}
		for (int i = 0; i < t.length(); i++) {
			int idx = t.charAt(i) - 'a';
			if (letters[idx] == 0) {
				return false;
			} else {
				letters[idx]--;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "anagram";
		String t = "nagaram";
		// String s = "rat";
		// String t = "cat";
		ValidAnagram a = new ValidAnagram();
		boolean result = a.isAnagram(s, t);
		System.out.println(result);
	}
}