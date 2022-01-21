package com.huzhengxing.stack;

import java.util.Arrays;

/**
 * @Auther: Albert
 * @Date: 2020/1/31 12:17
 * @Contact: 1092144169@qq.com
 * @Description: 栈结构
 * <p>
 * 1. 压栈
 * 2. 出栈
 */
public class MyStack {

    Object[] elementData;


    public MyStack() {
        this.elementData = new Object[0];
    }

    /**
     * 压栈
     *
     * @param element
     */
    void push(Object element) {
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
     * 出栈
     */
    void pop() {
        Object[] newElementData = new Object[elementData.length - 1];
        for (int i = 0; i < newElementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        this.elementData = newElementData;
    }

    /**
     * 查看栈顶元素
     *
     * @return
     */
    Object peek() {
        if (isEmpty()) {
            throw new RuntimeException("stack is empty");
        }
        return elementData[elementData.length - 1];
    }

    //打印数组元素
    public void show() {
        System.out.println(Arrays.toString(this.elementData));
    }

    /**
     * 判断栈是否卫康
     *
     * @return
     */
    boolean isEmpty() {
        return elementData.length == 0;
    }

}
