package com.ywy.demo;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.joda.time.DateTime;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * ffmpeg截取流媒体并推送到七牛云
 * 前置条件,本地配置好ffmpeg环境变量,且申请了七牛云个人免费账号
 *
 * @author ve
 * @date 2020/11/11
 */
public class QiniuDemo {

    // 七牛云密钥
    private static final String ACCESS_KEY = "";
    private static final String SECRET_KEY = "";
    private static final String BUCKET_NAME = "";

    private static final Configuration cfg = new Configuration(Region.huanan());

    // 上传文件格式
    private static final String pattern = "yyyyMMdd_HHmmss";

    public static void main(String[] args) throws Exception {
        while (true) {
            test();
        }
    }

    private static void test() throws Exception {
        // 截取视频的存储路径
        String filePath = "ffmpeg/delete_" + DateTime.now().toString(pattern) + ".mp4";
        // 流媒体地址
        String url = "http://ivi.bupt.edu.cn/hls/cctv1hd.m3u8";
        // 覆盖模式 持续60秒 来源 输出目录
        String command = "ffmpeg -y -t 60 -i " + url + " " + filePath;
        // 执行命令
        ProcessBuilder builder = new ProcessBuilder();
        builder.command(command.split(" "));
        Process start = builder.start();

        // 一定要打印出来,不然会堵塞
        BufferedReader error = new BufferedReader(new InputStreamReader(start.getErrorStream()));
        String line;
        while ((line = error.readLine()) != null) {
            System.out.println(line);
        }
        error.close();

        // 等待命令执行完
        start.waitFor();
        // 上传至七牛云
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        String upToken = auth.uploadToken(BUCKET_NAME);
        upload(filePath, filePath.replace("ffmpeg/", ""), upToken);
    }

    private static void upload(String filePath, String fileName, String upToken) {
        UploadManager uploadManager = new UploadManager(cfg);
        try {
            Response response = uploadManager.put(filePath, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println("upload success");
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
    }
}
