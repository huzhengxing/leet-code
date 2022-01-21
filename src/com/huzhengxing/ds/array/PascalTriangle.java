/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-14 23:02:02
 * @LastEditTime: 2022-01-14 23:46:15
 * @Description: 
 */
package com.huzhengxing.array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> result = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> innerList = new ArrayList<>();
			for (int j = 0; j < i + 1; j++) {
				if (j < 1 || j == i) {
					innerList.add(1);
				} else {
					if (i == 1) {
						innerList.add(1);
					} else {
						int rightNumAbove = result.get(i - 1).get(j - 1);
						int leftNumAbove = result.get(i - 1).get(j);
						innerList.add(rightNumAbove + leftNumAbove);
					}
				}
			}

			result.add(innerList);
		}
		return result;
	}

	public static void main(String[] args) {
		PascalTriangle p = new PascalTriangle();
		List<List<Integer>> result = p.generate(5);
		System.out.println(result);
	}
}
