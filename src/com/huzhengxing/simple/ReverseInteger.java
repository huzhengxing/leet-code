package com.huzhengxing.simple;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * @Auther: Albert
 * @Date: 2019/3/12 23:15
 * @Description: 整数反转
 */
public class ReverseInteger {

    /**
     * 问题：1 存在负号无法处理
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {

        try {
            /*
                1. x 转成字符
                2. 遍历 倒排

             */

            char[] c = String.valueOf(x).toCharArray();

            if (x < 0) {
                char[] newChar = new char[c.length - 1];
                for (int i = c.length - 1; i > 0; i--) {
                    newChar[c.length - 1 - i] = c[i];
                }
                int newX = Integer.parseInt(String.valueOf(newChar));
                return newX - 2 * newX;


            } else {
                char[] newChar = new char[c.length];
                for (int i = c.length - 1; i >= 0; i--) {
                    newChar[c.length - 1 - i] = c[i];
                }
                return Integer.parseInt(String.valueOf(newChar));
            }


        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static void main(String[] args) {
        System.out.println(reverse(112300));
    }
}
