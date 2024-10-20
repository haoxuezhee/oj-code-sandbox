package com.hxt.oj.ojcodesandbox.unsafe;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * ClassName: WriteFileError
 * Package: com.hxt.oj.ojcodesandbox.unsafe
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/17 19:39
 * @Version 1.0
 */
public class WriteError {

    /**
     * 向服务器写文件（植入危险程序）
     */
        public static void main(String[] args) throws InterruptedException, IOException {
            String userDir = System.getProperty("user.dir");
            String filePath = userDir + File.separator + "src/main/resources/木马程序.bat";
            String errorProgram = "java -version 2>&1";
            Files.write(Paths.get(filePath), Arrays.asList(errorProgram));
            System.out.println("写木马成功，你完了哈哈");
        }
}
