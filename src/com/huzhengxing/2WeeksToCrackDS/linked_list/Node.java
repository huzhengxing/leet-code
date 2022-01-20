package com.huzhengxing.linked_list;

/**
 * @Auther: Albert
 * @Date: 2020/1/31 21:01
 * @Contact: 1092144169@qq.com
 * @Description: 链表节点
 */
public class Node {



    /**
     * 数据数据
     */
    Object data;

    /**
     * 记录下一个数据
     */
    Node next;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
