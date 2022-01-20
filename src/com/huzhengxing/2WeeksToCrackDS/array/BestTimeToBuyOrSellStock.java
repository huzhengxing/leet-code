/*
 * @Author: zhengxing.hu
 * @Date: 2022-01-14 15:14:24
 * @LastEditTime: 2022-01-14 19:49:15
 * @Description:  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0. 
 * 
 */
package com.huzhengxing.array;

public class BestTimeToBuyOrSellStock {

	public int maxProfit(int[] prices) {

		// 后面和前面比较找到差值最大的。
		// 记录找到最小的数；
		// 记录收益最大的index；
		if (prices.length == 1)
			return 0;
		int min = Integer.MAX_VALUE;
		int result = 0;
		for (int i = 0; i < prices.length; i++) {
			int cruGap = prices[i] - min;
			if (cruGap > result) {
				result = cruGap;
			}
			if (prices[i] < min && i != prices.length - 1) {
				min = prices[i];
			}
		}
		return result;
	}

	public int maxProfit1(int[] prices) {

		int result = 0;
		int lowestPriceDate = 0;
		for (int i = 0; i < prices.length; i++) {
			if ((prices[i] - prices[lowestPriceDate]) > result) {
				result = (prices[i] - prices[lowestPriceDate]);
			}
			if (prices[i] < prices[lowestPriceDate]) {

				lowestPriceDate = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 4, 1 };
		BestTimeToBuyOrSellStock stock = new BestTimeToBuyOrSellStock();
		int day = stock.maxProfit(nums);
		System.out.print(day);
	}
}
