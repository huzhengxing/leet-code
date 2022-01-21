/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-14 20:04:30
 * @LastEditTime: 2022-01-14 22:52:12
 * @Description: https://leetcode.com/problems/reshape-the-matrix/
 */
package com.huzhengxing.array;

public class ReshapeTheMatrix {

	public int[][] matrixReshape(int[][] mat, int r, int c) {
		int originalRows = mat.length;
		int originalCols = mat[0].length;
		if (r * c != originalRows * originalCols) {
			return mat;
		}
		int[] tmp = new int[r * c];
		int index = 0;
		first: for (int i = 0; i < mat.length; i++) {
			int[] row = mat[i];
			for (int j = 0; j < row.length; j++) {
				if (index > r * c - 1) {
					break first;
				}
				tmp[index++] = row[j];
			}
		}
		int[][] result = new int[r][c];
		for (int i = 0; i < tmp.length; i++) {
			result[i / c][i % c] = tmp[i];
		}

		return result;
	}

	public int[][] matrixReshape1(int[][] mat, int r, int c) {
		int m = mat.length;
		int n = mat[0].length;
		if (m * n != r * c) {
			return mat;
		}

		int[][] ans = new int[r][c];
		for (int x = 0; x < m * n; ++x) {
			ans[x / c][x % c] = mat[x / n][x % n];
		}
		return ans;
	}

	public static void main(String[] args) {
		ReshapeTheMatrix reshape = new ReshapeTheMatrix();
		int[][] mat = { { 1, 2 } };
		int r = 1;
		int c = 1;
		int[][] result = reshape.matrixReshape(mat, r, c);
		System.out.println(result);
	}
}