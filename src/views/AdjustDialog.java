package views;



import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AdjustDialog extends JDialog {
    private final JTextField brightnessField = new JTextField("0");
    private final JTextField contrastField = new JTextField("1");
    private Boolean confirmed = false;



    public AdjustDialog(JFrame parent) {
        super(parent,"Podaj parametry",true);
        setSize(300,200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panel = getMainPanel();
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = getActionPanel();
        add(buttonPanel, BorderLayout.SOUTH);



    }
    private JPanel getMainPanel(){
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));



        panel.add(new JLabel("Jasność: "));
        panel.add(brightnessField);
        panel.add(new JLabel("Kontrast: "));
        panel.add(contrastField);

        return panel;
    }



    private JPanel getActionPanel() {
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Anuluj");

        // Obsługa przycisku OK. Sprawdzenie poprawności danych i zamknięcie okna. Jeśli dane są niepoprawne, wyświetlany jest komunikat z błędem.
        okButton.addActionListener(e -> {
            if(validateFields()) {
                confirmed = true;
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Nieprawidłowe dane!", "Błąd", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Obsługa przycisku Anuluj przez zamknięcie okna dialogowego.
        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        return buttonPanel;
    }
    public Double[] getIntArray() {
        if (confirmed) {
            Double[] parameter = new Double[2];
            parameter[0] = parseField(brightnessField);
            parameter[1] = parseField(contrastField);
            return parameter;
        }
        return null;
    }

    private Boolean validateFields() {
        return parseField(contrastField) != null
                ;

    }


    private Double parseField(JTextField field) {
        try {
            return Double.parseDouble(field.getText());
        } catch (NumberFormatException e) {
            return null;
        }
    }






}
