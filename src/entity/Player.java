package entity;

import utils.Commons;

import java.awt.*;

public class Player {

    private Rectangle rectangle;

    private int score = 0;

    private int movement = Commons.PLAYER_MOVE_NO;

    public Player(int playerNumber){
        if (playerNumber == 1){
            int x = Commons.BOARD_SIDE_SPACING;
            int y = Commons.BOARD_TOP_SPACING + ((Commons.FIELD_HEIGHT / 2) - Commons.PLAYER_HEIGHT/2);

            this.rectangle = new Rectangle(x,y, Commons.PLAYER_WIDTH, Commons.PLAYER_HEIGHT);
        }else if (playerNumber == 2){
            int x = Commons.WINDOW_WIDTH - Commons.BOARD_SIDE_SPACING - Commons.PLAYER_WIDTH;
            int y = Commons.BOARD_TOP_SPACING + ((Commons.FIELD_HEIGHT / 2) - Commons.PLAYER_HEIGHT/2);

            this.rectangle = new Rectangle(x,y, Commons.PLAYER_WIDTH, Commons.PLAYER_HEIGHT);
        }
    }

    public void move(){
        if (this.movement == Commons.PLAYER_MOVE_UP){
            if (this.rectangle.y - Commons.PLAYER_SPEED > Commons.BOARD_TOP_SPACING){
                this.rectangle.y -= Commons.PLAYER_SPEED;
            }
        }else if (this.movement == Commons.PLAYER_MOVE_DOWN){
            if (this.rectangle.y + Commons.PLAYER_HEIGHT + Commons.PLAYER_SPEED < Commons.WINDOW_HEIGHT){
                this.rectangle.y += Commons.PLAYER_SPEED;
            }
        }
    }

    public int getX() {
        return this.rectangle.x;
    }

    public int getY() {
        return this.rectangle.y;
    }

    public int getScore() {

        return score;
    }

    public void addScore() {
        this.score++;
    }

    public Rectangle getRectangle(){
        return this.rectangle;
    }

    public void setMovement(int movement){
        this.movement = movement;
    }
}
