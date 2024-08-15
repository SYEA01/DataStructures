package com.example.tree.threadedbinarytree;

/**
 * @author: Taoao
 * @create: 2024-08-12 16:44
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        // 测试 中序线索二叉树的功能是否正确
        HeroNode root = new HeroNode(1, "tom");
        HeroNode node2 = new HeroNode(3, "jack");
        HeroNode node3 = new HeroNode(6, "smith");
        HeroNode node4 = new HeroNode(8, "mary");
        HeroNode node5 = new HeroNode(10, "king");
        HeroNode node6 = new HeroNode(14, "dim");
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        // 测试线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);

//        threadedBinaryTree.threadedNodes();
//
//        // 测试
//        System.out.println("node5 的前驱节点 = " + node5.getLeft());
//        System.out.println("node5 的后继结点 = " + node5.getRight());
//
//        System.out.println("使用线索化方式来遍历线索化二叉树");
//        threadedBinaryTree.infixThreadedList();

/**/
        // 前序线索化
        threadedBinaryTree.preThreaded();
        // 前序遍历线索化二叉树
        threadedBinaryTree.preThreadedList();

    }
}

// ThreadedBinaryTree线索化二叉树
class ThreadedBinaryTree {
    private HeroNode root;

    // 为了实现线索化，需要创建一个指向当前节点的前驱节点的引用
    // 在递归进行线索化时，这个pre总是保留前一个节点
    private HeroNode pre = null;

    public void setRoot(HeroNode root) {
        this.root = root;
    }

    public void threadedNodes() {
        this.threadedNodes(root);
    }


    /**
     * 编写对二叉树进行 中序线索化的方法
     *
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(HeroNode node) {
        // 如果node=null。就不能线索化
        if (node == null) {
            return;
        }
        // 1、先线索化左子树
        threadedNodes(node.getLeft());

        // 2、线索化当前节点（难）
        // 先处理当前节点的前驱节点
        if (node.getLeft() == null) {
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针的类型 为前驱节点
            node.setLeftType(1);
        }
        // 处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱节点的右指针类型 为后继节点
            pre.setRightType(1);
        }

        // 每处理一个节点后，让当前节点是下一个节点的前驱节点
        pre = node;

        // 3、再线索化右子树
        threadedNodes(node.getRight());
    }

    /**
     * 遍历 中序线索化二叉树
     */
    public void infixThreadedList() {
        // 定义一个变量，存储当前遍历的节点
        HeroNode node = root;
        while (node != null) {
            // 循环找到leftType = 1 的节点
            // 后面随着遍历而变化，因为当leftType=1的时候，说明该节点是按照线索化处理后的有效节点
            while (node.getLeftType() == 0) {
                node = node.getLeft();
            }

            // 打印当前这个节点
            System.out.println(node);

            // 如果当前节点的右指针指向的是后继结点，就一直输出
            while (node.getRightType() == 1) {
                // 获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }

            // 替换这个遍历的节点
            node = node.getRight();
        }
    }

    /**
     * 前序线索化二叉树
     *
     * @param node
     */
    public void preThreaded(HeroNode node) {
        // 如果node=null。就不能线索化
        if (node == null) {
            return;
        }

        // 1、先处理当前节点
        // 处理当前节点的前驱节点
        if (node.getLeft() == null) {
            // 让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            // 修改当前节点的左指针的类型 为前驱节点
            node.setLeftType(1);
        }

        // 处理当前节点的后继节点
        if (pre != null && pre.getRight() == null) {
            // 让前驱节点的右指针指向当前节点
            pre.setRight(node);
            // 修改前驱节点的右指针类型 为后继节点
            pre.setRightType(1);
        }

        // 每处理一个节点后，让当前节点成为下一个节点的前驱节点
        pre = node;

        // 2、再递归线索化左子树
        if (node.getLeftType() == 0) {  // 当前节点的左指针指向子树的时候，才去线索化；如果指向了前驱节点，就代表已经线索化了，就不需要再去递归了
            preThreaded(node.getLeft());
        }
        // 3、最后递归线索化右子树
        if (node.getRightType() == 0) {  // 同上
            preThreaded(node.getRight());
        }
    }

    public void preThreaded() {
        this.preThreaded(root);
    }

    /**
     * 遍历 前序线索化二叉树
     */
    public void preThreadedList() {
        HeroNode node = root;
        // 首先输出node节点
        System.out.println("node = " + node);

        while (node != null) {
            while (node.getLeftType() == 0) {
                node = node.getLeft();
                System.out.println("node = " + node);
            }
            while (node.getRightType() == 1) {
                node = node.getRight();
                System.out.println("node = " + node);
            }
        }
    }
}


// 创建HeroNode
class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    // 定义两个新的属性  用于标识是否是子树或者节点
    // 1、如果leftType=0 表示左子树。如果leftType=1 表示前驱节点
    // 2、如果rightType=0 表示右子树。如果rightType=1 表示后继节点
    private int leftType;
    private int rightType;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
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

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", leftType=" + leftType +
                ", rightType=" + rightType +
                '}';
    }
}
