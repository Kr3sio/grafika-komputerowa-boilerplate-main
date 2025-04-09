package views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MaskSelectDialog extends JDialog {
    private JComboBox<String> maskComboBox;
    private boolean confirmed = false;
    private final Map<String, float[][]> maskiMap = new HashMap<>();
    private final Map<String, Float> normalizacjeMap = new HashMap<>();

    public MaskSelectDialog(JFrame parent) {
        super(parent, "Wybierz maskę", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        initializeMasks();

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(new JLabel("Wybierz filtr:"), BorderLayout.NORTH);

        maskComboBox = new JComboBox<>(maskiMap.keySet().toArray(new String[0]));
        panel.add(maskComboBox, BorderLayout.CENTER);
        add(panel, BorderLayout.CENTER);

        add(getActionPanel(), BorderLayout.SOUTH);
    }

    private void initializeMasks() {
        // Dodaj maski i ich normalizację
        maskiMap.put("Sobel-X", new float[][] {
                {-1, 0, 1},
                {-2, 0, 2},
                {-1, 0, 1}
        });
        normalizacjeMap.put("Sobel-X", 1f);

        maskiMap.put("Sobel-Y", new float[][] {
                {-1, -2, -1},
                { 0,  0,  0},
                { 1,  2,  1}
        });
        normalizacjeMap.put("Sobel-Y", 1f);

        maskiMap.put("Prewitt-X", new float[][] {
                {-1, 0, 1},
                {-1, 0, 1},
                {-1, 0, 1}
        });
        normalizacjeMap.put("Prewitt-X", 1f);

        maskiMap.put("Prewitt-Y", new float[][] {
                {-1, -1, -1},
                { 0,  0,  0},
                { 1,  1,  1}
        });
        normalizacjeMap.put("Prewitt-Y", 1f);

        maskiMap.put("Edge-East", new float[][] {
                {-1, -1, 1},
                {-1,  1, 1},
                {-1, -1, 1}
        });
        normalizacjeMap.put("Edge-East", 1f);

        maskiMap.put("Edge-SouthEast", new float[][] {
                {-1, 1, 1},
                {-1, 1, 1},
                {-1, -1, 1}
        });
        normalizacjeMap.put("Edge-SouthEast", 1f);

        maskiMap.put("Edge-SouthWest", new float[][] {
                { 1,  1, -1},
                { 1,  1, -1},
                { 1, -1, -1}
        });
        normalizacjeMap.put("Edge-SouthWest", 1f);
    }

    private JPanel getActionPanel() {
        JPanel panel = new JPanel();
        JButton okButton = new JButton("OK");
        JButton cancelButton = new JButton("Anuluj");

        okButton.addActionListener(e -> {
            confirmed = true;
            dispose();
        });

        cancelButton.addActionListener(e -> dispose());

        panel.add(okButton);
        panel.add(cancelButton);
        return panel;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public float[][] getSelectedMask() {
        String selected = (String) maskComboBox.getSelectedItem();
        return maskiMap.get(selected);
    }

    public float getNormalization() {
        String selected = (String) maskComboBox.getSelectedItem();
        return normalizacjeMap.getOrDefault(selected, 1f);
    }
}
