package com.ywy.demo.lambda_stream;

import java.util.function.DoubleBinaryOperator;

/**
 * 方法引用跟lambda比较谁更简洁就用谁
 *
 * @author ve
 * @date 2020/5/15
 */
public enum Operation {
    PLUS("+", Double::sum), // 方法引用
    MINUS("-", Other::sub), // 当lambda代码量多或者复杂的时候可以自定义方法引用
    TIMES("*", (x, y) -> x * y), // lambda
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}
