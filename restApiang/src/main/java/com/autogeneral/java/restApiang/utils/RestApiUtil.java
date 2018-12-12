package com.autogeneral.java.restApiang.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class RestApiUtil {


    public static boolean validateExpression(String expression) {
        Map<Character, Character> pairCombo = new HashMap<Character, Character>();
        pairCombo.put(')', '(');
        pairCombo.put('}', '{');
        pairCombo.put(']', '[');

        Stack<Character> stack = new Stack<Character>();
        for(char ch : expression.toCharArray()) {
            if(pairCombo.containsKey(ch)) {
                if(stack.isEmpty() || stack.pop() != pairCombo.get(ch)) {
                    return false;
                }
            } else if(pairCombo.values().contains(ch)) {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
