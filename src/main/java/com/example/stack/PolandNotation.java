package com.example.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 */
public class PolandNotation {
    public static void main(String[] args) {
        // 定义一个逆波兰表达式 (3+4)x5-6  ===>  3 4 + 5 x 6 -
        // 定义一个逆波兰表达式 4x5-8+60+8/2  ===>  4 5 x 8 - 60 + 8 2 / +
        // 为了方便，逆波兰表达式的符号使用空格隔开
//        String suffixExpression = "3 4 + 5 x 6 - ";
        String suffixExpression = "4 5 x 8 - 60 + 8 2 / +";

        // 1、先将3 4 + 5 x 6 -  放到ArrayList中

        // 2、将ArrayList 传给一个方法，遍历ArrayList，配合栈完成计算
        List<String> list = getListString(suffixExpression);
        list.forEach(System.out::println);

        int res = calculate(list);
        System.out.println("运算结果 = " + res);


    }

    /**
     * 将逆波兰表达式的数据和运算符依次放到ArrayList中
     *
     * @param suffixExpression 逆波兰表达式
     * @return
     */
    public static List<String> getListString(String suffixExpression) {
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        return list;
    }

    /**
     * 完成对逆波兰表达式的运算
     */
    public static int calculate(List<String> list) {
        // 创建一个栈
        Stack<String> stack = new Stack<>();
        for (String str : list) {
            // 使用正则取出数字
            if (str.matches("\\d+")) {  // 匹配的多位数
                stack.push(str);
            } else {  // 如果是运算符
                // pop() 出两个数，并运算，再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (str.equals("+")) {
                    res = num1 + num2;
                } else if (str.equals("-")) {
                    res = num1 - num2;
                } else if (str.equals("x")) {
                    res = num1 * num2;
                } else if (str.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误！");
                }
                stack.push(String.valueOf(res));  // 把运算结果res入栈
            }
        }
        // 最后留在栈中的数据就是结果
        return Integer.parseInt(stack.pop());
    }
}
