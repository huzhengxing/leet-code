package main.java.com.huzhengxing.easy;

import java.util.Stack;

/**
 * @Auther: Albert
 * @Date: 2020/2/12 17:17
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class Test {

    private static int[] values;

    private static int size;
    private Stack stack = new Stack();


    ListNode reverseNode(ListNode node, ListNode resultNode) {
        size++;
        if (resultNode == null) {
            if (node.next == null) {
                return node;
            }
            resultNode = new ListNode(node.value);
        } else {
            ListNode nextNode = new ListNode(node.value);
            nextNode.next = resultNode;
            resultNode = nextNode;
        }
        if (node.next != null) {
            return reverseNode(node.next, resultNode);
        }
        return resultNode;

    }

    void getValue(ListNode node) {
        stack.push(node.value);
        if (node.next != null) {
            getValue(node);
        }
    }

    void getValue2(ListNode node) {
        if (node.next != null) {
            getValue2(node);
        }
    }

    int[] method1(ListNode head) {
        int[] values = new int[stack.size()];
        for (int i = 0; i < values.length; i++) {
            values[i] = (int) stack.peek();
            stack.pop();
        }
        return values;
    }

    int[] method2(ListNode head) {
        ListNode listNode = reverseNode(head, null);
        getValue2(listNode);
        return values;
    }

    public int[] reversePrint(ListNode head) {
        return method2(head);
    }

    public static void main(String[] args) {
        Test test = new Test();
        ListNode listNode = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        listNode1.next = listNode2;
        listNode.next = listNode1;

        System.out.println(test.reversePrint(listNode));

    }
}

class ListNode {

    int value;

    ListNode next;

    public ListNode() {
    }

    public ListNode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
