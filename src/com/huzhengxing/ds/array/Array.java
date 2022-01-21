package com.huzhengxing.array;

/**
 * @Auther: Albert
 * @Date: 2020/1/30 23:12
 * @Contact: 1092144169@qq.com
 * @Description: 一个数组接口，应该具备哪些方法
 */
public interface Array {

    //添加元素
    void add(Object element);

    //删除元素
    void remove(Object element);

    //通过下标获取元素
    Object get(int index);

    //获取某一个元素的下标
    int indexOf(Object element);
}
