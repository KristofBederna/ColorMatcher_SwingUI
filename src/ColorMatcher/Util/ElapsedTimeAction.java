package ColorMatcher.Util;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.time.Duration;
import java.time.Instant;

public class ElapsedTimeAction extends AbstractAction {

    private JLabel timerLabel;
    private Instant startTimer;

    public ElapsedTimeAction(JLabel timerLabel) {
        this.timerLabel = timerLabel;
        startTimer = Instant.now();
    }

    private String formatDuration(Duration duration) {
        long seconds = duration.getSeconds();
        return String.format("%02d:%02d:%02d", seconds / 3600, (seconds % 3600)/60, seconds%60);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timerLabel.setText(formatDuration(Duration.between(startTimer, Instant.now())));
    }
}
