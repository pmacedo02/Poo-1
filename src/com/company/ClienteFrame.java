package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ClienteFrame extends JFrame{
    private JButton consultarEntregasButton;
    private JPanel panel1;
    private JButton consultarCobrançaMensalButton;
    private JButton sairButton;
    JFrame frame;
    private int cont;
    private ArrayList<Entrega> listaAux = new ArrayList<>();

    public ClienteFrame(ArrayList<Entrega> listaEntrega, Cliente cl) {
        frame = new JFrame("Cliente Frame");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,500));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        String cliente = String.valueOf(cl);
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
        consultarEntregasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (listaEntrega.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Nenhuma entrega foi feita.");
                }
                else {
                    cont = 0;
                    listaAux.clear();
                    for (int i = 0; i < listaEntrega.size(); i++) {
                        if (listaEntrega.get(i).getCliente().equals(cliente)) {
                            listaAux.add(listaEntrega.get(i));
                            cont++;
                        }
                    }
                }
                if (cont == 0){
                    JOptionPane.showMessageDialog(null,"Nenhuma entrega foi feita.");
                }
                else {
                    new ConsultarEntregaFrame(listaAux);
                }

            }
        });
    }
}
