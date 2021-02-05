package entity;

import game.Pong;
import utils.Commons;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Ball {

    private Ellipse2D ellipse2D;

    private boolean xDirection = true;
    private boolean yDirection = true;

    public Ball(){
        int x = Commons.WINDOW_WIDTH/2 - (Commons.BALL_SIZE/2);
        int y = (Commons.BOARD_TOP_SPACING + Commons.FIELD_HEIGHT/2) - Commons.BALL_SIZE/2;

        this.ellipse2D = new Ellipse2D.Double(x,y, Commons.BALL_SIZE, Commons.BALL_SIZE);
    }

    public void move(){
        int x;
        if (xDirection){
            x = (int) Math.round(this.ellipse2D.getX()) + Commons.BALL_SPEED;
        }else {
            x = (int) Math.round(this.ellipse2D.getX()) - Commons.BALL_SPEED;
        }
        this.ellipse2D.setFrame(x,this.ellipse2D.getY(), Commons.BALL_SIZE, Commons.BALL_SIZE);

        int y;
        if (yDirection){
            y = (int) Math.round(this.ellipse2D.getY()) + Commons.BALL_SPEED;
        }else {
            y = (int) Math.round(this.ellipse2D.getY()) - Commons.BALL_SPEED;
        }
        this.ellipse2D.setFrame(this.ellipse2D.getX(), y, Commons.BALL_SIZE, Commons.BALL_SIZE);
        checkCollision();
    }

    private void checkCollision(){
        if (this.ellipse2D.getY() <= Commons.BOARD_TOP_SPACING){
            adjustDirection();
        }else if (this.ellipse2D.getY() + Commons.BALL_SIZE >= Commons.WINDOW_HEIGHT){
            adjustDirection();
        }

        if (this.ellipse2D.intersects(Pong.getPlayer1().getRectangle())
                || this.ellipse2D.intersects(Pong.getPlayer2().getRectangle())){
            adjustDirection();
        }
    }

    private void adjustDirection(){

    }

    public int getX() {
        return (int) Math.round(this.ellipse2D.getX());
    }

    public int getY() {
        return (int) Math.round(this.ellipse2D.getY());
    }
}
