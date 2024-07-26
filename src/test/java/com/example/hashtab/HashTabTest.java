package com.example.hashtab;

import lombok.Data;

import java.util.LinkedList;
import java.util.Scanner;

public class HashTabTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashTab2 hashTab = new HashTab2(7);
        while (true) {
            System.out.println("add：新增雇员");
            System.out.println("list：查询所有雇员");
            System.out.println("exit：退出");
            String print = scanner.next();
            switch (print) {
                case "add":
                    System.out.println("请输入id");
                    int id = scanner.nextInt();
                    System.out.println("请输入姓名");
                    String name = scanner.next();
                    Emp2 emp = new Emp2(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        }
    }
}

@Data
class HashTab2 {
    private LinkedList2[] arrays;
    private int size;

    public HashTab2(int size) {
        this.size = size;
        arrays = new LinkedList2[size];

        for (int i = 0; i < size; i++) {
            arrays[i] = new LinkedList2();
        }
    }

    public void add(Emp2 emp) {
        int no = fun(emp.getId());
        arrays[no].add(emp);
    }

    public void list() {
        for (int i = 0; i < arrays.length; i++) {
            arrays[i].list(i + 1);
        }
    }


    public int fun(int id) {
        return id % size;
    }
}

@Data
class Emp2 {
    private int id;
    private String name;

    private Emp2 next;

    public Emp2() {
    }

    public Emp2(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

@Data
class LinkedList2 {
    private Emp2 head;

    public void add(Emp2 emp) {
        if (head == null) {
            head = emp;
            return;
        }

        Emp2 current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(emp);
    }

    public void list(int i) {
        if (head == null) {
            System.out.println("第" + i + "条链表为空");
            return;
        }
        Emp2 current = head;
        System.out.println("第" + i + "条链表的数据有：");
        while (current != null) {
            System.out.printf("id = %d，name = %s \n", current.getId(), current.getName());
            current = current.getNext();
        }
    }
}
