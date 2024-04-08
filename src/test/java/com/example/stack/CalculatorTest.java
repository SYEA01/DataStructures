package com.example.stack;

public class CalculatorTest {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";  // 28-5+1-5+3-4 =18
        Stack numStack = new Stack(10);
        Stack operStack = new Stack(10);
        String numStr = "";

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (operStack.isOper(ch)) {  // 是符号
                if (operStack.isEmpty()) {  // 符号栈中没有符号
                    operStack.push(ch);
                } else {  // 符号栈中已经有符号了
                    // 需要比较栈中符号与当前符号谁的优先级高
                    if (operStack.order(operStack.peek()) >= operStack.order(ch)) {  // 栈中符号的优先级高
                        int num1 = numStack.pop();
                        int num2 = numStack.pop();
                        int oper = operStack.pop();
                        int res = numStack.calculation(num2, num1, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {  // 栈中符号的优先级低
                        operStack.push(ch);
                    }
                }
            } else {  // 是数字
                numStr += ch;
                if (i == expression.length() - 1) {  // 如果是最后一位，直接插入
                    numStack.push(Integer.parseInt(numStr));
                } else {
                    if (numStack.isOper(expression.charAt(i + 1))) {  // 如果下一位是符号的话
                        numStack.push(Integer.parseInt(numStr));
                        numStr = "";
                    }
                }
            }
        }

        while (!operStack.isEmpty()) {
            int num1 = numStack.pop();
            int num2 = numStack.pop();
            int oper = operStack.pop();
            int res = numStack.calculation(num2, num1, oper);
            numStack.push(res);
        }
        System.out.println("最终结果是：" + numStack.pop());
    }
}


class Stack {
    private int maxSize;
    private int[] array;
    private int top = -1;

    public Stack(int maxSize) {
        this.maxSize = maxSize;
        array = new int[this.maxSize];
    }

    // 栈空
    public boolean isEmpty() {
        return top == -1;
    }

    // 栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // 入栈
    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满了，无法入栈。。。。。。。。。");
            return;
        }
        array[++top] = value;
    }

    // 出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空的。。。。。。。。。。。");
        }
        int value = array[top];
        top--;
        return value;
    }

    // 遍历栈
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空的。。。。。。。。。。。");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("array[%d] = %d\n", i, array[i]);
        }
    }

    // 查看栈顶的元素（不弹出）
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("栈空的。。。。。。。。");
        }
        return array[top];
    }

    // 判断元素是符号还是数字
    public boolean isOper(int str) {
        return str == '*' || str == '/' || str == '+' || str == '-';
    }

    // 判断符号的优先级
    public int order(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            throw new RuntimeException("字符不合法！");
        }
    }

    // 计算
    public int calculation(int num1, int num2, int oper) {
        if (oper == '+') {
            return num1 + num2;
        } else if (oper == '-') {
            return num1 - num2;
        } else if (oper == '*') {
            return num1 * num2;
        } else if (oper == '/') {
            return num1 / num2;
        } else {
            throw new RuntimeException("参数有误！");
        }
    }


}
