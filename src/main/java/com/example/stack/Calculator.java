package com.example.stack;

/**
 * 利用栈实现计算器
 */
public class Calculator {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        // 创建两个栈，一个数字栈，一个符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        // 定义相关的变量
        int index = 0;  // 用于扫描字符串
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';  // 将每次扫描得到的char保存到ch中
        String keepNum = "";  // 用于拼接多位数
        // 循环扫描字符串
        while (index < expression.length()) {
            // 取出字符
            ch = expression.substring(index, index + 1).charAt(0);
            // 判断ch是什么
            if (operStack.isOper(ch)) {  // 如果是运算符
                // 判断当前符号栈是否为空
                if (!operStack.isEmpty()) {  // 如果当前符号栈不为空
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {  // 如果栈里面符号的优先级高
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);  // 把运算结果入数栈
                        operStack.push(ch);  // 把当前遍历到的符号入符号栈
                    } else {  // 如果栈里面符号的优先级低
                        operStack.push(ch);
                    }
                } else {  // 如果当前符号栈为空
                    operStack.push(ch);
                }
            } else {  // 如果是数字
                keepNum += ch;
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    // 判断下一位是不是符号
                    if (operStack.isOper(expression.substring(index + 1, index + 2).charAt(0))) {
                        // 如果下一位是符号
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
            // index索引+1
            index++;
        }

        // 当表达式扫描完毕，就顺序的从数栈中取出两个、符号栈中取出一个进行运算，并将运算结果重新入数字栈。
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        int result = numStack.pop();
        System.out.println("运算结果 = " + result);
    }
}

/**
 * 先创建一个栈，直接使用数组实现的栈
 */
class ArrayStack2 {
    private int maxSize;  // 栈的大小
    private int[] stack;  // 数组模拟栈，数据就放在该数组中
    private int top = -1;  // top 表示栈顶，初始化-1

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满。");
            return;
        }
        top++;
        stack[top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空。");
        }
        int value = stack[top];
        top--;
        return value;
    }

    // 遍历栈，遍历时需要从栈顶开始显示数据
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空。");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d] = %d\n", i, stack[i]);
        }
    }

    /**
     * 返回运算符的优先级
     * 假定  乘除的优先级是1
     * 加减的优先级是0
     * 其他不合法
     *
     * @param oper 符号
     * @return 符号的优先级
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是不是一个运算符
     *
     * @param val 字符
     * @return 当前符号是不是运算符
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算
     *
     * @param num1
     * @param num2
     * @param oper
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;  // 用于存放运算结果
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }

    /**
     * 查看栈顶的符号（不取出）
     */
    public int peek() {
        return stack[top];
    }

}
