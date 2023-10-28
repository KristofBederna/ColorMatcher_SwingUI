package ColorMatcher.View;

import ColorMatcher.Model.GameModel;
import ColorMatcher.Util.GridButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JPanel {
    private GameModel gameModel;

    private InfoPanel infoPanel;

    public GamePanel(GameModel gameModel, InfoPanel infoPanel) {
        this.gameModel = gameModel;
        this.infoPanel = infoPanel;
        newGame();
    }

    public void newGame() {
        setUpGamePanel();
        refreshUI();
    }

    private void setUpGamePanel() {
        removeAll();
        int n = gameModel.getSize();
        setLayout(new GridLayout(n, n));

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                GridButton gridButton = new GridButton(i, j);
                gridButton.setPreferredSize(new Dimension(50,50));
                gridButton.addActionListener(new GridButtonListener());
                add(gridButton);
            }
        }
        revalidate();
        repaint();
    }

    private void refreshUI() {
        for (Component component: getComponents()) {
            GridButton gridButton = (GridButton) component;
            gameModel.getField(gridButton.getRow(), gridButton.getColumn());
            gridButton.setBackground(getColorByValue(gameModel.getField(gridButton.getRow(), gridButton.getColumn())));
        }
    }

    private Color getColorByValue(int value) {
        return switch (value) {
            case 0 -> Color.cyan;
            case 1 -> Color.orange;
            case 2 -> Color.green;
            default -> Color.white;
        };
    }


    private class GridButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            GridButton gridButton = (GridButton) e.getSource();
            int row = gridButton.getRow();
            int column = gridButton.getColumn();
            gameModel.changeFields(row, column);
            infoPanel.setSteps(gameModel.getStepsCounter());

            refreshUI();

            checkForGameEnd();
        }
    }

    private void checkForGameEnd() {
        if (gameModel.isGameOver()) {
            JOptionPane.showMessageDialog(null, "You won!", "Good job!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
