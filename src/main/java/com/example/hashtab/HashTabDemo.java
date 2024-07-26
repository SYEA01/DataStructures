package com.example.hashtab;

import java.util.Scanner;

public class HashTabDemo {
    public static void main(String[] args) {
        HashTab hashTab = new HashTab(7);
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add: 添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    int findId = scanner.nextInt();
                    Emp findEmp = hashTab.findEmpById(findId);
                    System.out.println("findEmp = " + findEmp);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

// 创建HashTab，用来管理多条链表
class HashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;

    public HashTab(int size) {
        this.size = size;
        // 初始化数组
        empLinkedListArray = new EmpLinkedList[size];

        for (int i = 0; i < size; i++) {
            empLinkedListArray[i] = new EmpLinkedList();
        }
    }

    // 添加雇员
    public void add(Emp emp) {
        // 首先根据员工的id得到该员工应该加入哪一条链表
        int empLinkedListNO = hashFun(emp.id);
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    // 遍历 所有的链表
    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedListArray[i].list(i + 1);
        }
    }

    // 根据输入的id查找雇员
    public Emp findEmpById(int id) {
        int i = hashFun(id);
        Emp emp = empLinkedListArray[i].findEmpById(id);
        if (emp != null) {
            System.out.println("在第" + (i + 1) + "条链表中找到了id为" + id + "的雇员");
            return emp;
        } else {
            System.out.println("没有找到id 为" + id + "的雇员");
            return null;
        }
    }

    // 编写散列函数,使用一个简单取模法
    public int hashFun(int id) {
        return id % size;
    }

}


class Emp {
    public int id;
    public String name;
    public Emp next;

    public Emp() {
    }

    public Emp(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

// 创建一个EmpLinkedList，表示链表
class EmpLinkedList {
    // 头指针，指向第一个Emp
    private Emp head;  // 默认是null

    // 添加雇员到链表 的末尾
    public void add(Emp emp) {
        // 如果是添加第一个雇员
        if (head == null) {
            head = emp;
            return;
        }
        // 如果不是添加第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = emp;
    }

    // 遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            System.out.println("第" + no + "条链表为空");
            return;
        }
        System.out.println("第" + no + "条链表的信息为：");
        Emp current = head;
        while (current != null) {
            System.out.printf("id = %d  name = %s \n", current.id, current.name);
            current = current.next;
        }
    }

    // 根据id查找雇员
    public Emp findEmpById(int id) {
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp current = head;
        while (current.id != id) {
            // 如果没找到，就向后找
            current = current.next;
            // 如果找到最后一个都没有找到，就退出循环
            if (current == null) {
                break;
            }
        }
        return current;
    }
}


