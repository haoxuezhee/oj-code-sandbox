package com.hxt.oj.ojcodesandbox.docker;

import com.github.dockerjava.api.DockerClient;
;
import com.github.dockerjava.api.command.*;

import com.github.dockerjava.api.model.Container;
import com.github.dockerjava.api.model.Frame;
import com.github.dockerjava.api.model.PullResponseItem;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.LogContainerResultCallback;

import java.util.List;

/**
 * ClassName: DockerDemo
 * Package: com.hxt.oj.ojcodesandbox.docker
 * Description:
 *
 * @Author hxt
 * @Create 2024/10/19 21:30
 * @Version 1.0
 */
public class DockerDemo {

    public static void main(String[] args) throws InterruptedException {
        DockerClient dockerClient = DockerClientBuilder.getInstance().build();

        //拉取镜像
        String image = "nginx:latest";
//        PullImageCmd pullImageCmd = dockerClient.pullImageCmd(image);
//        PullImageResultCallback pullImageResultCallback=new PullImageResultCallback(){
//            @Override
//            public void onNext(PullResponseItem item) {
//                System.out.println("下载镜像："+item.getStatus());
//                super.onNext(item);
//            }
//        };
//
//        pullImageCmd.exec(pullImageResultCallback).awaitCompletion();
//        System.out.println("下载完成");
        //创建容器
        CreateContainerCmd containerCmd = dockerClient.createContainerCmd(image);
        CreateContainerResponse containerResponse = containerCmd.withCmd("echo", "hello Docker")
                .exec();
        System.out.println(containerResponse);

        String containerId = containerResponse.getId();
        //查看容器状态
        ListContainersCmd listContainersCmd = dockerClient.listContainersCmd();
        List<Container> containerList = listContainersCmd.withShowAll(true).exec();
        for (Container container : containerList) {
            System.out.println(container);
        }
        //启动容器
        dockerClient.startContainerCmd(containerId).exec();

        // 查看日志
        LogContainerResultCallback logContainerResultCallback = new LogContainerResultCallback() {
            @Override
            public void onNext(Frame item) {
                System.out.println(item.getStreamType());
                System.out.println("日志：" + new String(item.getPayload()));
                super.onNext(item);
            }
        };

        // 阻塞等待日志输出
        dockerClient.logContainerCmd(containerId)
                .withStdErr(true)
                .withStdOut(true)
                .exec(logContainerResultCallback)
                .awaitCompletion();

        //删除容器
        dockerClient.removeContainerCmd(containerId).withForce(true).exec();

        //删除镜像
        dockerClient.removeImageCmd(image).exec();

    }




}
