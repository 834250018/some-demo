package cn.ve.design_pattern.j2ee_patterns.mvc;

/**
 * mvc模式
 * model模型(javaBean),这里是stringVO
 * View视图,这里用System.out.println(Controller.getView());在控制台输出作为视图
 * Controller控制器
 *
 * @author ve
 * @date 2020/5/4 12:03
 */
public class Client {
    public static void main(String[] args) {
        System.out.println(Controller.getView());
        ;
    }

    @Override public int hashCode() {
        return super.hashCode();
    }
}
