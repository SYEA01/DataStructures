package com.example.linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {

    }
}

/**
 * 创建一个双向链表的类
 */
class DoubleLinkedList {

    private HeroNode2 head = new HeroNode2(0, "", "");

    public HeroNode2 getHead() {
        return head;
    }

    // 遍历双向链表
    public void list() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }

    // 默认添加到链表尾
    public void add(HeroNode2 heroNode) {
        HeroNode2 temp = head.next;
        while (true) {
            // 如果到链表末尾，退出循环
            if (temp.next == null) {
                break;
            }
            temp = temp.next;
        }
        // 此时temp指向链表末尾
        temp.next = heroNode;
        heroNode.pre = temp;
    }

    // 修改
    public void update(HeroNode2 heroNode) {
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.name = heroNode.name;
            temp.nickName = heroNode.nickName;
        } else {
            System.out.printf("没找到编号为%d的节点，不能修改\n", heroNode.no);
        }
    }

    /**
     * 删除
     * 对于双向链表，可以直接找到要删除的节点进行自我删除
     *
     * @param no
     */
    public void delete(int no) {
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            // 这里有问题，要先判断temp是不是最后一个节点
            if (temp.next != null) {
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("没有找到编号为%d的节点，无法删除\n", no);
        }
    }


}

/**
 * 定义一个HeroNode，每个HeroNode对象就是一个节点
 */
class HeroNode2 {
    public int no;
    public String name;
    public String nickName;
    public HeroNode2 next;  // 这个指向下一个节点
    public HeroNode2 pre;  // 指向前一个节点

    public HeroNode2(int no, String name, String nickName) {
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