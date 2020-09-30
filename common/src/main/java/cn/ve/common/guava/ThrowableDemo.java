package cn.ve.common.guava;

import com.google.common.base.Throwables;

import java.io.IOError;

/**
 * @author ve
 * @date 2020/3/2 21:02
 */
public class ThrowableDemo {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("abcef");
        } catch (RuntimeException e) {
            Throwables.throwIfInstanceOf(e, IOError.class);
            Throwables.throwIfInstanceOf(e, RuntimeException.class);
            throw new RuntimeException("fff");
        }
    }
}
