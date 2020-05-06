package com.ywy.demo.interview;

/**
 * 今天面试遇到这道题,挂了,故列出来研究一下
 * 通过反编译可以看出两个重点
 * 1.Person person2 = new Person("newPerson2");被放入构造函数,且前置于构造函数
 * 2.如果静态代码块有多个,被编译成一个并从上往下按顺序执行
 * <p>
 * 下面的文字可能总结得有点乱
 * 整体顺序是
 * 1.先执行入口类的静态代码块
 * 1.如果遇到new操作,先加载类(即执行静态代码块),然后如果有父类,执行父类的构造方法,再执行子类的构造方法
 * 2.后执行main函数
 *
 * @author ve
 * @date 2020/5/6
 */
public class StaticBlockTest extends Parent {
    Person person = new Person("因为执行了new操作,所以执行父类的构造函数(第一行是Person person = new Person(),加载Person),所以这一行打印在Person的static后面");

    public StaticBlockTest() {
        System.out.println("这行打印在newPerson2后面执行");
    }

    Person person2 = new Person("newPerson2");

    static {
        System.out.println("第一个先执行入口类的static块");
        new MyStaticBlockTest1().print();
    }

    public static void main(String[] args) {
        System.out.println("开始执行主函数,在第二个static后面");
        new MyStaticBlockTest().print();
    }

    static {
        System.out.println("这里是第二个static,在第一个static执行完了之后执行");
    }
}

class Person {
    static {
        System.out.println("Person的static");
    }

    public Person(String a) {
        System.out.println(a);
    }
}

class MyStaticBlockTest1 extends StaticBlockTest {
    static {
        System.out.println("因为入口static加载了MyStaticBlockTest1,所以第二行打印MyStaticBlockTest1的static");
    }

    public void print() {
        System.out.println("MyStaticBlockTest1#print()");
    }
}

class MyStaticBlockTest extends StaticBlockTest {
    static {
        System.out.println("这里加载MyStaticBlockTest类,加载完了后面跟着父类两个构造函数的打印,最后才打印final");
    }

    public void print() {
        System.out.println("final");
    }
}

class Parent {
    static {
        System.out.println("父类的静态代码块最先执行");
    }

}


/*public class com.ywy.demo.interview.StaticBlockTest {
        com.ywy.demo.interview.Person person;

 public com.ywy.demo.interview.StaticBlockTest();
    Code:
       0: aload_0
       1: invokespecial #1                  // Method java/lang/Object."<init>":()V
       4: aload_0
       5: new           #2                  // class com/ywy/demo/interview/Person
       8: dup
       9: ldc           #3                  // String newPerson
      11: invokespecial #4                  // Method com/ywy/demo/interview/Person."<init>":(Ljava/lang/String;)V
      14: putfield      #5                  // Field person:Lcom/ywy/demo/interview/Person;
      17: aload_0
      18: new           #2                  // class com/ywy/demo/interview/Person
      21: dup
      22: ldc           #6                  // String newPerson2
      24: invokespecial #4                  // Method com/ywy/demo/interview/Person."<init>":(Ljava/lang/String;)V
      27: putfield      #7                  // Field person2:Lcom/ywy/demo/interview/Person;
      30: getstatic     #8                  // Field java/lang/System.out:Ljava/io/PrintStream;
      33: ldc           #9                  // String aabb
      35: invokevirtual #10                 // Method java/io/PrintStream.println:(Ljava/lang/String;)V
      38: return
    LineNumberTable:
      line 13: 0
      line 11: 4
      line 16: 17
      line 14: 30
      line 15: 38
    LocalVariableTable:
      Start  Length  Slot  Name   Signature
          0      39     0  this   Lcom/ywy/demo/interview/StaticBlockTest;

public static void main(java.lang.String[]);
        Code:
        0: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: ldc           #9                  // String ccdd
        5: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        8: new           #10                 // class com/ywy/demo/interview/MyStaticBlockTest
        11: dup
        12: invokespecial #11                 // Method com/ywy/demo/interview/MyStaticBlockTest."<init>":()V
        15: invokevirtual #12                 // Method com/ywy/demo/interview/MyStaticBlockTest.print:()V
        18: return
        LineNumberTable:
        line 22: 0
        line 23: 8
        line 24: 18
        LocalVariableTable:
        Start  Length  Slot  Name   Signature
        0      19     0  args   [Ljava/lang/String;

static {};
        Code:
        0: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
        3: ldc           #13                 // String mainStatic
        5: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        8: new           #14                 // class com/ywy/demo/interview/MyStaticBlockTest1
        11: dup
        12: invokespecial #15                 // Method com/ywy/demo/interview/MyStaticBlockTest1."<init>":()V
        15: invokevirtual #16                 // Method com/ywy/demo/interview/MyStaticBlockTest1.print:()V
        18: getstatic     #6                  // Field java/lang/System.out:Ljava/io/PrintStream;
        21: ldc           #17                 // String 1.5
        23: invokevirtual #8                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
        26: return
        LineNumberTable:
        line 17: 0
        line 18: 8
        line 27: 18
        line 28: 26
        }*/
