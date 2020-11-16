package cn.ve.design_pattern.j2ee_patterns.mvc;

/**
 * @author ve
 * @date 2020/5/4 12:02
 */
public class StudentVO {
    private String stuNo;

    public StudentVO(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    @Override public String toString() {
        return "StudentVO{" + "stuNo='" + stuNo + '\'' + '}';
    }
}
