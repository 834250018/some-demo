/**
 * @author ve
 * @date 2020/9/30
 * @description
 */
public class TestRemote {
    public static void main(String[] args)  {
        while (true) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(System.currentTimeMillis());
        }
    }
}
