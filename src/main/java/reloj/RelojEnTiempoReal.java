package reloj;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RelojEnTiempoReal extends JPanel {
    private static final DateTimeFormatter FORMATO_HORA = DateTimeFormatter.ofPattern("HH:mm:ss");
    private JLabel relojLabel;

    public RelojEnTiempoReal() {
        relojLabel = new JLabel();
        add(relojLabel);

        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LocalTime ahora = LocalTime.now();
                relojLabel.setText(ahora.format(FORMATO_HORA));
            }
        });
        timer.start();
    }
}


