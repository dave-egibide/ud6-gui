package com.dave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Buscar {
    private JPanel panelPrincipal;
    private JComboBox parametroBox;
    private JTextField buscadorTextField;
    private JButton buscarButton;
    private JLabel nombreLabel;
    private JLabel telefonoLabel;
    private JLabel emailLabel;

    public Buscar(Collection<Contacto> contactos) {
        JFrame frame = new JFrame("Buscar");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<Contacto> contactoList = new ArrayList<>(contactos);
                int indice = 0;
                boolean finBusqueda = false;
                if (!buscadorTextField.getText().isEmpty()) switch (parametroBox.getSelectedIndex()) {
                    case 0:
                        //nombre
                        while (!contactoList.get(indice).getNombre().toUpperCase().contains(buscadorTextField.getText().toUpperCase()) && !finBusqueda) {
                            if (indice == contactoList.size() - 1) finBusqueda = true;
                            else indice++;
                        }
                        if (!finBusqueda) {
                            mostrarContacto(indice, contactoList);
                        }
                        break;
                    case 1:
                        //telefono
                        while (!contactoList.get(indice).getTelefono().toUpperCase().contains(buscadorTextField.getText().toUpperCase()) && !finBusqueda) {
                            if (indice == contactoList.size() - 1) finBusqueda = true;
                            else indice++;
                        }
                        if (!finBusqueda) {
                            mostrarContacto(indice, contactoList);
                        }
                        break;
                    case 2:
                        //email
                        while (!contactoList.get(indice).getEmail().toUpperCase().contains(buscadorTextField.getText().toUpperCase()) && !finBusqueda) {
                            if (indice == contactoList.size() - 1) finBusqueda = true;
                            else indice++;
                        }
                        if (!finBusqueda) {
                            mostrarContacto(indice, contactoList);
                        }
                        break;
                }
            }
        });
    }

    private void mostrarContacto(int indice, List<Contacto> contactoList) {
        nombreLabel.setText("Nombre: " + contactoList.get(indice).getNombre());
        telefonoLabel.setText("Teléfono: " + contactoList.get(indice).getTelefono());
        emailLabel.setText("Email: " + contactoList.get(indice).getEmail());
    }
}
