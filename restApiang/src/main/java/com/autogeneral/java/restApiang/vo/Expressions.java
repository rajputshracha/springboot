package com.autogeneral.java.restApiang.vo;

public class Expressions {

    private String expression;
    private String isBalanced;

    public Expressions() {
    }

    public Expressions(String expression, String isBalanced) {
        this.expression = expression;
        this.isBalanced = isBalanced;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getIsBalanced() {
        return isBalanced;
    }

    public void setIsBalanced(String isBalanced) {
        this.isBalanced = isBalanced;
    }
}
