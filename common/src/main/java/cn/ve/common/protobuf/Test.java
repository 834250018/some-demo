package cn.ve.common.protobuf;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * ProtoBuf基本使用,类似于序列化与反序列化
 *
 * @author ve
 * @date 2019/12/19 16:30
 */
@Slf4j public class Test {
    public static void main(String[] args) throws IOException {
        // 创建一个protoBuf-Java规范的Person
        PersonMsg.Person.Builder personBuilder =
            PersonMsg.Person.newBuilder().setId(1).setName("aa").setEmail("xx").addFriends("f").addFriends("q");
        PersonMsg.Person person = personBuilder.build();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        // 转成输出流
        person.writeTo(baos);
        // 接收端拿到byte[]
        byte[] bytes = baos.toByteArray();
        // byte[]转回protoBuf-Java规范的Person
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        PersonMsg.Person abc = PersonMsg.Person.parseFrom(inputStream);
        log.info("{}", abc); // 打印
    }
}
