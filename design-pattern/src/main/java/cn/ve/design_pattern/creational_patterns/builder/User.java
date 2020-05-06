package cn.ve.design_pattern.creational_patterns.builder;

/**
 * @author ve
 * @date 2020/4/30 22:10
 */
public class User {
    private Integer age;
    private String name;

    public static User.UserBuilder builder() {
        return new User.UserBuilder();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public static class UserBuilder {
        private Integer age;
        private String name;

        public UserBuilder age(Integer age) {
            this.age = age;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        User build() {
            return new User(age, name);
        }
    }

}


