package cn.ve.design_pattern.creational_patterns.builder.demo2;

/**
 * @author ve
 * @date 2020/5/7
 */
public class User {
    private Integer age;
    private String name;
    private String remark;
    private String hometown;
    private String address;

    private User(User.UserBuilder builder) {
        this.age = builder.age;
        this.name = builder.name;
        this.remark = builder.remark;
        this.hometown = builder.hometown;
        this.address = builder.address;
    }

    public static class UserBuilder {
        private final Integer age;
        private final String name;
        private String remark;
        private String hometown;
        private String address;

        public UserBuilder(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public UserBuilder remark(String remark) {
            this.remark = remark;
            return this;
        }

        public UserBuilder hometown(String hometown) {
            this.hometown = hometown;
            return this;
        }

        public UserBuilder address(String address) {
            this.address = address;
            return this;
        }

        User build() {
            return new User(this);
        }
    }
}
