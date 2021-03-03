package entity;

import game.Pong;
import utils.Commons;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {

    public enum BallState{
        WALL, PLAYER, GOAL
    }


    private Ellipse2D ellipse2D;

    private boolean xDirection;
    private boolean yDirection;

    public Ball(){
        int x = Commons.WINDOW_WIDTH/2 - (Commons.BALL_SIZE/2);
        int y = (Commons.BOARD_TOP_SPACING + Commons.FIELD_HEIGHT/2) - Commons.BALL_SIZE/2;

        this.ellipse2D = new Ellipse2D.Double(x,y, Commons.BALL_SIZE, Commons.BALL_SIZE);
        randomStartDirection();
    }

    private void randomStartDirection(){
        int r = (int) (Math.random() * 4) + 1;
        switch (r){
            case 1:
                this.xDirection = true;
                this.yDirection = true;
                break;
            case 2:
                this.xDirection = true;
                this.yDirection = false;
                break;
            case 3:
                this.xDirection = false;
                this.yDirection = false;
                break;
            case 4:
                this.xDirection = false;
                this.yDirection = true;
        }
    }

    public BallState move(){
        double x;
        if (xDirection){
            x = this.ellipse2D.getX() + Pong.getCurrentBallSpeed();
        }else {
            x = this.ellipse2D.getX() - Pong.getCurrentBallSpeed();
        }
        this.ellipse2D.setFrame(x,this.ellipse2D.getY(), Commons.BALL_SIZE, Commons.BALL_SIZE);

        double y;
        if (yDirection){
            y = this.ellipse2D.getY() + Pong.getCurrentBallSpeed();
        }else {
            y = this.ellipse2D.getY() - Pong.getCurrentBallSpeed();
        }
        this.ellipse2D.setFrame(this.ellipse2D.getX(), y, Commons.BALL_SIZE, Commons.BALL_SIZE);

        if (checkGoal()){
            return BallState.GOAL;
        }

        if (checkCollision()){
            return BallState.PLAYER;
        }else{
            return BallState.WALL;
        }
    }

    private boolean checkCollision(){
        if (this.ellipse2D.getY() <= Commons.BOARD_TOP_SPACING){
            adjustDirection(false);
            return false;
        }else if (this.ellipse2D.getY() + Commons.BALL_SIZE >= Commons.WINDOW_HEIGHT){
            adjustDirection(false);
            return false;
        }else if (this.ellipse2D.intersects(Pong.getPlayer1().getRectangle())
                || this.ellipse2D.intersects(Pong.getPlayer2().getRectangle())){
            adjustDirection(true);
            return true;
        }
        return false;
    }

    private void adjustDirection(boolean playerCollision){
            if (!playerCollision){
                if (this.xDirection && this.yDirection){
                    this.yDirection = false;
                }else if (!xDirection && this.yDirection){
                    this.yDirection = false;
                }else if (!this.xDirection && !this.yDirection){
                    this.yDirection = true;
                }else if (this.xDirection && !this.yDirection){
                    this.yDirection = true;
                }
            }else {
                if (this.xDirection && this.yDirection){
                    this.xDirection = false;
                }else if (!this.xDirection && this.yDirection){
                    this.xDirection =true;
                }else if (!this.xDirection && !this.yDirection){
                    this.xDirection = true;
                }else if(this.xDirection && !this.yDirection){
                    this.xDirection = false;
                }
            }
    }

    private boolean checkGoal(){
        if (this.ellipse2D.getX() <= Commons.BOARD_SIDE_SPACING){
            Pong.getPlayer2().addScore();
            return true;
        }else if (this.ellipse2D.getX() >= Commons.WINDOW_WIDTH - Commons.BOARD_SIDE_SPACING + Commons.BALL_SIZE){
            Pong.getPlayer1().addScore();
            return true;
        }
        return false;
    }

    public int getX() {
        return (int) Math.round(this.ellipse2D.getX());
    }

    public int getY() {
        return (int) Math.round(this.ellipse2D.getY());
    }
}
