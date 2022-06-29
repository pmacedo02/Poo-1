package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.Paths;
import java.util.ArrayList;

public class listaDrones extends JFrame{
    private JComboBox comboBox1;
    private JPanel panel1;
    private JButton cancelarButton;
    private JButton okButton;
    private JFrame frame;
    private int cont;

    public listaDrones(ArrayList<Drone> listD, double pes, ArrayList<Entrega> listaEntrega, Object selectedItem, int num, String descrica, String dat, double v, String situa, Localizacao localizacaoOrigem, Localizacao localizacaoDestino){
        frame = new JFrame("listaDrone Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,500));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        cont = 0;

        for (int i = 0; i < listD.size(); i++){
            comboBox1.addItem(listD.get(i));
        }

        String drone = String.valueOf(comboBox1.getSelectedItem());
        String cliente = String.valueOf(selectedItem);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Entrega entrega = new Entrega(num,descrica,dat,pes,situa,localizacaoOrigem,localizacaoDestino,drone,cliente);
                listaEntrega.add(entrega);
                JOptionPane.showMessageDialog(null, "Entrega cadastrada com sucesso.");
                frame.setVisible(false);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }



}
