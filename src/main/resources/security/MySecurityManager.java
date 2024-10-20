
import java.security.Permission;

/**
 * ClassName: MySecurityManager
 * Package: com.hxt.oj.ojcodesandbox.security
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/17 20:57
 * @Version 1.0
 */
public class MySecurityManager extends SecurityManager{

    // 允许所有权限
    @Override
    public void checkPermission(Permission perm) {
       // super.checkPermission(perm);
    }

    //检测程序是否可执行文件
    @Override
    public void checkExec(String cmd) {
        throw new SecurityException("checkExec 权限异常"+cmd);
    }

    //检测程序是否可读取文件
    @Override
    public void checkRead(String file) {
        throw new SecurityException("checkRead 权限异常"+file);
    }

    //检测程序是否可写入文件
    @Override
    public void checkWrite(String file) {
        throw new SecurityException("checkWrite 权限异常"+file);
    }

    //检测程序是否可删除文件
    @Override
    public void checkDelete(String file) {
        throw new SecurityException("checkDelete 权限异常"+file);
    }

    //检测程序是否可连接网络
    @Override
    public void checkConnect(String host, int port) {
       throw new SecurityException("checkConnect 权限异常"+host+":"+port);
    }
}
