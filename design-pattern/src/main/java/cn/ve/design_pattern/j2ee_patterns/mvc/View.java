package cn.ve.design_pattern.j2ee_patterns.mvc;

/**
 * @author ve
 * @date 2020/5/4 12:02
 */
public class View {
    private StudentVO studentVO;

    public StudentVO getStudentVO() {
        return studentVO;
    }

    public void setStudentVO(StudentVO studentVO) {
        this.studentVO = studentVO;
    }

    @Override public String toString() {
        return studentVO.toString();
    }
}
