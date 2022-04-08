package com.mason.ATD.chapter05;

/**
 * 前缀表达式实现
 *
 * @author ShiYong
 * @create 2022-04-07 14:48
 **/
public class BalanceChecker {

    /**
     * Decides whether the parentheses, brackets, and braces in
     * a string occur in left/right pairs.
     * 前缀表达式的实现的方法
     * @param expression A string to be checked.
     * @return True if the delimiters are paired correctly.
     */
    public static boolean checkBalance(String expression) {
        StackInterface<Character> openDelimiterStack = new VectorStack<>();
        int characterCount = expression.length();
        boolean isBalanced = true;
        int index = 0;
        char nextCharacter = ' ';
        while (isBalanced && (index < characterCount)) {
            nextCharacter = expression.charAt(index);
            switch (nextCharacter) {
                case '(':
                case '[':
                case '{':
                    openDelimiterStack.push(nextCharacter);
                    break;
                case ')':
                case ']':
                case '}':
                    if (openDelimiterStack.isEmpty())
                        isBalanced = false;
                    else {
                        Character openDelimiter = openDelimiterStack.pop();
                        isBalanced = isPaired(openDelimiter, nextCharacter);

                    }
                    break;
                default:
                    break;

            }
            index++;
        }
        if (!openDelimiterStack.isEmpty())
            isBalanced = false;
        return isBalanced;


    }

    /**
     * Returns true if the given characters, open and close, form a pair
     * of parentheses, brackets, or braces.
     *
     * @param open
     * @param close
     * @return
     */
    private static boolean isPaired(char open, char close) {
        //是否是一对分隔符
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}');
    }
}
