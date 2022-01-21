package com.huzhengxing.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Albert
 * @Date: 2020/1/30 23:01
 * @Contact: 1092144169@qq.com
 * @Description: 自定义数据，以及实现对应方法
 */
public class MyArray implements Array {

    //定义一个对象数组
    Object[] elementData;

    public MyArray() {
        //创建一个空对象数组
        this.elementData = new Object[0];
    }

    /**
     * 添加元素的方法，通过给数组扩容
     *
     * @param element
     */
    @Override
    public void add(Object element) {
        Object[] newElementData = new Object[elementData.length + 1];
        //创建一个扩容后的新数组
        copyArray(elementData, newElementData);
        this.elementData[elementData.length - 1] = element;
    }


    //原数组复制到扩容后的新数组
    void copyArray(Object[] array, Object[] newArray) {
        if (newArray.length < array.length) {
            throw new RuntimeException("newArray must longer than array");
        }
        //等同于 System.arraycopy(array, 0, newArray, 0, array.length);
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        this.elementData = newArray;
    }


    @Override
    public void remove(Object element) {
        Object[] newElementData = new Object[elementData.length - 1];
        int elementIndex = Integer.MAX_VALUE;
        for (int i = 0; i < elementData.length; i++) {
            if (newElementData.length - 1 < i) {
                break;
            }
            if (elementData[i].equals(element)) {
                elementIndex = i;
            }
            if (i < elementIndex) {
                newElementData[i] = elementData[i];
            } else {
                newElementData[i] = elementData[i + 1];
            }
        }
        this.elementData = newElementData;
    }

    @Override
    public Object get(int index) {
        for (int i = 0; i < elementData.length; i++) {
            if (i == index) {
                return elementData[i];
            }
        }
        throw new RuntimeException("not find element of index");
    }

    @Override
    public int indexOf(Object element) {
        for (int i = 0; i < elementData.length; i++) {
            if (elementData[i].equals(element)) {
                return i;
            }
        }
        throw new RuntimeException("not find index of element");
    }

    //打印数组元素
    public void show() {
        System.out.println(Arrays.toString(this.elementData));
    }
}
