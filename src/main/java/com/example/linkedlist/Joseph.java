package com.example.linkedlist;

import lombok.Data;

/**
 * 单向环形链表（约瑟夫问题）
 */
public class Joseph {
    public static void main(String[] args) {
        // 测试构建环形链表和遍历
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.add(5);
        circleSingleLinkedList.list();

        System.out.println("======================================================");
        circleSingleLinkedList.countJoseph(1, 2);

    }
}

// 先创建一个Boy类，表示一个节点
@Data
class Boy {
    private int no;  // 编号
    private Boy next;  // 指向下一个节点

    public Boy(int no) {
        this.no = no;
    }
}

// 创建一个环形单向链表
class CircleSingleLinkedList {
    // 创建一个first节点
    private Boy first = null;

    /**
     * 添加节点，构建成一个环形链表
     *
     * @param nums 新节点的数量
     */
    public void add(int nums) {
        // nums>=1
        if (nums < 1) {
            System.out.printf("nums的值%d不正确\n", nums);
            return;
        }
        Boy curr = null;  // 辅助指针，帮助构建环形链表
        // 使用for循环创建环形链表
        for (int i = 0; i < nums; i++) {
            // 根据编号创建节点
            Boy boy = new Boy(i + 1);
            if (i == 0) {  // 如果是第一个节点
                first = boy;
                first.setNext(first);  // first.next = first
                curr = first;  // 让curr指向当前节点，first不能动
            } else {  // 不是第一个节点
                curr.setNext(boy);  // 先让curr.next 指向新节点
                boy.setNext(first);  // 让新节点.next 指向first
                curr = boy;  // 将curr 移动到新节点的位置
            }
        }
    }

    /**
     * 遍历当前的环形链表
     */
    public void list() {
        // 先判断链表是否为空
        if (first == null) {
            System.out.println("链表为空。。");
            return;
        }
        // 创建一个辅助指针
        Boy curr = first;
        while (true) {
            System.out.printf("节点的编号%d\n", curr.getNo());
            if (curr.getNext() == first) {  // 如果当前节点的指针又指向了first，说明已经遍历结束了
                break;
            }
            curr = curr.getNext();  // 移动指针
        }
    }

    /**
     * 根据用户的输入，计算出 出圈的顺序
     *
     * @param k 从k开始
     * @param m 数m下
     */
    public void countJoseph(int k, int m) {
        if (first == null || k < 1) {
            System.out.println("参数不正确");
            return;
        }
        // 先准备好helper辅助指针指向first的前一个节点
        Boy helper = first;
        while (helper.getNext() != first) {
            helper = helper.getNext();
        }
        // 从k开始
        for (int i = 0; i < k - 1; i++) {
            helper = helper.getNext();
            first = first.getNext();
        }
        // 循环
        while (first != helper) {
            // 数m-1下
            for (int i = 0; i < m - 1; i++) {
                helper = helper.getNext();
                first = first.getNext();
            }
            System.out.println("出列的节点是：" + first.getNo());
            helper.setNext(first.getNext());
            first = first.getNext();
        }
        System.out.println("最后一个节点是：" + first.getNo());
    }
}

