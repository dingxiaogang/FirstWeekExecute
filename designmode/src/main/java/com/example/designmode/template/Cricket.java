package com.example.designmode.template;

public class Cricket extends Game{
    @Override
    void initGame() {
        System.out.println("台球游戏准备");
    }

    @Override
    void startGame() {
        System.out.println("台球游戏开始");
    }

    @Override
    void endGanme() {
        System.out.println("台球游戏结束");
    }
}
