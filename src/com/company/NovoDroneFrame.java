package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NovoDroneFrame extends JFrame{
    private JPanel panel1;
    private JTextField identificador;
    private JTextField autonomiaKm;
    private JTextField cargaMaxima;
    private JButton okButton;
    private JButton cancelarButton;
    private JButton limparButton;
    private JTextField textField1;
    private JFrame frame;
    private int cont;
    private int cont2;


    public NovoDroneFrame(ArrayList<Drone> listaDrone, ArrayList<Localizacao> listaLocalizacao) {
        frame = new JFrame("NovoDrone Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,500));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autonomiaKm.setText("");
                identificador.setText("");
                cargaMaxima.setText("");
                textField1.setText("");
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont = 0;
                cont2 = 0;
                for (int i = 0; i < listaDrone.size(); i++){
                    if (listaDrone.get(i).getIdentificador() == Integer.parseInt(identificador.getText())){
                        cont++;
                        JOptionPane.showMessageDialog(null,"Identificador ja cadastrado no sistema.");
                    }
                }
                if (cont == 0) {
                    int ident = Integer.parseInt(identificador.getText());
                    double cargaMax = Double.parseDouble(cargaMaxima.getText());
                    int autonomia = Integer.parseInt(autonomiaKm.getText());
                    int base = Integer.parseInt(textField1.getText());
                    Localizacao localizacao = null;
                    for (int i = 0; i < listaLocalizacao.size(); i++) {
                        if (listaLocalizacao.get(i).getCodigo() == base) {
                            localizacao = listaLocalizacao.get(i);
                        }
                    }


                    Drone drone = null;
                    try {
                        if (localizacao != null) {
                            cont2++;
                            drone = new Drone(ident, cargaMax, autonomia, localizacao);
                        }
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o drone.");
                    }
                    if (cont2 == 0){
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o drone.");
                    }
                    else {
                        listaDrone.add(drone);
                        JOptionPane.showMessageDialog(null, "Drone cadastrado com sucesso.");
                        frame.setVisible(false);
                    }
                }
            }
        });
    }
}
