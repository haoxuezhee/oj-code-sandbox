package com.hxt.oj.ojcodesandbox.security;

import java.security.Permission;

/**
 * ClassName: DenySecurityManager
 * Package: com.hxt.oj.ojcodesandbox.security
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/17 20:56
 * @Version 1.0
 */
public class DenySecurityManager extends SecurityManager{

    @Override
    public void checkPermission(Permission perm) {
       throw new SecurityException("权限不足");
    }
}
