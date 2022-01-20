package com.huzhengxing.queue;

import java.util.Arrays;
import java.util.Queue;

/**
 * @Auther: Albert
 * @Date: 2020/1/31 13:14
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class MyQueue {

    Object[] elementData;


    public MyQueue() {
        this.elementData = new Object[0];
    }


    /**
     * 入队
     *
     * @param element
     */
    void add(Object element) {
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

    /**
     * 出队
     */
    void poll() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        Object[] newElementData = new Object[elementData.length - 1];
        //System.arraycopy(elementData, 1, newElementData, 0, newElementData.length);
        for (int i = 0; i < newElementData.length; i++) {
            newElementData[i] = elementData[i + 1];
        }
        this.elementData = newElementData;
    }

    /**
     * 查询队列头部
     *
     * @return
     */
    Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return this.elementData[0];
    }

    boolean isEmpty() {
        return elementData.length == 0;
    }

    //打印数组元素
    public void show() {
        System.out.println(Arrays.toString(this.elementData));
    }


}
