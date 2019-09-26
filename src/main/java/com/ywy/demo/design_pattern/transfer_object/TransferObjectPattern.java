package com.ywy.demo.design_pattern.transfer_object;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 传输对象模式
 * 描述web应用pojo的设计,接口入参为DTO,渲染数据为VO
 * DTO与VO为可序列化,并仅有getter/setter方法的简单pojo类
 * 接下来用一个新增用户的例子演示,其中userList为数据库
 *
 * @author ve
 * @date 2019/9/26 9:46
 */
public class TransferObjectPattern {
    private static List<User> userList = Stream.of(
            new User("1", "user1"))
            .collect(Collectors.toList());


    public static void main(String[] args) {
        // 用户创建DTO
        UserCreateDTO userCreateDTO = new UserCreateDTO("uuuff");
        // 请求创建用户,返回结果VO
        UserCreateVO userCreateVO = addUser(userCreateDTO);
        // 在实际使用中,入参跟返回值应当是序列化成字符串进行传输
    }

    public static UserCreateVO addUser(UserCreateDTO userCreateDTO) {
        User user = new User();
        // 生成随机id
        user.setId(String.valueOf(System.currentTimeMillis()));
        user.setUsername(userCreateDTO.getUsername());
        // 存入数据库
        getUserList().add(user);
        // 返回结果VO
        return new UserCreateVO(user.getId());
    }


    public static List<User> getUserList() {
        return userList;
    }

    public static void setUserList(List<User> userList) {
        TransferObjectPattern.userList = userList;
    }
}
