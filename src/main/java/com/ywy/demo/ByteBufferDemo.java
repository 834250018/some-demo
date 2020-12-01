package com.ywy.demo;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * TCP/IP协议规定了在网络上必须采用网络字节顺序，也就是大端模式
 * 对于char型数据只占一个字节，无所谓大端和小端。
 * 对于非char类型数据，必须在数据发送到网络上之前将其转换成大端模式。接收网络数据时按符合接受主机的环境接收
 *
 * @author 83425
 * @date 2020/11/30
 */
@Slf4j
public class ByteBufferDemo {
    public static void main(String[] args) throws IOException {
        // 大文件
        String readPath = "D:\\d.rar"; // 699mb
        String writePath = "D:\\d1.rar"; // 699mb
        int bufferLength = 10 * 1024 * 1024;
        // 设置-Xmx512m 出现OutOfMemoryError
//        byte[] bytes = ByteStreams.toByteArray(new FileInputStream(s));
        fileCopy(readPath, writePath, bufferLength);
    }

    private static void fileCopy(String readPath, String writePath, int bufferLength) throws IOException {
        RandomAccessFile raf = new RandomAccessFile(readPath, "rw");
        RandomAccessFile rafWrite = new RandomAccessFile(writePath, "rw");
        //源文件通道,由于我们的raf对象是随机访问文件，因此我们就通过它来进行读写操作。
        try (FileChannel readChannel = raf.getChannel(); FileChannel writeChannel = rafWrite.getChannel();) {
            long size = readChannel.size();
            MappedByteBuffer readMap = readChannel.map(FileChannel.MapMode.READ_WRITE, 0, size);
            MappedByteBuffer writeMap = writeChannel.map(FileChannel.MapMode.READ_WRITE, 0, size);

            byte[] buffer = new byte[bufferLength];
            for (int i = 0; i < size; i += buffer.length) {
                if (i > size - 1 - bufferLength) { // 处理最后一截
                    buffer = new byte[readMap.limit() - readMap.position()];
                }
                ByteBuffer byteBuffer = readMap.get(buffer);
                writeMap.put(buffer);
                System.out.println(byteBuffer);
            }
        }
    }

    public static void main1(String[] args) {
        // 查询硬件平台大小端
        System.out.println(ByteOrder.nativeOrder());

        ByteBuffer wrap = ByteBuffer.wrap(new byte[12]);
        wrap.asCharBuffer().put("abcdef");
        // ByteBuffer存储字节次序 默认大端模式
        System.out.println(Arrays.toString(wrap.array()));

        // 重置缓冲区
        wrap.rewind();
        // 设置字节存储次序 小端模式
        wrap.order(ByteOrder.LITTLE_ENDIAN);
        wrap.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(wrap.array()));

    }
}
