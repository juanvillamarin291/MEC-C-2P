import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reloj extends JFrame {
    private JLabel horaLabel;
    private JLabel minutosLabel;
    private JLabel segundosLabel;
    private JButton iniciarBtn;
    private JButton detenerBtn;
    private JButton acelerarBtn;
    private JButton desacelerarBtn;
    private Timer timer;
    private int velocidad = 1000; 
    public Reloj() {
        initComponents();
        initTimer();
    }

    private void initComponents() {
        setTitle("Reloj");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);

        horaLabel = new JLabel();
        minutosLabel = new JLabel();
        segundosLabel = new JLabel();
        iniciarBtn = new JButton("Iniciar");
        detenerBtn = new JButton("Detener");
        acelerarBtn = new JButton("Acelerar");
        desacelerarBtn = new JButton("Desacelerar");

        horaLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        minutosLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        segunabel(":");
        add(segundosLabel);
        add(iniciarBtn);
        add(detenerBtn);
        add(acelerarBtn);
        add(desacelerarBtn);
dosLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        add(horaLabel);
        add(new JLabel(":"));
        add(minutosLabel);
        add(new JLabel());
        iniciarBtn.addActionListener (e -> timer.start());
        detenerBtn.addActionListener(e -> timer.stop());
        acelerarBtn.addActionListener(e -> velocidad = velocidad / 2);
        desacelerarBtn.addActionListener(e -> velocidad = velocidad * 2);
    }

    private void initTimer() {
        timer = new Timer(velocidad, e -> {
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat sdfHora = new SimpleDateFormat("HH");
            SimpleDateFormat sdfMinutos = new SimpleDateFormat("mm");
            SimpleDateFormat sdfSegundos = new SimpleDateFormat("ss");

            horaLabel.setText(sdfHora.format(calendar.getTime()));
            minutosLabel.setText(sdfMinutos.format(calendar.getTime()));
            segundosLabel.setText(sdfSegundos.format(calendar.getTime()));
        });
    }

    public static void main(String[] args) {
        Reloj reloj = new Reloj();
        reloj.setVisible(true);
    }

    private void segunabel(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

