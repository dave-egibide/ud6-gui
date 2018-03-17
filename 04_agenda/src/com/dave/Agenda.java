package com.dave;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.TreeSet;

public class Agenda {

    private JPanel panelPrincipal;
    private JButton addContactButton;
    private JButton searchContactButton;
    private JButton viewContactsButton;
    private Collection<Contacto> contactos = new TreeSet<>();
    private Agenda agenda = this;
    private Contactos contactosVentana;
    private NuevoContacto nuevoContacto;
    private Buscar buscar;

    public Agenda() {

        contactos.add(new Contacto("David","666","dave@mailto"));
        contactos.add(new Contacto("Pepe","777","pepe@mailto"));
        contactos.add(new Contacto("Momo","888","momo@mailto"));
        contactos.add(new Contacto("Ana","555","ana@mailto"));


        addContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nuevoContacto = new NuevoContacto(agenda);
                nuevoContacto.mostrar(contactos);
            }
        });
        viewContactsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                contactosVentana = new Contactos(agenda);
                contactosVentana.mostrar(contactos);

            }
        });
        searchContactButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscar = new Buscar(agenda);
                buscar.mostrar(contactos);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Agenda");
        frame.setContentPane(new Agenda().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
