package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class AdmFrame extends JFrame{
    private JPanel panel1;
    private JButton cadastrarNovaEntregaButton;
    private JButton simularCargaDeDadosButton;
    private JButton consultarTodasAsEntregasButton;
    private JButton cadastrarNovaLocalizaçãoButton;
    private JButton cadastrarNovoDroneButton;
    private JButton cadastrarNovoClienteButton;
    private JButton sairButton;
    private JFrame frame;

    public AdmFrame(ArrayList<Cliente> listaCliente, ArrayList<Entrega> listaEntrega, ArrayList<Localizacao> listaLocalizacao, ArrayList<Drone> listaDrone){
        frame = new JFrame("Adm Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,500));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        cadastrarNovaLocalizaçãoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovaLocalizacaoFrame(listaLocalizacao);
            }
        });
        cadastrarNovoDroneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovoDroneFrame(listaDrone,listaLocalizacao);
            }
        });
        consultarTodasAsEntregasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaEntrega.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Nenhuma entrega foi feita.");
                }
                else {
                    new ConsultarEntregaFrame(listaEntrega);
                }
            }
        });
        cadastrarNovoClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovoClienteFrame(listaCliente,listaLocalizacao);
            }
        });
        cadastrarNovaEntregaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new NovaEntregaFrame(listaEntrega,listaLocalizacao,listaCliente,listaDrone);
            }
        });
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }

}
