package com.example.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        // 创建一个环形队列
        System.out.println("测试数组模拟环形队列");
        CircleArrayQueue arrayQueue = new CircleArrayQueue(3);
        char key = ' ';  // 接收用户输入
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit)：退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列中取出数据");
            System.out.println("h(head)：查看队列头的一个数据");
            key = scanner.next().charAt(0);  // 接收一个字符
            switch (key) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.print("请输入一个数字：");
                    int value = scanner.nextInt();
                    arrayQueue.addQueue(value);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.getQueue();
                        System.out.println("取出的数据是：" + result);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int head = arrayQueue.getHead();
                        System.out.println("队列头的数据是：" + head);
                    } catch (RuntimeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                default:
                    break;
            }
        }
        System.out.println("程序退出。");

    }
}

/**
 * 模拟环形队列
 * 循环队列的思想：永远预留一个空的格子。如果只剩下一个空格子了，代表队列满了。
 *
 * 队列头部:front指向的元素
 * 队列尾部：rear指向元素的前一个元素
 * rear指向哪里，代表哪里可以插入
 * front指向哪里，哪里就是队列头
 * 如果rear==front，代表队列空
 */
class CircleArrayQueue {
    private int maxSize;  // 表示数组的最大容量
    private int front;  // 队列头
    private int rear;  // 队列最后一个元素的后一个元素
    private int[] arr;  // 模拟环形队列

    public CircleArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 队列是否满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    /**
     * 添加数据到队列
     *
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满，不能添加数据");
            return;
        }
        // 直接将数据加入
        arr[rear] = n;
        // 将rear指针移动
        rear = (rear + 1) % maxSize;
    }

    /**
     * 从队列中取出数据
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        // 1、先把front对应的值保存到一个临时变量
        int value = arr[front];
        // 2、将front后移
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 获取队列中元素的个数
     *
     * @return
     */
    public int getCount() {
        return (rear + maxSize - front) % maxSize;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = front; i < front + getCount(); i++) {
            System.out.printf("arr[%d] = %d\n", (i % maxSize), arr[i % maxSize]);
        }
    }

    /**
     * 显示队列的第一个元素
     */
    public int getHead() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，没有数据");
        }
        return arr[front];
    }

}
