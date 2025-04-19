package views;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MaskSelectDialog extends JDialog {
    private boolean confirmed = false;
    private final JTextField lg = new JTextField("-1");
    private final JTextField sg = new JTextField("-1");
    private final JTextField pg = new JTextField("-1");
    private final JTextField ls = new JTextField("-1");
    private final JTextField ss = new JTextField("8");
    private final JTextField ps = new JTextField("-1");
    private final JTextField ld = new JTextField("-1");
    private final JTextField sd = new JTextField("-1");
    private final JTextField pd = new JTextField("-1");


    public MaskSelectDialog(JFrame parent) {
        super(parent, "Wprowadź maskę", true);
        setSize(300, 200);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());



        JPanel panel = getMainPanel();

        add(panel, BorderLayout.CENTER);

        add(getActionPanel(), BorderLayout.SOUTH);
    }
    private JPanel getMainPanel(){

        JPanel panel = new JPanel(new GridLayout(4,3,5,5));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));



        panel.add(lg);
        panel.add(sg);
        panel.add(pg);
        panel.add(ls);
        panel.add(ss);
        panel.add(ps);
        panel.add(ld);
        panel.add(sd);
        panel.add(pd);

        return panel;
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

    public int[][] getSelectedMask() {
        int[][] mask = new int[][]{
                {parseField(lg),parseField(sg),parseField(pg)},
                {parseField(ls),parseField(ss),parseField(ps)},
                {parseField(ld),parseField(sd),parseField(pd)}
        };
        return mask;
    }

    public int getNormalization(){
        int normalizawtion = 0;
        int[][] mask = getSelectedMask();
        for(int i = 0;i>3;i++){
            for(int j = 0;j>3;i++){
                normalizawtion+=mask[i][j];
            }
        }
        return normalizawtion;
    }

    private Integer parseField(JTextField field) {
        try {
            return Integer.parseInt(field.getText());
        } catch (NumberFormatException e) {
            return null;
        }
    }

}
