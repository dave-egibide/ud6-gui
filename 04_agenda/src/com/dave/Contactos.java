package com.dave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class Contactos {
    private JPanel panelPrincipal;
    private JLabel numeroLabel;
    private JButton atrasButton;
    private JButton adelanteButton;
    private JLabel nombreLabel;
    private JLabel telefonoLabel;
    private JLabel emailLabel;
    private int contador = 0;


    public Contactos(Collection<Contacto> contactos) {
        JFrame frame = new JFrame("Contactos");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        List<Contacto> contactoList = new ArrayList<>(contactos);
        Collections.sort(contactoList,new ComparadorNombre());
        actualizar(contactoList);

        atrasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador == 0) contador = contactoList.size() -1;
                else contador--;
                actualizar(contactoList);
            }
        });
        adelanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador == contactoList.size() -1) contador = 0;
                else contador++;
                actualizar(contactoList);
            }
        });
    }

    private void actualizar(List<Contacto> contactoList) {
        numeroLabel.setText((contador+1) + " de " + contactoList.size());

        nombreLabel.setText(contactoList.get(contador).getNombre());
        telefonoLabel.setText(contactoList.get(contador).getTelefono());
        emailLabel.setText(contactoList.get(contador).getEmail());
    }
}
