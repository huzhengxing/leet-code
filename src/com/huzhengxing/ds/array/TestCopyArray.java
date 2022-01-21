package com.huzhengxing.array;

import java.util.Arrays;

/**
 * @Auther: Albert
 * @Date: 2020/1/31 19:44
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class TestCopyArray {

    public static void main(String[] args) {

        int[] src = new int[]{1, 2, 3, 4, 5};
        int[] dest = new int[3];
        /**
         * src: 原数组
         * srcPos: 原数组从那个索引开始复制
         * dest: 目标索引
         * destPos: 目标数组的从哪个所以开始覆盖
         * length: 需要复制的数组的个数
         */
        System.arraycopy(src,1,dest,0,2);
        System.out.println(Arrays.toString(dest));

    }
}
