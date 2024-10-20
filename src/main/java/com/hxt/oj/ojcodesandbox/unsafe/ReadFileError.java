package com.hxt.oj.ojcodesandbox.unsafe;

/**
 * ClassName: ReadFileError
 * Package: com.hxt.oj.ojcodesandbox.unsafe
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/17 19:38
 * @Version 1.0
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class ReadFileError {

    /**
     * 读取服务器文件（文件信息泄露）
     */
    public static void main(String[] args) throws InterruptedException, IOException {
        String userDir = System.getProperty("user.dir");
        String filePath = userDir + File.separator + "src/main/resources/application.yml";
        List<String> allLines = Files.readAllLines(Paths.get(filePath));
        System.out.println(String.join("\n", allLines));
    }
}

