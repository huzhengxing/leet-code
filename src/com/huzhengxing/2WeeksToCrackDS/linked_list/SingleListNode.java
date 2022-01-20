package com.huzhengxing.linked_list;

/**
 * @Auther: Albert
 * @Date: 2020/1/31 21:08
 * @Contact: 1092144169@qq.com
 * @Description: 单链表节点
 */
public class SingleListNode {

    private Object data;

    private SingleListNode next;


    public SingleListNode(Object data) {
        this.data = data;
    }

    /**
     * 链表添加数据
     *
     * @param node
     */
    public SingleListNode append(SingleListNode node) {
        getLastNode(this).next = node;
        return this;
    }


    /**
     * 删除数据
     */
    public void remove(Object data) {
        getNodeByData(this,data);

    }

    public void getNodeByData(SingleListNode node, Object data) {
        if (node.next.data.equals(data)) {
            if (node.next.next != null) {
                node.next = node.next.next;
            }
        } else {
            getNodeByData(node.next, data);
        }
    }


    /**
     * @param node
     * @return
     */
    public SingleListNode getLastNode(SingleListNode node) {
        if (node.next != null) {
            return getLastNode(node.next);
        } else {
            return node;
        }
    }

    /**
     * 显示该节点下，所有子节点数据
     */
    public void show() {
        printData(this);
        System.out.println();
    }

    private void printData(SingleListNode node) {
        System.out.print(node.data);
        if (node.next != null) {
            printData(node.next);
        }
    }

    public static void main(String[] args) {
        SingleListNode n1 = new SingleListNode("1");
        SingleListNode n2 = new SingleListNode("2");
        SingleListNode n3 = new SingleListNode("3");
        SingleListNode n4 = new SingleListNode("4");
        SingleListNode n5 = new SingleListNode("5");
        n1.append(n2).append(n3).append(n4).append(n5).append(n1);
        System.out.println(n5.next.data);


    }
}
