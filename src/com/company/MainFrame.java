package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame{
    private JTextField usuario;
    private JPanel panel1;
    private JPasswordField senha;
    private JButton loginButton;
    private JFrame frame;

    public MainFrame(){
        frame = new JFrame("Login Frame");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,200));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (usuario.getText().equals("adm") && senha.getText().equals("123")){
                    JOptionPane.showMessageDialog(null,"Bem vindo.");
                    new AdmFrame();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Usuario ou senha invalida.");
                }
            }
        });
    }

}
