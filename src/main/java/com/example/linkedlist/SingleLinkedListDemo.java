package com.example.linkedlist;

/**
 * 单链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        // 测试
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        // 创建一个链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero4);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.list();

    }
}

/**
 * 定义一个SingleLinkedList 代表单链表
 */
class SingleLinkedList {
    // 先初始化一个头节点，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 添加节点到单向链表
     * 思路：当不考虑编号的顺序时：找到当前链表的最后一个节点，将最后这个节点的next指向这个新节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        // 因为head不能动，因此需要一个辅助节点temp
        HeroNode temp = head;
        // 遍历链表，找到最后
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 如果没有找到，就将temp的指针后移
            temp = temp.next;
        }
        // 当退出这个while循环时，temp指向了链表的最后
        temp.next = heroNode;
    }

    /**
     * 显示链表---遍历
     */
    public void list() {
        // 先判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        // 因为头节点不能动，因此需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            // 判断是否到链表最后了
            if (temp == null) {
                break;
            }
            // 输出这个节点的信息
            System.out.println(temp);
            // 将temp的指针后移
            temp = temp.next;
        }
    }


}

/**
 * 定义一个HeroNode，每个HeroNode对象就是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;  // 这个指向下一个节点

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
