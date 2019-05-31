package com.example.designmode.template;

public abstract class Game {
    abstract void initGame();

    abstract void startGame();

    abstract void endGanme();

    public final void play(){
        initGame();
        startGame();
        endGanme();
    }
}
