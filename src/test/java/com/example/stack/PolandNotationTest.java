package com.example.stack;

import java.util.*;
import java.util.Stack;

public class PolandNotationTest {
    public static void main(String[] args) {
        String suffixExpression = "4 5 x 8 - 60 + 8 2 / +";   // 4*5-8+60+8/2 = 20-8+60+4 = 76
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        Stack<String> stack = new Stack<>();
        for (String str : list) {
            if (str.matches("\\d+")) {  // 如果是数字，入栈
                stack.push(str);
            } else {  // 如果是符号，弹出两个数字，与之计算
                Integer num1 = Integer.parseInt(stack.pop());
                Integer num2 = Integer.parseInt(stack.pop());
                int res = 0;
                if (str.equals("+")) {
                    res = num1 + num2;
                } else if (str.equals("-")) {
                    res = num2 - num1;
                } else if (str.equals("x")) {
                    res = num1 * num2;
                } else if (str.equals("/")) {
                    res = num2 / num1;
                }
                stack.push(String.valueOf(res));
            }
        }
        System.out.println("运算结果是：" + stack.pop());


    }
}
