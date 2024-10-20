package com.hxt.oj.ojcodesandbox.unsafe;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: MemoryError
 * Package: com.hxt.oj.ojcodesandbox.unsafe
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/17 19:37
 * @Version 1.0
 */
public class MemoryError {

    /**
     * 无限占用空间（浪费系统内存）
     */

        public static void main(String[] args) throws InterruptedException {
            List<byte[]> bytes = new ArrayList<>();
            while (true) {
                bytes.add(new byte[10000]);
            }
        }

}
