package com.hxt.oj.ojcodesandbox;


import com.hxt.oj.ojcodesandbox.model.ExecuteCodeRequest;
import com.hxt.oj.ojcodesandbox.model.ExecuteCodeResponse;

/**
 * ClassName: CodeSandBox
 * Package: com.hxt.oj.judge.codesandbox
 * Description:
 *            代码沙箱接口定义
 * @Author hxt
 * @Create 2024/10/14 20:15
 * @Version 1.0
 */
public interface CodeSandBox {

    /**
     * 执行代码
     * @param executeCodeRequest
     * @return
     */
    ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest);
}
