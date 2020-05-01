package cn.ve.designpattern.j2ee_patterns.TransferObjectPattern;

/**
 * @author ve
 * @date 2020/5/1 22:41
 */
public class Client {

    public static void main(String[] args) {
        String username = "uuuff"; // 初始化参数username
        UserCreateVO json = Web.addUser("uuuff"); // 模拟restful调用Web服务,返回一个json
        // 实际client返回的VO对象会被框架解析成json字符串返回
    }

}
