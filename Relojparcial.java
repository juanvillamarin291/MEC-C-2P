import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;

public class Relojparcial extends JFrame {
    private JLabel labelHora;
    private JButton btnIniciar;
    private JButton btnDetener;
    private JButton btnAcelerar;
    private JButton btnDesacelerar;
    private Timer timer;
    private int velocidad = 1000;

    public Relojparcial() {
        setTitle("Juan Fernando Villamarin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(200, 120);
        setLocationRelativeTo(null);
        setLayout(new FlowLayout());

        labelHora = new JLabel();
        add(labelHora);

        btnIniciar = new JButton("Iniciar");
        btnIniciar.addActionListener(e -> iniciar());
        add(btnIniciar);

        btnDetener = new JButton("Detener");
        btnDetener.addActionListener(e -> detener());
        add(btnDetener);

        btnAcelerar = new JButton("Acelera");
        btnAcelerar.addActionListener(e -> acelerar());
        add(btnAcelerar);

        btnDesacelerar = new JButton("Desacelera");
        btnDesacelerar.addActionListener(e -> desacelerar());
        add(btnDesacelerar);
    }

    public void iniciar() {
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
        timer = new Timer(velocidad, e -> {
            labelHora.setText(sdf.format(System.currentTimeMillis()));
        });
        timer.start();
    }

    public void detener() {
        if (timer != null) {
            timer.stop();
        }
    }

    public void acelerar() {
        velocidad /= 2;
        if (timer != null) {
            timer.setDelay(velocidad);
        }
    }

    public void desacelerar() {
        velocidad *= 2;
        if (timer != null) {
            timer.setDelay(velocidad);
        }
    }

    public static void main(String[] args) {
        Relojparcial reloj = new Relojparcial();
        reloj.setVisible(true);
    }
}
