package com.dave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class NuevoContacto {
    private JPanel panelPrincipal;
    private JTextField nombreTextField;
    private JTextField telefonoTextField;
    private JTextField emailTextField;
    private JButton guardarButton;
    private JButton cancelarButton;

    public NuevoContacto(Collection<Contacto> contactos) {
        JFrame frame = new JFrame("Nuevo Contacto");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        guardarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (nombreTextField.getText().isEmpty() || telefonoTextField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(panelPrincipal, "Datos insuficientes", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    Contacto contacto = new Contacto(nombreTextField.getText(), telefonoTextField.getText(), emailTextField.getText());
                    if (contactos.contains(contacto)) {
                        JOptionPane.showMessageDialog(panelPrincipal, "Teléfono ya añadido", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        contactos.add(contacto);
                        JOptionPane.showMessageDialog(panelPrincipal, "Contacto correctamente añadido");
                        frame.dispose();
                    }
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });
    }

}
