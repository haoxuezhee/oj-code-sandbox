package com.hxt.oj.ojcodesandbox;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/get")
    public String get(){
        return "ok";
    }
}
