package views;

import javax.swing.*;
import java.awt.*;

public class ProgDialog extends JDialog {
    private boolean confirmed = false;
    private final JTextField ProgField = new JTextField("100");

    public ProgDialog(JFrame parent) {
        super(parent, "Ustaw próg jasności", true);
        setLayout(new BorderLayout());
        setSize(250, 120);
        setLocationRelativeTo(parent);

        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Próg jasności (0-255):"), BorderLayout.NORTH);
        panel.add(ProgField, BorderLayout.CENTER);

        JPanel buttons = new JPanel();
        JButton ok = new JButton("OK");
        JButton cancel = new JButton("Anuluj");

        ok.addActionListener(e -> {
            confirmed = true;
            dispose();
        });

        cancel.addActionListener(e -> dispose());

        buttons.add(ok);
        buttons.add(cancel);

        add(panel, BorderLayout.CENTER);
        add(buttons, BorderLayout.SOUTH);
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public int getProg() {
        try {
            return Integer.parseInt(ProgField.getText());
        } catch (NumberFormatException e) {
            return 100; // Domyślna wartość
        }
    }
}

