package com.kaishengit.proxy;

public class Mp3AdProxy implements Player {

    //代理目标
    private Player player;

    public Mp3AdProxy(Player player){
        this.player=player;
    }

    @Override
    public void play(String msicName) {
        System.out.println("广告");
        player.play(msicName);
        System.out.println("广告结束");
    }

    @Override
    public int stop() {
        player.stop();
        return 10/2;
    }
}
