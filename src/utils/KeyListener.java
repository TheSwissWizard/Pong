package utils;

import com.sun.source.tree.IfTree;
import game.Pong;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);

        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                Pong.getPlayer1().setMovement(Commons.PLAYER_MOVE_UP);
                break;
            case KeyEvent.VK_S:
                Pong.getPlayer1().setMovement(Commons.PLAYER_MOVE_DOWN);
                break;
            case KeyEvent.VK_UP:
                Pong.getPlayer2().setMovement(Commons.PLAYER_MOVE_UP);
                break;
            case KeyEvent.VK_DOWN:
                Pong.getPlayer2().setMovement(Commons.PLAYER_MOVE_DOWN);
                break;
            case KeyEvent.VK_ESCAPE:
                Pong.inGame = !Pong.inGame;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);

        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W ||
            keyCode == KeyEvent.VK_S){
            Pong.getPlayer1().setMovement(Commons.PLAYER_MOVE_NO);
        }else if (keyCode == KeyEvent.VK_UP ||
                keyCode == KeyEvent.VK_DOWN){
            Pong.getPlayer2().setMovement(Commons.PLAYER_MOVE_NO);
        }
    }
}
