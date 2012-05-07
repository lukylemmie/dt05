package guiTute;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 7/05/12
 * Time: 11:39 AM
 * To change this template use File | Settings | File Templates.
 */


public class Example extends JFrame {

    public Example() {
        initUI();
    }

    public final void initUI() {

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        panel.setLayout(null);
        panel.setToolTipText("A Panel container");

        JButton button = new JButton("Button");
        button.setBounds(100, 60, 100, 30);
        button.setToolTipText("A button component");

        JButton quitButton = new JButton("Quit");
        quitButton.setBounds(50, 60, 80, 30);
        //if quit button is pressed quit the program
        quitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }
        });

        panel.add(button);
        panel.add(quitButton);

        setTitle("Tooltip");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Example ex = new Example();
                ex.setVisible(true);
            }
        });
    }
}