package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ConsultarEntregaClienteFrame extends JFrame {

    private JTextArea textArea1;
    private JPanel panel1;
    private JButton voltarButton;
    private JFrame frame;

    public ConsultarEntregaClienteFrame(ArrayList<Entrega> listaEntrega) {
        frame = new JFrame("ConsultarEntrega Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,500));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        String str = "";
        for (int i = 0; i < listaEntrega.size(); i++){
            str += listaEntrega.get(i).toString();
        }
        textArea1.setText(str);

        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }
}
