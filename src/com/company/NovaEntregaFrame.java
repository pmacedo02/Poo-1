package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NovaEntregaFrame extends JFrame{
    private JTextField numero;
    private JPanel panel1;
    private JTextField descricao;
    private JTextField data;
    private JTextField peso;
    private JTextField situacao;
    private JTextField origem;
    private JTextField destino;
    private JButton okButton;
    private JButton cancelarButton;
    private JButton limparButton;
    private JComboBox comboBox1;
    private JFrame frame;
    private int cont;
    private int cont2;
    private int cont3;
    private ArrayList<Drone> listD = new ArrayList<>();

    public ArrayList<Drone> getListD() {
        return listD;
    }


    public NovaEntregaFrame(ArrayList<Entrega> listaEntrega, ArrayList<Localizacao> listaLocalizacao, ArrayList<Cliente> listaCliente, ArrayList<Drone> listaDrone){
        frame = new JFrame("NovaEntrega Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(900,500));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        listD = listaDrone;

        for (int i = 0; i < listaCliente.size(); i++) {
            comboBox1.addItem(listaCliente.get(i));
        }



        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numero.setText("");
                descricao.setText("");
                data.setText("");
                peso.setText("");
                situacao.setText("");
                origem.setText("");
                destino.setText("");
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
                for (int i = 0; i < listaEntrega.size(); i++){
                    if (listaEntrega.get(i).getNumero() == Integer.parseInt(numero.getText())){
                        cont++;
                        JOptionPane.showMessageDialog(null,"Entrega ja cadastrada no sistema.");
                    }
                }
                if (cont == 0) {
                    int num = Integer.parseInt(numero.getText());
                    String descrica = descricao.getText();
                    double pes = Double.parseDouble(peso.getText());
                    String situa = situacao.getText();
                    String dat = data.getText();


                    int localizacaoO = Integer.parseInt(numero.getText());
                    Localizacao localizacaoOrigem = null;
                    for (int i = 0; i < listaLocalizacao.size(); i++) {
                        if (listaLocalizacao.get(i).getCodigo() == localizacaoO) {
                            localizacaoOrigem = listaLocalizacao.get(i);
                        }
                    }

                    int localizacaoD = Integer.parseInt(numero.getText());
                    Localizacao localizacaoDestino = null;
                    for (int i = 0; i < listaLocalizacao.size(); i++) {
                        if (listaLocalizacao.get(i).getCodigo() == localizacaoD) {
                            localizacaoDestino = listaLocalizacao.get(i);
                        }
                    }

                    Entrega entrega = null;
                    try {
                        if (localizacaoOrigem != null && localizacaoDestino != null) {
                            cont2++;
                            //entrega = new Entrega(num,descrica,dat,pes,situa,localizacaoOrigem,localizacaoDestino) {
                            //};
                        }
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar a entrega.");
                    }
                    if (cont2 == 0){
                        JOptionPane.showMessageDialog(null, "Erro ao cadastrar a entrega.");
                    }
                    int tamanho = listaDrone.size();
                    for (int i = 0; i < tamanho; i++) {
                        if (listaDrone.get(i).getCargaMaxima() >= pes) {
                            listD.add(listaDrone.get(i));
                            cont3++;
                        }
                    }
                    if (cont3 == 0){
                        JOptionPane.showMessageDialog(null,"Nenhum drone para capacidade de entrega");
                    }
                    else {
                        frame.setVisible(false);
                        new listaDrones(getListD(), pes, listaEntrega,comboBox1.getSelectedItem(),num,descrica,dat,pes,situa,localizacaoOrigem,localizacaoDestino);
                    }

                }
            }
        });



    }
}
