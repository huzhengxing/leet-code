/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-16 00:06:27
 * @LastEditTime: 2022-01-18 16:43:10
 * @Description: https://leetcode.com/problems/valid-sudoku/
 */
package com.huzhengxing.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ValidSudodu {
	public boolean isValidSudoku(char[][] board) {
		// 1. check row
		// 2. check low
		// 3. check 9 sub-boxes
		// key is number , and value is index of number
		Map<Integer, Set<Character>> rowMap = new HashMap<>();
		// key is index of col, value is map that key is number of col
		Map<Integer, Set<Character>> colMap = new HashMap<>();

		// i j = (j / 3 + 1) + i/3 * 3
		Map<Integer, Set<Character>> boxMap = new HashMap<>();
		// iterate col
		for (int i = 0; i < board.length; i++) {
			char[] row = board[i];
			// iterate row
			for (int j = 0; j < row.length; j++) {
				char num = board[i][j];
				if (num == '.') {
					continue;
				}
				// 1. check row
				if (checkNumberExist(rowMap, i, num)) {
					return false;
				}
				// 2. check col
				if (checkNumberExist(colMap, j, num)) {
					return false;
				}
				// 3. check 9 sub-boxes 1-9
				int boxIndex = (j / 3 + 1) + i / 3 * 3;
				if (checkNumberExist(boxMap, boxIndex, num)) {
					return false;
				}

			}

		}
		return true;
	}

	public boolean checkNumberExist(Map<Integer, Set<Character>> map, int index, Character num) {
		Set<Character> set = map.get(index);
		if (set == null) {
			set = new HashSet<>();
			set.add(num);
		} else {
			if (set.contains(num)) {
				return true;
			} else {
				set.add(num);
			}
		}
		map.put(index, set);
		return false;
	}

	public static void main(String[] args) {
		char[][] sudo = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' },
				{ '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' },
				{ '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' },
				{ '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' },
				{ '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		// must be return true
		ValidSudodu validSudo = new ValidSudodu();
		boolean reuslt = validSudo.isValidSudoku(sudo);
		System.out.println(reuslt);
	}

}