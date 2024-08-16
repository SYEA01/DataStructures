package com.example.tree;

import lombok.Data;

/**
 * 线索化二叉树以及遍历
 *
 * @author: Taoao
 * @create: 2024-08-16 10:30
 */
public class ThreadedBinaryTreeTest {
    public static void main(String[] args) {
        Node root = new Node(4);
        Node node2 = new Node(3);
        Node node3 = new Node(6);
        Node node4 = new Node(1);
        Node node5 = new Node(5);
        Node node6 = new Node(8);
        Node node7 = new Node(0);
        Node node8 = new Node(2);
        Node node9 = new Node(7);
        Node node10 = new Node(9);
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node4.setLeft(node7);
        node4.setRight(node8);
        node3.setLeft(node5);
        node3.setRight(node6);
        node6.setLeft(node9);
        node6.setRight(node10);

        ThreadedTree threadedTree = new ThreadedTree(root);
        // 前序线索化
        threadedTree.preThreaded();
        // 遍历前序线索化
        threadedTree.preThreadedNodeList();
    }
}

@Data
class ThreadedTree {
    // 根节点
    private Node root;

    // 当前节点的前一个节点
    private Node pre = null;

    public ThreadedTree(Node root) {
        this.root = root;
    }

    public void preThreaded() {
        this.preThreaded(root);
    }

    /**
     * 前序线索化二叉树
     *
     * @param node
     */
    public void preThreaded(Node node) {
        if (node == null) {
            return;
        }

        // 先线索化当前节点
        if (node.getLeft() == null) {
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if (pre != null && pre.getRight() == null) {
            pre.setRight(node);
            pre.setRightType(1);
        }
        pre = node;

        // 线索化左子节点
        if (node.getLeftType() == 0) {
            preThreaded(node.getLeft());
        }
        // 线索化右子节点
        if (node.getRightType() == 0) {
            preThreaded(node.getRight());
        }
    }

    /**
     * 遍历前序线索化二叉树
     */
    public void preThreadedNodeList() {
        Node node = root;

        System.out.println(node);

        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
                System.out.println(node);
            }
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println(node);
            }
        }
    }
}

/**
 * 节点
 */
class Node {
    private int no;
    private Node left;
    private Node right;

    private int leftType;
    private int rightType;

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public Node(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", left=" + left +
                ", right=" + right +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }
}
