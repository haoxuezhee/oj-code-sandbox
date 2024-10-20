package com.hxt.oj.ojcodesandbox.model;

import cn.hutool.core.date.StopWatch;
import lombok.Data;

import java.util.List;

/**
 * ClassName: ExecuteMessage
 * Package: com.hxt.oj.ojcodesandbox.model
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/16 20:25
 * @Version 1.0
 */
@Data
public class ExecuteMessage {

    private Integer exitValue;

    private String message;

    private String errorMessage;

    private Long time;

    private Long memory;

}
