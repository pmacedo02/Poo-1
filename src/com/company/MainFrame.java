package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainFrame extends JFrame{
    private JTextField usuario;
    private JPanel panel1;
    private JPasswordField senha;
    private JButton loginButton;
    private JButton limparButton;
    private JButton cancelarButton;
    private JFrame frame;
    private ArrayList<Cliente> listaCliente = new ArrayList<>();
    private ArrayList<Entrega> listaEntrega = new ArrayList<>();
    private ArrayList<Localizacao> listaLocalizacao = new ArrayList<>();
    private ArrayList<Drone> listaDrone = new ArrayList<>();
    private int cont;

    public MainFrame(){
        executa();
        frame = new JFrame("Login Frame");
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(250,300));
        frame.setResizable(false);
        frame.add(panel1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int i = 0; i < listaCliente.size(); i++){
                    if (usuario.getText().equals(listaCliente.get(i).getEmail()) && senha.getText().equals(listaCliente.get(i).getSenha())){
                        cont++;
                        JOptionPane.showMessageDialog(null,"Bem vindo.");
                        Cliente cl = listaCliente.get(i);
                        new ClienteFrame(listaEntrega,cl);
                    }
                }
                if (cont == 0) {
                    if (usuario.getText().equals("adm") && senha.getText().equals("123")) {
                        JOptionPane.showMessageDialog(null, "Bem vindo.");
                        new AdmFrame(listaCliente,listaEntrega,listaLocalizacao,listaDrone);
                    } else {
                        JOptionPane.showMessageDialog(null, "Usuario ou senha invalida.");
                    }
                }
                cont = 0;
            }
        });
        limparButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usuario.setText("");
                senha.setText("");
            }
        });
    }

    public void executa(){
        Localizacao l1 = new Localizacao(111,"rua Sao roque",12313,41231);
        listaLocalizacao.add(l1);
        Localizacao l2 = new Localizacao(112,"rua Eduardo chartier",41974,81935);
        listaLocalizacao.add(l2);
        Localizacao l3 = new Localizacao(113,"av Amarela",17841,93138);
        listaLocalizacao.add(l3);
        Cliente c1 = new Cliente("Flavio Vianna","flavio@mail.com","123",l1);
        listaCliente.add(c1);
        Cliente c2 = new Cliente("Paola Lazzarotti","paola@mail.com","123",l2);
        listaCliente.add(c2);
        Cliente c3 = new Cliente("Pedro Macedo","pedo@mail.com","123",l3);
        listaCliente.add(c3);
        Drone d1 = new Drone(111,100,80,l1);
        listaDrone.add(d1);
        Drone d2 = new Drone(112,20,150,l2);
        listaDrone.add(d2);
        Drone d3 = new Drone(113,50,60,l3);
        listaDrone.add(d3);
        Entrega e1 = new Entrega(111,"Perecivel","12/3/2020",80,"Cadastrada",l1,l2,"Drone{identificador=111, cargaMaxima=100, autonomiaKm=80, base=Localizacao{codigo=111, logradouro=rua Sao roque, latitude=12313, longitude=41231}}","Cliente{nome=Flavio Vianna, email=flavio@mail.com, senha=123}");
        listaEntrega.add(e1);
        Entrega e2 = new Entrega(112,"Nao perecivel","21/3/2022",60,"Entregue",l2,l3,"Drone{identificador=111, cargaMaxima=100, autonomiaKm=80, base=Localizacao{codigo=111, logradouro=rua Sao roque, latitude=12313, longitude=41231}}","Cliente{nome=Flavio Vianna, email=flavio@mail.com, senha=123}");
        listaEntrega.add(e2);
        Entrega e3 = new Entrega(113,"Perecivel","29/8/2022",40,"Cancelada",l1,l3,"Drone{identificador=113, cargaMaxima=50, autonomiaKm=60, base=Localizacao{codigo=113, logradouro=Av Amarela, latitude=17841, longitude=93138}}","Cliente{nome=Pedro Macedo, email=pedro@mail.com, senha=123}");
        listaEntrega.add(e3);

    }
}
