package com.huzhengxing.queue;

import com.huzhengxing.queue.MyQueue;

/**
 * @Auther: Albert
 * @Date: 2020/1/31 20:47
 * @Contact: 1092144169@qq.com
 * @Description:
 */
public class TestMyQueQue {

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.add("1");
        myQueue.add("2");
        myQueue.add("3");
        myQueue.add("4");
        myQueue.add("5");
        myQueue.show();
        System.out.println(myQueue.peek());
        myQueue.poll();
        myQueue.show();


    }
}
