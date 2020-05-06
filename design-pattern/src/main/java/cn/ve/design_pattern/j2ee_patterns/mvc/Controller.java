package cn.ve.design_pattern.j2ee_patterns.mvc;

/**
 * @author ve
 * @date 2020/5/4 12:01
 */
public class Controller {
    public static View getView() {
        View view = new View();
        view.setStudentVO(new StudentVO(String.valueOf(System.currentTimeMillis())));
        return view;
    }
}
