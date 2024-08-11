package com.example.tree;

import lombok.Data;

/**
 * @author: Taoao
 * @create: 2024-08-11 21:11
 */
public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        ArrayBinaryTree arrayBinaryTree = new ArrayBinaryTree(arr);
        arrayBinaryTree.preOrder();
        System.out.println();
        arrayBinaryTree.postOrder();  // 4 5 2 6 7 3 1
    }
}

// 编写一个ArrayBinaryTree 实现顺序存储二叉树的遍历
class ArrayBinaryTree {
    // 存储数据节点的数组
    private int[] arr;

    public ArrayBinaryTree(int[] arr) {
        this.arr = arr;
    }

    /**
     * 编写一个方法，完成顺序存储二叉树的前序遍历
     *
     * @param index 数组的下标
     */
    public void preOrder(int index) {
        // 如果数组为空，或者arr.length==0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        // 输出当前这个元素
        System.out.print(arr[index] + " ");
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            preOrder(index * 2 + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            preOrder(index * 2 + 2);
        }
    }

    public void preOrder() {
        this.preOrder(0);
    }

    /**
     * 后序
     *
     * @param index 数组的下标
     */
    public void postOrder(int index) {
        // 如果数组为空，或者arr.length==0
        if (arr == null || arr.length == 0) {
            System.out.println("数组为空，不能按照二叉树的前序遍历");
            return;
        }
        // 向左递归遍历
        if ((index * 2 + 1) < arr.length) {
            postOrder(index * 2 + 1);
        }
        // 向右递归遍历
        if ((index * 2 + 2) < arr.length) {
            postOrder(index * 2 + 2);
        }
        // 输出当前这个元素
        System.out.print(arr[index] + " ");
    }

    public void postOrder() {
        this.postOrder(0);
    }
}
