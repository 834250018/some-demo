package com.ywy.demo.design_pattern.transfer_object;

/**
 * @author ve
 * @date 2019/9/26 9:50
 */
public class UserCreateVO {
    private String username;

    public UserCreateVO(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
