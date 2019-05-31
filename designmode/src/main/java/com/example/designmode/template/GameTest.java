package com.example.designmode.template;

public class GameTest {
    public static void main(String[] args){
        Game footBall = new FootBall();
        footBall.initGame();
        footBall.startGame();
        footBall.play();

        Game cricket = new Cricket();
        cricket.play();
        cricket.endGanme();
    }
}
