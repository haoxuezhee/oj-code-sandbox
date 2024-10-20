package com.hxt.oj.ojcodesandbox.unsafe;

/**
 * ClassName: SleepError
 * Package: com.hxt.oj.ojcodesandbox.unsafe
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/17 19:28
 * @Version 1.0
 */
public class SleepError {
    /**
     * 无限睡眠（阻塞程序执行）
     */
        public static void main(String[] args) throws InterruptedException {
            long ONE_HOUR = 60 * 60 * 1000L;
            Thread.sleep(ONE_HOUR);
            System.out.println("睡完了");
        }
}
