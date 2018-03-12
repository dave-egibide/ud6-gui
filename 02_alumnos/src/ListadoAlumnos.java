import javax.swing.*;
import java.util.List;


public class ListadoAlumnos {
    private JPanel panelPrincipal;
    private JLabel todosLosAlumnos;
    private JTextArea alumnosLista;
    private VentanaPrincipal ventanaPrincipal;

    public ListadoAlumnos(List<Alumno> alumnos) {
        JFrame frame = new JFrame("ListadoAlumnos");
        frame.setContentPane(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


        alumnosLista.append("Alumnos\n" +
                "-------\n\n");
        for (Alumno alumno : alumnos) {
            alumnosLista.append(alumno.toString() + "\n");

        }


    }

}

