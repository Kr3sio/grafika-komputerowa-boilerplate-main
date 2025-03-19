package views;

import models.LineModel;
import models.RectangleModel;

import javax.swing.*;
import java.awt.*;

public class LineDialog extends JDialog {
    private final JTextField numberLine = new JTextField("10");
    private final JTextField spaceLine = new JTextField("60");
    private Color selectedColor = Color.BLACK;
    private boolean confirmed = false;

    public LineDialog(JFrame parent) {
        super(parent,"Podaj parametry",true);
        setSize(300,200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panel = getMainPanel();
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = getActionPanel();
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public JPanel getMainPanel() {
        JPanel panel = new JPanel(new GridLayout(3,2,10,10));
        panel.setBorder(BorderFactory.createEmptyBorder(15,15,15,15));

        panel.add(new JLabel("Ilość linii:"));
        panel.add(numberLine);
        panel.add(new JLabel("Odstęp"));
        panel.add(spaceLine);

        JButton colorButton = new JButton("Wybierz kolor");
        colorButton.setBackground(selectedColor);

        colorButton.addActionListener(e -> {
            Color newColor = JColorChooser.showDialog(this, "Wybierz kolor", selectedColor);
            if(newColor != null) {
                selectedColor = newColor;
                colorButton.setBackground(selectedColor);
            }
        });
        panel.add(new JLabel("Kolor:"));
        panel.add(colorButton);
        return panel;
    }

    private JPanel getActionPanel() {
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Anuluj");

        okButton.addActionListener(e -> {
            if(validateFields()){
                confirmed = true;
                dispose();
            }else{
                JOptionPane.showMessageDialog(this,"Niepoprawne dane!","Błąd",JOptionPane.ERROR_MESSAGE);
            }
        });
        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        return buttonPanel;
    }
    public LineModel getLine() {
        if(confirmed){
            return new LineModel(parseField(numberLine),
                    parseField(spaceLine),
                    selectedColor);
        }
        return null;
    }



    private Boolean validateFields() {
        return parseField(numberLine) != null &&
                parseField(spaceLine) != null;
    }

    private Integer parseField(JTextField field) {
        try {
            return Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
