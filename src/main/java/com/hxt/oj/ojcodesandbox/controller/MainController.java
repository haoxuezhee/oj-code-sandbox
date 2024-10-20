package com.hxt.oj.ojcodesandbox.controller;

import com.hxt.oj.ojcodesandbox.JavaDockerCodeSandBox;
import com.hxt.oj.ojcodesandbox.model.ExecuteCodeRequest;
import com.hxt.oj.ojcodesandbox.model.ExecuteCodeResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName: MainController
 * Package: com.hxt.oj.ojcodesandbox
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/16 14:13
 * @Version 1.0
 */
@RestController("/")
public class MainController {

    @Resource
    private JavaDockerCodeSandBox javaDockerCodeSandBox;

    @GetMapping("/get")
    public String get(){
        return "ok";
    }

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    @PostMapping("/executeCode")
    public  ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest){
        if(executeCodeRequest == null){
            throw new RuntimeException("请求参数为空");
        }
        ExecuteCodeResponse executeCodeResponse = javaDockerCodeSandBox.executeCode(executeCodeRequest);
        return executeCodeResponse;
    }
}
