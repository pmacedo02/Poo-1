package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdmFrame extends JFrame{
    private JPanel panel1;
    private JButton cadastrarNovaEntregaButton;
    private JButton simularCargaDeDadosButton;
    private JButton consultarTodasAsEntregasButton;
    private JButton cadastrarNovaLocalizaçãoButton;
    private JButton cadastrarNovoDroneButton;
    private JButton cadastrarNovoClienteButton;
    private JFrame frame;
    private ArrayList<Localizacao> listaLocalizacao = new ArrayList<>();

    public AdmFrame(){
        frame = new JFrame("Adm Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,500));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public boolean isNum(String str){
        if (str.matches("[+-]?\\d*(\\.\\d+)?")){
            return true;
        }
        return false;
    }
}
