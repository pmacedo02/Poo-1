package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NovoClienteFrame extends JFrame{
    private JTextField nome;
    private JPanel panel1;
    private JTextField senha;
    private JTextField email;
    private JTextField endereco;
    private JButton okButton;
    private JButton cancelarButton;
    private JButton limparButton;
    private JFrame frame;
    private int cont;
    private int cont2;

    public NovoClienteFrame(ArrayList<Cliente> listaCliente, ArrayList<Localizacao> listaLocalizacao){
        frame = new JFrame("NovoCliente Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,500));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cont = 0;
                for (int i = 0; i < listaCliente.size(); i++) {
                    if (listaCliente.get(i).getEmail().equals(email.getText())) {
                        cont++;
                        JOptionPane.showMessageDialog(null, "Email ja cadastrado no sistema.");
                    }
                }
                if (cont == 0) {
                    String mail = email.getText();
                    String nom = nome.getText();
                    String senh = senha.getText();
                    int enderec = Integer.parseInt(endereco.getText());
                    Localizacao localizacao = null;
                    for (int i = 0; i < listaLocalizacao.size(); i++) {
                        if (listaLocalizacao.get(i).getCodigo() == enderec) {
                            localizacao = listaLocalizacao.get(i);
                        }
                    }

                    Cliente cliente = null;
                    try {
                        if (localizacao != null) {
                            cont2++;
                            cliente = new Cliente(nom, mail, senh, localizacao);
                        }
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente.");
                    }
                    if (cont2 == 0){
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar o cliente.");
                    }
                    else {
                        listaCliente.add(cliente);
                        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso.");
                        frame.setVisible(false);
                    }
                }
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nome.setText("");
                senha.setText("");
                endereco.setText("");
                email.setText("");
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
