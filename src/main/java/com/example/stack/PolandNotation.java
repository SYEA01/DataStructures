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

        // 将一个中缀表达式转成后缀表达式
        // 说明
        // 1+((2+3)×4)-5   转成   1 2 3 + 4 × + 5 –
        String expression = "1+((2+3)*4)-5";
        // 将中缀表达式转成list
        List<String> list = toInfixExpressionList(expression);
        System.out.println(list);
        // 将中缀表达式转成后缀表达式
        List<String> resultList = parseSuffixExpressionList(list);
        System.out.println(resultList);



/*
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
*/
    }

    /**
     * 将中缀表达式转成后缀表达式
     *
     * @param list 中缀表达式list
     * @return 后缀表达式list
     */
    public static List<String> parseSuffixExpressionList(List<String> list) {
        // 1、定义一个栈，一个list
        Stack<String> s1 = new Stack<>();  // 存放符号 和 (  )的栈
        List<String> s2 = new ArrayList<>();  // 存放结果的list
        // 2、遍历中缀表达式list
        for (String item : list) {
            // 如果是数字，就入s2
            if (item.matches("\\d+")) {  // 如果是数字
                s2.add(item);
            } else if (item.equals("(")) {  // 如果是(
                s1.push(item);
            } else if (item.equals(")")) {  // 如果是)
                while (!s1.peek().equals("(")) {  // 只要不是(，就挨个弹出，加入到s2中
                    String pop = s1.pop();
                    s2.add(pop);
                }
                s1.pop();  // 弹出这个(
            } else {  // 如果是 + - * /
                // 当item的优先级 <= s1栈顶的运算符的优先级 【 要确保栈s1中符号的优先级是从低到高（相等的话，也是先运算） 】
                while (!s1.isEmpty() && (Operation.getValue(item) <= Operation.getValue(s1.peek()))) {
                    String pop = s1.pop();
                    s2.add(pop);
                }
                // 不论处理不处理栈中的符号，都在最后将当前item放入s1中
                s1.push(item);
            }
        }

        // 将s1中剩余的运算符放到s2中
        while (!s1.isEmpty()) {
            String pop = s1.pop();
            s2.add(pop);
        }

        return s2;
    }


    /**
     * 将中缀表达式转成list
     *
     * @param expression 中缀表达式
     * @return list
     */
    public static List<String> toInfixExpressionList(String expression) {
        List<String> list = new ArrayList<>();
        int index = 0;  // 这是一个指针，用于遍历中缀表达式字符串
        String str;  // 做对多位数的拼接
        char c;  // 每遍历到一个字符，就放入到集合中
        while (index < expression.length()) {
            // 如果c是一个非数字，就需要加入到list中
            c = expression.charAt(index);
            if (c < 48 || c > 57) {  // 如果不是数字
                list.add(String.valueOf(c));
                index++;
            } else {  // 如果是数字
                str = "";
                while (index < expression.length() && (c = expression.charAt(index)) >= 48 && c <= 57) {  // 只要不是末尾
                    str += c;
                    index++;
                }
                list.add(str);
            }
        }
        return list;
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


/**
 * 编写一个类Operation，可以返回一个运算符的优先级
 */
class Operation {
    private static int ADD = 1;  // +
    private static int SUB = 1;  // -
    private static int MUL = 2;  // *
    private static int DIV = 2;  // /

    // 编写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符");
                break;
        }
        return result;
    }

}