package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NovaLocalizacaoFrame extends JFrame{
    private JTextField codigo;
    private JPanel panel1;
    private JTextField longitude;
    private JTextField logradouro;
    private JTextField latitude;
    private JButton okButton;
    private JButton cancelarButton;
    private JButton limparButton;
    private JFrame frame;
    private int cont;
    private int cont2;

    public NovaLocalizacaoFrame(ArrayList<Localizacao> listaLocalizacao){
        frame = new JFrame("NovaLocalizacao Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,500));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

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
                for (int i = 0; i < listaLocalizacao.size(); i++) {
                    if (listaLocalizacao.get(i).getCodigo() == Integer.parseInt(codigo.getText())) {
                        cont++;
                        JOptionPane.showMessageDialog(null, "Codigo ja cadastrado no sistema.");
                    }
                }
                if (cont == 0) {
                    int cod = Integer.parseInt(codigo.getText());
                    String longra = logradouro.getText();
                    double latitu = Double.parseDouble(latitude.getText());
                    double longitu = Double.parseDouble(longitude.getText());
                    Localizacao localizacao = null;
                    try {
                        cont2++;
                        localizacao = new Localizacao(cod, longra, latitu, longitu);
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o codigo.");
                    }
                    if (cont2 == 0){
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o codigo.");
                    }
                    else {
                        listaLocalizacao.add(localizacao);
                        JOptionPane.showMessageDialog(null, "Localizacao cadastrada com sucesso.");
                        frame.setVisible(false);
                    }
                }
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                codigo.setText("");
                longitude.setText("");
                logradouro.setText("");
                latitude.setText("");
            }
        });
    }

}
