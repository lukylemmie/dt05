package guiTute;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;


public class BorderExample extends JFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                BorderExample ex = new BorderExample();
                ex.setVisible(true);
            }
        });
    }

    public BorderExample() {

        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel(new BorderLayout());
        JPanel top = new JPanel();

        top.setBackground(Color.gray);
        top.setPreferredSize(new Dimension(250, 150));
        panel.add(top);

        panel.setBorder(new EmptyBorder(new Insets(20, 20, 20, 20)));

        add(panel);

        pack();

        setTitle("Border Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}