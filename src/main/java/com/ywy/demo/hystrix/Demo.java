package com.ywy.demo.hystrix;

import java.util.concurrent.Future;

/**
 * @author ve
 * @date 2020/3/16 0:29
 */
public class Demo {
    public static void main(String[] args) {
        //        String s = new CommandHelloWorld("Bob").execute();
        Future<String> s = new CommandHelloWorld("Bob").queue();
        //        Observable<String> s = new CommandHelloWorld("Bob").observe();
        System.out.println();
    }
}
