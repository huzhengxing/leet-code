package com.huzhengxing.algoI.day01;

/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-25 18:35:15
 * @LastEditTime: 2022-01-25 19:16:47
 * @Description: 
https://leetcode.com/problems/first-bad-version/
You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. 
Since each version is developed based on the previous version, all the versions after a bad version are also bad.
Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
 */
public class FirstBadVersion {

	public int firstBadVersion(int n) {
		return firstBadVersion(1, n);
	}

	public int firstBadVersion(int start, int end) {
		int idx = start + (end - start) / 2;
		boolean badVersion = isBadVersion(idx);
		if (badVersion && (!isBadVersion(idx - 1) || idx == 1)) {
			return idx;
		}
		if (idx < 1) {
			return -1;
		}
		if (badVersion) {
			idx = firstBadVersion(start, idx - 1);
		} else {
			idx = firstBadVersion(idx + 1, end);
		}
		return idx;
	}

	public boolean isBadVersion(int n) {
		if (n >= 1702766719) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		FirstBadVersion test = new FirstBadVersion();
		int result = test.firstBadVersion(2126753390);
		System.out.println(result);
	}
}
