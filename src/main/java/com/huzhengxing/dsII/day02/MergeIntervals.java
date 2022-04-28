package com.huzhengxing.dsII.day02;

import java.util.Arrays;

/*
         * @Author: zhengxing.hu
 * @Date: 2022-01-26 18:22:04
 * @LastEditTime: 2022-01-29 15:21:41
 * @Description: 
 * 
https://leetcode.com/problems/merge-intervals/
Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
and return an array of the non-overlapping intervals that cover all the intervals in the input.
 */
public class MergeIntervals {

    public int[][] merge(int[][] intervals) {

        int i = 0;
        int j = 1;
        int length = intervals.length;
        int[][] tmp = new int[length][2];
        while (i < intervals.length - 1) {
            int[] firstArr = intervals[i];
            int[] secondArr = intervals[i + 1];
            int lastValOfFirstArr = firstArr[firstArr.length - 1];
            int firstValOfSecondArr = secondArr[0];
            int lastValOfSecondArr = secondArr[secondArr.length - 1];
            if (lastValOfFirstArr <= firstValOfSecondArr) {
                tmp[i] = firstArr;
                i++;
                j++;
            } else if (lastValOfFirstArr <= lastValOfSecondArr) {
                firstArr[1] = lastValOfSecondArr;
                tmp[i] = firstArr;
                i++;
                j += 2;
                if (i == intervals.length - 2) {
                    tmp[i + 1] = intervals[j + 1];
                }
            }
        }
        int[][] result = new int[i + 1][2];
        Arrays.copyOf(tmp, i + 1);
        return result;
    }
}
