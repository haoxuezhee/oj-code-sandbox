package com.hxt.oj.ojcodesandbox.utils;


import cn.hutool.core.util.StrUtil;
import com.hxt.oj.ojcodesandbox.model.ExecuteMessage;
import org.springframework.util.StopWatch;

import java.io.*;

/**
 * ClassName: ProcessUtil
 * Package: com.hxt.oj.ojcodesandbox.utils
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/16 20:25
 * @Version 1.0
 */
public class ProcessUtil {

    /**
     * 执行进程，获取执行结果
     * @param process
     * @param opName
     * @return
     */
    public static ExecuteMessage runProcessAndGetMessage(Process process,String opName){
        ExecuteMessage executeMessage = new ExecuteMessage();

        try {
            StopWatch stopWatch = new StopWatch();
            stopWatch.start();
            //等待程序执行获取错误码
            int exitValue = process.waitFor();
            executeMessage.setExitValue(exitValue);
            //正常退出
            if(exitValue == 0){
                System.out.println(opName +"成功");
                //分批获取进程的正常输出
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder compileMessageBuilder = new StringBuilder();
                //逐行读取
                String compileLine;
                while ((compileLine = bufferedReader.readLine())!= null){
                    compileMessageBuilder.append(compileLine).append("\n");
                }
                executeMessage.setMessage(compileMessageBuilder.toString());
            }else {
                System.out.println(opName+"失败: 错误码：" + exitValue);
                //分批获取进程的正常输出
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                StringBuilder compileMessageBuilder = new StringBuilder();
                //逐行读取
                String compileLine;
                while ((compileLine = bufferedReader.readLine())!= null){
                    compileMessageBuilder.append(compileLine).append("\n");
                }
                executeMessage.setMessage(compileMessageBuilder.toString());
                //分批获取进程异常的输出
                BufferedReader errorBufferedReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                StringBuilder errorCompileMessageBuilder = new StringBuilder();
                //逐行读取
                String errorCompileLine;
                while ((errorCompileLine = errorBufferedReader.readLine())!= null){
                    errorCompileMessageBuilder.append(errorCompileLine).append("\n");
                }
                executeMessage.setErrorMessage(errorCompileMessageBuilder.toString());
            }
            stopWatch.stop();
            executeMessage.setTime(stopWatch.getTotalTimeMillis());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return executeMessage;
    }

    /**
     * 执行交互式进程，获取执行结果
     * @param process
     * @param args
     * @return
     */
    public static ExecuteMessage runInteractProcessAndGetMessage(Process process,String args){
        ExecuteMessage executeMessage = new ExecuteMessage();

        try {
            // 向控制台输入程序
            OutputStream outputStream = process.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            String[] s = args.split(" ");
            String join = StrUtil.join("\n", s) + "\n";
            outputStreamWriter.write(join);
            // 相当于按了回车，执行输入的发送
            outputStreamWriter.flush();

            // 分批获取进程的正常输出
            InputStream inputStream = process.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder compileOutputStringBuilder = new StringBuilder();
            // 逐行读取
            String compileOutputLine;
            while ((compileOutputLine = bufferedReader.readLine()) != null) {
                compileOutputStringBuilder.append(compileOutputLine);
            }
            executeMessage.setMessage(compileOutputStringBuilder.toString());
            // 记得资源的释放，否则会卡死
            outputStreamWriter.close();
            outputStream.close();
            inputStream.close();
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return executeMessage;
    }
}
