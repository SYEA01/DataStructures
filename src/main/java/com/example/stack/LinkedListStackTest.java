package com.example.stack;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 使用链表模拟栈
 */
public class LinkedListStackTest {
    public static void main(String[] args) {
        // 测试
        LinkedListStack stack = new LinkedListStack(4);
        String key = "";
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            System.out.println("show：表示显示栈");
            System.out.println("exit：表示退出程序");
            System.out.println("push：表示入栈");
            System.out.println("pop：表示出栈");
            System.out.println("请输入你的选择：");
            key = scanner.next();
            switch (key) {
                case "show":
                    stack.list();
                    break;
                case "push":
                    System.out.print("请输入一个数： ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;
                case "pop":
                    try {
                        int res = stack.pop();
                        System.out.printf("取出的数据是：%d\n", res);
                    } catch (Exception e) {
                        System.out.println("e:" + e.getMessage());
                    }
                    break;
                case "exit":
                    scanner.close();
                    loop = false;
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

/**
 * 模拟链表
 */
@Data
class ListNode {
    private int val;
    private ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

/**
 * 链表模拟栈
 */
class LinkedListStack {
    private ListNode head = new ListNode(-1);
    private int maxSize;

    public LinkedListStack(int maxSize) {
        this.maxSize = maxSize;
    }

    // 栈满
    public boolean isFull() {
        ListNode curr = head.getNext();
        int count = 0;
        while (curr != null) {
            count++;
            curr = curr.getNext();
        }
        return count == maxSize;
    }

    // 栈空
    public boolean isEmpty() {
        return head.getNext() == null;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满。");
            return;
        }
        ListNode node = new ListNode(value);
        ListNode curr = head;
        while (curr.getNext() != null) {
            curr = curr.getNext();
        }
        curr.setNext(node);
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空。");
        }
        ListNode curr = head;
        while (curr.getNext().getNext() != null) {
            curr = curr.getNext();
        }
        int value = curr.getNext().getVal();
        curr.setNext(null);
        return value;
    }

    // 遍历栈
    public void list() {
        ListNode temp = head;
        List<Integer> list = new ArrayList<>();
        while (temp.getNext() != null) {
            list.add(0, temp.getNext().getVal());
            temp = temp.getNext();
        }
        list.forEach(System.out::println);
    }

}
