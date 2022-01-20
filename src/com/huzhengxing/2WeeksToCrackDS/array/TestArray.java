package com.huzhengxing.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Albert
 * @Date: 2020/1/30 22:59
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class TestArray {

    public static void main(String[] args) {

        MyArray myArray = new MyArray();
        myArray.add(1);
        myArray.add(2);
        myArray.add(3);
        myArray.add(2);
        myArray.show();
        myArray.remove(2);
        myArray.show();
        System.out.println(myArray.get(4));
        System.out.println(myArray.indexOf(2));
        System.out.println("12341234213");

    }
}
