package com.dave;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal {
    private JPanel panelPrincipal;
    private JButton button0;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton[] buttons;
    private JPanel firstRow;
    private JPanel secondRow;
    private JPanel thirdRow;
    private TresEnRaya tresEnRaya = new TresEnRaya();
    int i;

    public VentanaPrincipal() {
        buttons = new JButton[]{button0, button1, button2, button3, button4, button5, button6, button7, button8};
        for (i = 0; i < buttons.length; i++) {
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    movimiento(i);
                }
            });
        }
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    private void movimiento(int casilla) {
        if (tresEnRaya.getCasilla(casilla) == 0) {
            tresEnRaya.jugada(casilla);
            buttons[casilla].setText(tresEnRaya.getValor(casilla));
            if (tresEnRaya.comprobarGanador()) {
                JOptionPane.showMessageDialog(panelPrincipal, "¡Enhorabuena, has ganado!", "Resultado", JOptionPane.WARNING_MESSAGE);
                limpiarTablero();
            } else {
                if (tresEnRaya.getTurno() == 8) {
                    JOptionPane.showMessageDialog(panelPrincipal, "¡Empate!", "Resultado", JOptionPane.ERROR_MESSAGE);
                    limpiarTablero();
                } else
                    tresEnRaya.siguienteTurno();
            }
        }
    }

    private void limpiarTablero() {
        tresEnRaya.limpiarTablero();
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText(tresEnRaya.getValor(i));
        }
    }
}

