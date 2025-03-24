package views;



import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class AdjustDialog extends JDialog {
    private JSlider brightnessSlider;;
    private JSlider contrastSlider;
    private Boolean confirmed = false;



    public AdjustDialog(JFrame parent) {
        super(parent,"Podaj parametry",true);
        setSize(300,300);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        JPanel panel = getMainPanel();
        add(panel, BorderLayout.CENTER);

        JPanel buttonPanel = getActionPanel();
        add(buttonPanel, BorderLayout.SOUTH);



    }
    private JPanel getMainPanel(){
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));



        panel.add(new JLabel("Jasność: "));
        brightnessSlider = createSlider(-255,255,50,0);
        panel.add(brightnessSlider);
        panel.add(new JLabel("Kontrast: "));
        contrastSlider = createSlider(-100,100,20,1);
        panel.add(contrastSlider);

        return panel;
    }

    private JSlider createSlider(int min, int max,int spaces, int initialValue) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, initialValue);
        slider.setMajorTickSpacing( spaces*2);
        slider.setMinorTickSpacing(spaces);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPreferredSize(new Dimension(200, 50));
        return slider;
    }

    private JPanel getActionPanel() {
        JPanel buttonPanel = new JPanel();
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Anuluj");

        // Obsługa przycisku OK. Sprawdzenie poprawności danych i zamknięcie okna. Jeśli dane są niepoprawne, wyświetlany jest komunikat z błędem.
        okButton.addActionListener(e -> {
                confirmed = true;
                dispose();

        });

        // Obsługa przycisku Anuluj przez zamknięcie okna dialogowego.
        cancelButton.addActionListener(e -> dispose());

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        return buttonPanel;
    }
    public Integer[] getIntArray() {
        if (confirmed) {
            Integer[] parameter = new Integer[2];
            parameter[0] = brightnessSlider.getValue();
            parameter[1] = contrastSlider.getValue();
            return parameter;
        }
        return null;
    }




}
