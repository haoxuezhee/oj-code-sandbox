package com.hxt.oj.ojcodesandbox.security;

import cn.hutool.core.io.FileUtil;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * ClassName: TestSecurityManager
 * Package: com.hxt.oj.ojcodesandbox.security
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/17 21:01
 * @Version 1.0
 */
public class TestSecurityManager {

    public static void main(String[] args) {
        System.setSecurityManager(new MySecurityManager());
        List<String> strings = FileUtil.readLines("D:\\XunLeiDownLoad\\planetProject\\oj-code-sandbox\\src\\main\\resources\\application.yml",
                StandardCharsets.UTF_8);
        System.out.println(strings);
    }
}
