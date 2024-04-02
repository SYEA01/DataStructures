package com.example.linkedlist;

import java.util.Stack;

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

        // 逆序打印链表
        System.out.println("逆序打印链表");
        reversePrintList(singleLinkedList.getHead());
        System.out.println("链表结构");
        singleLinkedList.list();


//        // 测试单链表的反转
//        System.out.println("反转后的链表。。");
//        reverseList2(singleLinkedList.getHead());
//        singleLinkedList.list();


//        singleLinkedList.addByOrder(hero1);
//        singleLinkedList.addByOrder(hero4);
//        singleLinkedList.addByOrder(hero2);
//        singleLinkedList.addByOrder(hero3);
//        singleLinkedList.list();

/*        System.out.println("=======================修改后===========================");
        // 测试修改节点的代码
        HeroNode newHeroNode = new HeroNode(2, "小卢", "玉麒麟~~");
        singleLinkedList.update(newHeroNode);
        singleLinkedList.list();


        System.out.println("=====================删除一个节点1====================");
        singleLinkedList.delete(1);
        singleLinkedList.list();

        System.out.println("=====================删除一个节点4====================");
        singleLinkedList.delete(4);
        singleLinkedList.list();

        System.out.println("链表中节点的个数：" + getLength(singleLinkedList.getHead()));

        System.out.printf("=========================测试是否得到了倒数第%d个节点==============================\n", 3);
        // 测试是否得到了倒数第k个节点
        HeroNode res = findLastKNode(singleLinkedList.getHead(), 3);
        System.out.println("res = " + res);*/

    }

    /**
     * 获取到单链表的节点的个数（如果链表带头节点，不统计头节点）
     *
     * @param head 链表的头节点
     * @return 有效节点的个数
     */
    public static int getLength(HeroNode head) {
        if (head.next == null) {  // 空链表
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;  // 这里没有统计头节点
        while (cur != null) {
            length++;
            cur = cur.next;
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第k个结点
     *
     * @param head 头节点
     * @param k    k
     * @return 单链表中的倒数第k个结点
     */
    public static HeroNode findLastKNode(HeroNode head, int k) {
        if (head.next == null) {
            return null;
        }
        int len = getLength(head);
        if (len < k) {
            return null;
        }
        HeroNode temp = head.next;  // temp指向第一个节点
        for (int i = 0; i < len - k; i++) {
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static HeroNode reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return head;
        }
        HeroNode cur = head.next;  // 定义一个辅助指针，用于遍历链表
        HeroNode reverseNode = new HeroNode(0, "", "");
        while (cur != null) {
            HeroNode next = cur.next;  // 记录下一个
            cur.next = reverseNode.next;
            reverseNode.next = cur;
            cur = next;  // 移动指针

        }
        head.next = reverseNode.next;
        return head;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public static HeroNode reverseList2(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return head;
        }
        HeroNode cur = head.next;
        HeroNode pre = null;
        while (cur != null) {
            HeroNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        head.next = pre;
        return pre;
    }

    /**
     * 逆序打印链表
     *
     * @param head
     */
    public static void reversePrintList(HeroNode head) {
        HeroNode temp = head.next;
        if (temp == null || temp.next == null) {
            System.out.println(temp);
        }
        Stack<HeroNode> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}

/**
 * 定义一个SingleLinkedList 代表单链表
 */
class SingleLinkedList {
    // 先初始化一个头节点，不存放具体的数据
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

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
     * 修改节点的信息，根据编号no来修改name
     */
    public void update(HeroNode newHeroNode) {
        // 判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空。");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;  // 标识是否找到该节点
        while (true) {
            if (temp == null) {
                break;  // 链表已经遍历结束,仍没有找到需要修改的节点
            }
            if (temp.no == newHeroNode.no) {  // 说明已经找到需要修改的节点了
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {  // 已经找到需要修改的节点了
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {  // 没有找到需要修改的节点
            System.out.printf("没有找到编号%d 的节点，不能修改\n", newHeroNode.no);
        }
    }

    /**
     * 删除节点
     * 1、head不能动，因此需要一个辅助节点temp
     * 2、比较temp.next.no 与 待删除节点的no进行比较
     */
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;  // 标识 是否找到待删除节点
        while (true) {
            if (temp.next == null) {
                break;  // 已经到链表的最后
            }
            if (temp.next.no == no) {  // 已经找到了待删除节点的前一个节点temp
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {  // 已经找到了待删除节点的前一个节点temp
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的 %d 节点不存在\n", no);
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
