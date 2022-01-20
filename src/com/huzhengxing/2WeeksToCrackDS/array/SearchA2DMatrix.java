/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-18 16:48:26
 * @LastEditTime: 2022-01-19 12:12:25
 * @Description: https://leetcode.com/problems/search-a-2d-matrix/
 */
package com.huzhengxing.array;

import java.util.Arrays;

public class SearchA2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		// binary search
		// 1. search col
		// 2. search row
		int[] row = searchArray(matrix, target);
		if (row.length == 0) {
			return false;
		}
		return searchTargetExist(row, target);
	}

	public boolean searchMatrix1(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			int[] row = matrix[i];
			if (row[0] == target || row[row.length - 1] == target) {
				return true;
			}
			if (target > row[0] && target < row[row.length - 1]) {
				for (int j = 0; j < row.length; j++) {
					int num = row[j];
					if (target == num) {
						return true;
					}
					if (target < num) {
						return false;
					}
				}
			}
		}
		return false;
	}

	public boolean searchMatrix2(int[][] matrix, int target) {
		int i = 0;
		int j = matrix[0].length - 1;
		while (j >= 0 && i < matrix.length) {
			if (matrix[i][j] < target) {
				i++;
			} else if (matrix[i][j] > target) {
				j--;
			} else {
				return true;
			}
		}
		return false;
	}

	public boolean searchMatrix3(int[][] matrix, int target) {
		// binary search
		// 1. search col
		// 2. search row
		int[] row = searchArray(matrix, target, 0, matrix.length - 1);
		if (row.length == 0) {
			return false;
		}
		return searchTargetExist(row, target, 0, row.length - 1);
	}

	public int[] searchArray(int[][] matrix, int target, int startIndex, int endIndex) {
		int midIndexOfRow = (endIndex + startIndex) / 2;
		int firstNumOfMidRow = matrix[midIndexOfRow][0];
		int lastNumOfMidRow = matrix[midIndexOfRow][matrix[midIndexOfRow].length - 1];
		if (target >= firstNumOfMidRow && target <= lastNumOfMidRow) {
			return matrix[midIndexOfRow];
		}
		if (endIndex - startIndex <= 0)
			return new int[0];
		if (target < firstNumOfMidRow) {
			return searchArray(matrix, target, startIndex, midIndexOfRow - 1);
		} else {
			return searchArray(matrix, target, midIndexOfRow + 1, endIndex);
		}
	}

	public boolean searchTargetExist(int[] nums, int target, int startIndex, int endIndex) {
		int midIndex = (startIndex + endIndex) / 2;
		int midNum = nums[midIndex];

		if (midNum == target) {
			return true;
		}
		if (endIndex - startIndex <= 0) {
			return false;
		}
		if (midNum > target) {
			return searchTargetExist(nums, target, startIndex, midIndex - 1);
		} else {
			return searchTargetExist(nums, target, midIndex + 1, endIndex);
		}
	}

	public int[] searchArray(int[][] matrix, int target) {
		if (matrix.length == 0) {
			return new int[0];
		}
		int midIndexOfRow = matrix.length / 2;
		int firstNumOfMidRow = matrix[midIndexOfRow][0];
		int lastNumOfMidRow = matrix[midIndexOfRow][matrix[midIndexOfRow].length - 1];
		if (target >= firstNumOfMidRow && target <= lastNumOfMidRow) {
			return matrix[midIndexOfRow];
		}
		if (midIndexOfRow == 0)
			return new int[0];
		if (target < firstNumOfMidRow) {
			return searchArray(Arrays.copyOfRange(matrix, 0, midIndexOfRow), target);
		} else {
			return searchArray(Arrays.copyOfRange(matrix, midIndexOfRow + 1, matrix.length), target);
		}
	}

	public boolean searchTargetExist(int[] nums, int target) {
		if (nums.length == 0) {
			return false;
		}
		int midIndex = nums.length / 2;
		int midNum = nums[midIndex];

		if (midNum == target) {
			return true;
		}
		if (midNum == 0) {
			return false;
		}
		if (midNum > target) {
			return searchTargetExist(Arrays.copyOfRange(nums, 0, midIndex), target);
		} else {
			return searchTargetExist(Arrays.copyOfRange(nums, midIndex + 1, nums.length), target);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
		// int[][] matrix = { { 1, 3 } };
		int target = 3;
		SearchA2DMatrix search = new SearchA2DMatrix();
		boolean result = search.searchMatrix1(matrix, target);
		System.out.println(result);
	}
}
