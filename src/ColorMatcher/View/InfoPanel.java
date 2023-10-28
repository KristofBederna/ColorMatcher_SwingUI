package ColorMatcher.View;

import ColorMatcher.Util.ElapsedTimeAction;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InfoPanel extends JPanel {
    private JLabel timerLabel;
    private JLabel stepsCounterLabel;
    private Timer elapsedTimer;

    public InfoPanel() {
        setPreferredSize(new Dimension(100, 50));
        Font textFont = new Font("Garamond", Font.ITALIC, 16);
        JLabel elapsedTimerLabel = new JLabel("Elapsed time:");
        elapsedTimerLabel.setFont(textFont);
        timerLabel = new JLabel("");
        timerLabel.setFont(textFont);
        stepsCounterLabel = new JLabel("Steps:");
        stepsCounterLabel.setFont(textFont);

        add(elapsedTimerLabel);
        add(timerLabel);
        add(new JLabel("         "));
        add(stepsCounterLabel);
        newGame();
    }

    public void newGame() {
        if (elapsedTimer != null) {
            elapsedTimer.stop();
        }

        timerLabel.setText("0:0:0");
        stepsCounterLabel.setText("Steps: 0");
        elapsedTimer = new Timer(1000,new ElapsedTimeAction(timerLabel));
        elapsedTimer.start();
    }

    public void setSteps(int steps) {
        stepsCounterLabel.setText("Steps: " + steps);
    }
}
