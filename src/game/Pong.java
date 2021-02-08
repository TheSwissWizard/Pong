package game;

import entity.Ball;
import entity.Player;
import utils.Commons;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pong implements ActionListener {

    private Timer timer;

    private GamePanel gamePanel;

    private static Player player1;
    private static Player player2;

    private static Ball ball;
    private static double currentBallSpeed = Commons.BALL_SPEED;
    public int rallyIteration = 0;

    public static boolean inGame = true;

    public Pong(){
        init();
    }

    private void init(){

        this.gamePanel = new GamePanel();
        new GameFrame(this.gamePanel);

        player1 = new Player(Commons.PLAYER_ONE);
        player2 = new Player(Commons.PLAYER_TWO);

        ball = new Ball();

        this.timer = new Timer(Commons.GAME_DELAY, this);
        this.timer.start();
    }

    private void update(){
        if (inGame){
            player1.move();
            player2.move();
            if (ball.move()){
                ball = new Ball();
                currentBallSpeed = Commons.BALL_SPEED;
            }else{
                increaseBallSpeed();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        update();
        this.gamePanel.repaint();
    }

    private void increaseBallSpeed(){
        
    }


    public static Player getPlayer1(){
        return player1;
    }

    public static  Player getPlayer2(){
        return player2;
    }

    public static Ball getBall(){
        return ball;
    }

    public static double getCurrentBallSpeed() {
        return currentBallSpeed;
    }
}
