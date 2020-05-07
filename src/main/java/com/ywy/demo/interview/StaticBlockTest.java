package com.ywy.demo.interview;

/**
 * 今天面试遇到这道题,挂了,故列出来研究一下
 * 通过反编译可以看出两个重点
 * 1.编译后的构造函数,按顺序分别包含
 * (1)如果有父类,首先是父类的构造函数
 * (2)成员变量的赋值与构造代码块,谁写在上面编译后也在上面
 * (2)源码中的构造函数代码
 * 2.如果静态代码块有多个,被编译成一个并从上往下按顺序执行
 *
 * 执行顺序有以下几个规则
 * 1.静态代码块先于main函数执行
 * 2.new一个对象
 * (1)如果有父类且未加载过,首先加载父类
 * (2)如果子类未加载过,加载子类
 * (4)执行子类(编译后)的构造方法
 *
 * @author ve
 * @date 2020/5/6
 */
public class StaticBlockTest extends Parent {
    Person person = new Person("5");

    public StaticBlockTest() {
        System.out.println("7");
    }

    Person person2 = new Person("6");

    static {
        System.out.println("2");
        new MyStaticBlockTest1().print();
    }

    public static void main(String[] args) {
        System.out.println("10");
        MyStaticBlockTest myStaticBlockTest = new MyStaticBlockTest();
        myStaticBlockTest.print();
    }

    static {
        System.out.println("9");
    }
}

class Person {
    static {
        System.out.println("4");
    }

    public Person(String a) {
        System.out.println(a);
    }
}

class MyStaticBlockTest1 extends StaticBlockTest {
    static {
        System.out.println("3");
    }

    public void print() {
        System.out.println("8");
    }
}

class MyStaticBlockTest extends StaticBlockTest {
    static {
        System.out.println("11");
    }

    {
        System.out.println("12");
    }
//    private MyStaticBlockTest1 myStaticBlockTest1 = new MyStaticBlockTest1();

    public void print() {
        System.out.println("14");
    }

    {
        System.out.println("13");
    }
}

class Parent {
    static {
        System.out.println("1");
    }

}


/*
Compiled from "StaticBlockTest.java"
public class com.ywy.demo.interview.StaticBlockTest extends com.ywy.demo.interview.Parent {
  com.ywy.demo.interview.Person person;

  com.ywy.demo.interview.Person person2;

  public com.ywy.demo.interview.StaticBlockTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method com/ywy/demo/interview/Parent."<init>":()V
       4: aload_0
       5: new           #2                  // class com/ywy/demo/interview/Person
       8: dup
       9: ldc           #3                  // String 5
      11: invokespecial #4                  // Method com/ywy/demo/interview/Person."<init>":(Ljava/lang/String;)V
      14: putfield      #5                  // Field person:Lcom/ywy/demo/interview/Person;
      17: aload_0
      18: new           #2                  // class com/ywy/demo/interview/Person
      21: dup
      22: ldc           #6                  // String 6
      24: invokespecial #4                  // Method com/ywy/demo/interview/Person."<init>":(Ljava/lang/String;)V
      27: putfield      #7                  // Field person2:Lcom/ywy/demo/interview/Person;
      30: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
      33: ldc           #9                  // String 7
      35: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      38: return

  public static void main(java.lang.String[]);
    Code:
       0: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #11                 // String 10
       5: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: new           #12                 // class com/ywy/demo/interview/MyStaticBlockTest
      11: dup
      12: invokespecial #13                 // Method com/ywy/demo/interview/MyStaticBlockTest."<init>":()V
      15: astore_1
      16: aload_1
      17: invokevirtual #14                 // Method com/ywy/demo/interview/MyStaticBlockTest.print:()V
      20: return

  static {};
    Code:
       0: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
       3: ldc           #15                 // String 2
       5: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
       8: new           #16                 // class com/ywy/demo/interview/MyStaticBlockTest1
      11: dup
      12: invokespecial #17                 // Method com/ywy/demo/interview/MyStaticBlockTest1."<init>":()V
      15: invokevirtual #18                 // Method com/ywy/demo/interview/MyStaticBlockTest1.print:()V
      18: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
      21: ldc           #19                 // String 9
      23: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      26: return
}
*/
