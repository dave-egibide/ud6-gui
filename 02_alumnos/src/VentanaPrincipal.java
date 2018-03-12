import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class VentanaPrincipal {
    public List<Alumno> alumnos = new ArrayList<>();

    private JPanel PanelPrincipal;
    private JTabbedPane tabbedPane1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JPanel datosPanel;
    private JButton guardar;
    private JButton verLista;
    private JLabel nombreLabel;
    private JLabel apellidosLabel;
    private JLabel telefonoLabel;
    private JLabel emailLabel;
    private ListadoAlumnos listadoAlumnos;

    public VentanaPrincipal() {
        guardar.addActionListener(e -> {
            if (textField1.getText().isEmpty() || textField2.getText().isEmpty()) {
                JOptionPane.showMessageDialog(datosPanel, "ERROR");
            } else {
                alumnos.add(new Alumno(textField1.getText(), textField2.getText(), textField3.getText(), textField4.getText()));
                JOptionPane.showMessageDialog(null, "OK");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");

            }
        });
        verLista.addActionListener(e -> listadoAlumnos = new ListadoAlumnos(alumnos));

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().PanelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
