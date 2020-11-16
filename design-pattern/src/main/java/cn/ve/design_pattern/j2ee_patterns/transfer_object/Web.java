package cn.ve.design_pattern.j2ee_patterns.transfer_object;

/**
 * 传输对象模式
 * 描述web应用pojo的设计,接口入参为DTO,渲染数据为VO
 * DTO与VO为可序列化,并仅有getter/setter方法的简单pojo类
 * 接下来用一个新增用户的例子演示,其中userList为数据库
 *
 * @author ve
 * @date 2019/9/26 9:46
 */
public class Web {

    public static UserCreateVO addUser(String username) {

        UserCreateDTO userCreateDTO = new UserCreateDTO(username); // 模拟springMVC框架把参数自动封装进DTO
        User user = new User();
        // 生成随机id
        user.setId(String.valueOf(System.currentTimeMillis()));
        user.setUsername(userCreateDTO.getUsername());
        // 存入数据库
        System.out.println("存入数据库: " + user);
        // 返回结果VO
        return new UserCreateVO(user.getId());
    }

}
