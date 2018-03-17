package com.dave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
    private Agenda agenda;

    public Contactos(Agenda agenda) {
        this.agenda = agenda;
    }

    public void mostrar(Collection<Contacto> contactos) {
        JFrame frame = new JFrame("Contactos");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        List<Contacto> contactoList = new ArrayList<>(contactos);
        Collections.sort(contactoList,new ComparadorNombre());
        actualizar(contactoList);

        Action adelante = new AbstractAction() {
            @Override
                public void actionPerformed(ActionEvent e) {
                    if (contador == contactoList.size() -1) contador = 0;
                    else contador++;
                    actualizar(contactoList);
            }
        };

        Action atras = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (contador == 0) contador = contactoList.size() -1;
                else contador--;
                actualizar(contactoList);
            }
        };
        atrasButton.addActionListener(atras);
        adelanteButton.addActionListener(adelante);

        panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0), "atras");
        panelPrincipal.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0), "adelante");
        panelPrincipal.getActionMap().put("atras", atras);
        panelPrincipal.getActionMap().put("adelante", adelante);

    }

    private void actualizar(List<Contacto> contactoList) {
        if (!contactoList.isEmpty()) {
            numeroLabel.setText((contador + 1) + " de " + contactoList.size());

            nombreLabel.setText(contactoList.get(contador).getNombre());
            telefonoLabel.setText(contactoList.get(contador).getTelefono());
            emailLabel.setText(contactoList.get(contador).getEmail());
        } else {
            atrasButton.setVisible(false);
            adelanteButton.setVisible(false);
        }
    }
}
