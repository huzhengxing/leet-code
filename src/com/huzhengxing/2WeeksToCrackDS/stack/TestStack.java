package com.huzhengxing.stack;

import com.huzhengxing.stack.MyStack;

/**
 * @Auther: Albert
 * @Date: 2020/1/31 13:10
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class TestStack {

    public static void main(String[] args) {

        MyStack myStack = new MyStack();

        myStack.push("1");
        myStack.push("2");
        myStack.push("3");
        myStack.push("4");
        myStack.push("5");
        myStack.show();
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.peek());
    }
}
