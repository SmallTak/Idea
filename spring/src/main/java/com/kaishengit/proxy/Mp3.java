package com.kaishengit.proxy;

public class Mp3 implements Player {

    @Override
    public void play(String msicName) {
        System.out.println("播放音乐" + msicName);
    }

    @Override
    public int stop() {
        System.out.println("停止播放音乐");
        return 10/2;
    }
}
