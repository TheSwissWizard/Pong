package game;

import utils.Commons;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    public GameFrame (GamePanel gamePanel){
        init(gamePanel);
    }

    private void init(GamePanel gamePanel){
        this.add(gamePanel);

        this.setTitle("Pong");
        this.setSize(new Dimension(Commons.WINDOW_WIDTH, Commons.WINDOW_HEIGHT));
        this.setUndecorated(true);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
