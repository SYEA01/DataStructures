package com.example.tree;

import lombok.Data;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        // 创建需要的节点
        HeroNode root = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "无用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");
        HeroNode node5 = new HeroNode(5, "关胜");

        // 这里先手动创建二叉树，后面会以递归的方式创建二叉树
        root.setLeft(node2);
        root.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        binaryTree.setRoot(root);

        // 12354   21534     25431
        binaryTree.postOrder();

        HeroNode resNode = binaryTree.postOrderSearch(5);
        if (resNode != null) {
            System.out.printf("找到信息为no = %d, name = %s", resNode.getNo(), resNode.getName());
        } else {
            System.out.printf("没有找到no为%d 的英雄", 5);
        }

    }
}

// 定义一个BinaryTree 二叉树
@Data
class BinaryTree {
    private HeroNode root;

    // 前序遍历
    public void preOrder() {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 中序遍历
    public void infixOrder() {
        if (root != null) {
            root.infixOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 后序遍历
    public void postOrder() {
        if (root != null) {
            root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    // 前序查找
    public HeroNode preOrderSearch(int target) {
        if (root != null) {
            return root.preOrderSearch(target);
        }
        return null;
    }

    // 中序查找
    public HeroNode infixOrderSearch(int target) {
        if (root != null) {
            return root.infixOrderSearch(target);
        }
        return null;
    }

    // 后序查找
    public HeroNode postOrderSearch(int target) {
        if (root != null) {
            return root.postOrderSearch(target);
        }
        return null;
    }


}

// 先创建HeroNode节点
@Data
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;  // 默认null
    private HeroNode right;  // 默认null

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroNode [ no = " + no + ",name = " + name + "]";
    }

    // 编写前序遍历的方法
    public void preOrder() {
        // 先输出父节点
        System.out.println(this);
        // 递归 向左子树前序遍历
        if (this.left != null) {
            this.left.preOrder();
        }
        // 递归 向右子树前序遍历
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    // 编写中序遍历的方法
    public void infixOrder() {
        // 递归，向左子树中序遍历
        if (this.left != null) {
            this.left.infixOrder();
        }
        // 输出当前节点
        System.out.println(this);
        // 递归 向右子树中序遍历
        if (this.right != null) {
            this.right.infixOrder();
        }
    }

    // 编写后序遍历的方法
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }

    // 前序查找
    public HeroNode preOrderSearch(int target) {
        System.out.println("进行前序遍历查找");
        if (this.getNo() == target) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {  // 向左递归
            resNode = this.left.preOrderSearch(target);
        }
        if (resNode != null) {  // 说明左子树找到了
            return resNode;
        }

        if (this.right != null) {  // 向右递归
            resNode = this.right.preOrderSearch(target);
        }

        return resNode;
    }

    // 中序查找
    public HeroNode infixOrderSearch(int target) {
        HeroNode resNode = null;
        if (this.left != null) {  // 向左递归
            resNode = this.left.infixOrderSearch(target);
        }
        if (resNode != null) {  // 左递归找到了
            return resNode;
        }
        System.out.println("进行中序遍历查找");
        if (this.getNo() == target) {  // 根节点
            return this;
        }
        if (this.right != null) {  // 向右递归
            resNode = this.right.infixOrderSearch(target);
        }
        return resNode;
    }

    // 后序查找
    public HeroNode postOrderSearch(int target) {
        HeroNode resNode = null;
        if (this.left != null) {  // 向左递归
            resNode = this.left.postOrderSearch(target);
        }
        if (resNode != null) {  // 左递归找到了
            return resNode;
        }
        if (this.right != null) {  // 向右递归
            resNode = this.right.postOrderSearch(target);
        }
        if (resNode != null) {  // 右递归找到了
            return resNode;
        }
        System.out.println("进行后序遍历查找");
        if (this.getNo() == target) {  // 比较根节点
            return this;
        }
        return null;  // 都没有找到，返回null
    }
}
