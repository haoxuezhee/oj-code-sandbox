package com.hxt.oj.ojcodesandbox.security;

import java.security.Permission;
import java.sql.SQLOutput;

/**
 * ClassName: DefaultSecurityManager
 * Package: com.hxt.oj.ojcodesandbox.security
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/17 20:48
 * @Version 1.0
 */
public class DefaultSecurityManager extends SecurityManager{

    @Override
    public void checkPermission(Permission perm) {
        System.out.println("默认不做任何限制");
    }
}
