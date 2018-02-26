import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class VentanaPrincipal {
    private JPanel panelPrincipal;
    private JTextField usuarioField;
    private JPasswordField passwordField;
    private JLabel usuarioLabel;
    private JLabel passLabel;
    private JButton entrar;

    private Login login = new Login();

    public VentanaPrincipal() {
        entrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String password = new String(passwordField.getPassword());
                    if (login.login(usuario,password) ) {
                    JOptionPane.showMessageDialog(null,"OK");
                } else JOptionPane.showMessageDialog(null, "ERROR");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
