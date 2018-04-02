package com.kaishengit.proxy;

public class Mp3LogProxy implements Player {

    //代理目标
    private  Player player;

    public Mp3LogProxy(Player player){
        this.player = player;
    }

    @Override
    public void play(String msicName) {
        System.out.println("日志");
        player.play(msicName);
        System.out.println("日志结束");
    }

    @Override
    public int stop() {

        player.stop();
        return 11;
    }
}
