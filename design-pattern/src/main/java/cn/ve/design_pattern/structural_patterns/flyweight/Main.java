package cn.ve.design_pattern.structural_patterns.flyweight;


import java.util.ArrayList;
import java.util.List;

/**
 * 享元模式
 * 创建一小部分对象进行复用,减少创建,销毁的性能消耗(常驻内存换时间)
 * 具体的场景有各种线程池
 *
 * @author 83425
 * @date 2020/12/15
 */
public class Main {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println("123");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("123");
        };
        Runnable runnable1 = () -> {
            System.out.println("321");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("321");
        };
        Runnable runnable2 = () -> {
            System.out.println("444");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("444");
        };
        Runnable runnable3 = () -> {
            System.out.println("6634");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("6633");
        };
        Runnable runnable4 = () -> {
            System.out.println("53");
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("53");
        };
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("客户端1"));
        clients.add(new Client("客户端2"));

        run(runnable4, clients);
        run(runnable, clients);
        run(runnable2, clients);
        run(runnable3, clients);
        run(runnable1, clients);

    }

    private static void run(Runnable runnable4, List<Client> clients) {
        for (Client client : clients) {
            if (!client.isLock()) {
                client.start(runnable4);
            }
        }
    }
}
