package cn.ve.design_pattern.structural_patterns.flyweight;


/**
 * @author 83425
 * @date 2020/12/15
 */
public class Client {
    private String name;
    private volatile boolean lock;

    public void start(Runnable runnable) {
        lock = true;
        System.out.println(name + "在执行任务");
        // 这是模拟client对象不被销毁,所以这里不需要管Thread
        Thread thread = new Thread(runnable);
        thread.start();
        while (thread.isAlive()) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        lock = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isLock() {
        return lock;
    }

    public void setLock(boolean lock) {
        this.lock = lock;
    }

    public Client(String name) {
        this.name = name;
    }
}
