package ColorMatcher.View;

import ColorMatcher.Model.GameModel;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private GameModel gameModel;

    private InfoPanel infoPanel;

    private GamePanel gamePanel;

    public GameFrame(GameModel gameModel) {
        this.gameModel = gameModel;
        setTitle("Color Matcher");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(200, 200);

        this.gameModel.newGame(10);

        this.infoPanel = new InfoPanel();
        getContentPane().add(infoPanel, BorderLayout.NORTH);

        this.gamePanel = new GamePanel(this.gameModel, this.infoPanel);

        getContentPane().add(gamePanel);

        pack();
    }
}
