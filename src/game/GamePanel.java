package game;

import entity.Player;
import utils.Commons;
import utils.KeyListener;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public GamePanel(){
        init();
    }

    private void init(){
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(Commons.WINDOW_WIDTH, Commons.WINDOW_HEIGHT - Commons.BOARD_TOP_SPACING));
        this.setBackground(Color.GRAY);
        this.addKeyListener(new KeyListener());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        draw(g);
    }

    private void draw(Graphics g){

        g.setColor(Color.white);
        g.drawString(String.valueOf(Pong.getPlayer1().getScore()), Commons.BOARD_SIDE_SPACING, Commons.FONT_TOP_SPACING);
        g.drawString(String.valueOf(Pong.getPlayer1().getScore()), Commons.WINDOW_WIDTH - Commons.BOARD_SIDE_SPACING, Commons.FONT_TOP_SPACING);

        g.setColor(Color.BLACK);
        g.fillRect(0,Commons.BOARD_TOP_SPACING, Commons.WINDOW_WIDTH, Commons.WINDOW_HEIGHT);;

        g.setColor(Color.GREEN);
        g.drawLine(0, Commons.BOARD_TOP_SPACING, Commons.WINDOW_WIDTH, Commons.BOARD_TOP_SPACING);

        g.setColor(Color.LIGHT_GRAY);
        g.drawLine(0,Commons.FIELD_HEIGHT/2 + Commons.BOARD_TOP_SPACING,
                Commons.WINDOW_WIDTH, Commons.FIELD_HEIGHT/2 + Commons.BOARD_TOP_SPACING);

        g.drawLine(Commons.WINDOW_WIDTH/2, Commons.BOARD_TOP_SPACING,
                Commons.WINDOW_WIDTH/2, Commons.WINDOW_HEIGHT);

        drawBall(g);
        drawPlayer(g);

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawBall(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(Pong.getBall().getX(), Pong.getBall().getY(), Commons.BALL_SIZE, Commons.BALL_SIZE);
    }

    private void drawPlayer(Graphics g){
        Player player1 = Pong.getPlayer1();
        Player player2 = Pong.getPlayer2();

        g.setColor(Color.WHITE);
        g.fillRect(player1.getX(),
                player1.getY(),
                Commons.PLAYER_WIDTH,
                Commons.PLAYER_HEIGHT);

        g.fillRect(player2.getX(),
                player2.getY(),
                Commons.PLAYER_WIDTH,
                Commons.PLAYER_HEIGHT);
    }
}
