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
//        // 加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);
//        singleLinkedList.list();

        singleLinkedList.addByOrder(hero1);
        singleLinkedList.addByOrder(hero4);
        singleLinkedList.addByOrder(hero2);
        singleLinkedList.addByOrder(hero3);
        singleLinkedList.addByOrder(hero3);
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
     * 按照编号的顺序添加链表
     */
    public void addByOrder(HeroNode heroNode) {
        // 因为头节点不能动，所以使用辅助指针temp
        HeroNode temp = head;
        // 因为是单链表，因此temp找的位置是添加位置的前一个节点
        boolean flag = false;  // 标识添加的编号是否存在，默认为false
        // 遍历链表，查找应该插入的位置
        while (true) {
            if (temp.next == null) {  // 说明temp指针已经在链表的最后了
                break;
            }
            if (temp.next.no > heroNode.no) {// temp下一个节点的值 与 新插入节点的值进行比较 。如果找到了，就插入
                break;
            } else if (temp.next.no == heroNode.no) {  // 如果新插入节点的编号已经存在
                flag = true;  // 说明编号存在
                break;
            }
            temp = temp.next;
        }
        // 判断flag的值
        if (flag) {  // 编号已经存在，不能添加
            System.out.printf("准备插入的节点%d已经存在，不能添加\n", heroNode.no);
        } else {  // 插入到链表中
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

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
