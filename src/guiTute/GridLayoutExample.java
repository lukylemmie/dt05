package guiTute;

import javax.swing.*;
import java.awt.*;


public class GridLayoutExample extends JFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {

                GridLayoutExample ex = new GridLayoutExample();
                ex.setVisible(true);
            }
        });
    }

    public GridLayoutExample() {

        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel();

        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        String[] buttons = {
                "Cls", "Bck", "", "Close", "7", "8", "9", "/", "4",
                "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"
        };


        for (int i = 0; i < buttons.length; i++) {

            if (i == 2)
                panel.add(new JLabel(buttons[i]));
            else
                panel.add(new JButton(buttons[i]));
        }

        add(panel);

        setTitle("GridLayout");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}