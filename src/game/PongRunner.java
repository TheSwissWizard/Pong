package game;

import game.Pong;

import java.awt.*;

public class PongRunner {

    public static void run(){
        EventQueue.invokeLater(Pong::new);
    }
}
