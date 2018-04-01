package com.kaishengit.proxy;

public class Mp3 implements Player {

    public void play(String msicName) {
        System.out.println("播放音乐" + msicName);
    }

    public void stop() {
        System.out.println("停止播放音乐");
    }
}
