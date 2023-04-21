import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Parcial2corte extends JFrame implements ActionListener, ChangeListener {
    private static final long serialVersionUID = 1L;

    private final DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    private LocalDateTime horaActual = LocalDateTime.now();
    private final Timer temporizador = new Timer(1000, this);
    private int velocidad = 1000;
    private boolean detener = false;

    private JButton btnStart, btnStop;
    private JSlider sliderSpeed;
    private JLabel lblTime;

    public Parcial2corte() {
        super("My Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        btnStart = new JButton("Start");
        btnStop = new JButton("Stop");
        btnStart.setBackground(Color.GREEN);
        btnStop.setBackground(Color.RED);
        btnStart.setForeground(Color.WHITE);
        btnStop.setForeground(Color.WHITE);
        buttonPanel.add(btnStart);
        buttonPanel.add(btnStop);
        btnStart.addActionListener(this);
        btnStop.addActionListener(this);

        JPanel speedPanel = new JPanel(new BorderLayout());
        sliderSpeed = new JSlider(JSlider.HORIZONTAL, 1, 10, 1);
        sliderSpeed.setMajorTickSpacing(1);
        sliderSpeed.setPaintTicks(true);
        sliderSpeed.setPaintLabels(false);
        sliderSpeed.setInverted(true);
        sliderSpeed.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sliderSpeed.setBackground(Color.LIGHT_GRAY);
        sliderSpeed.addChangeListener(this);
        speedPanel.add(sliderSpeed, BorderLayout.CENTER);

        lblTime = new JLabel(horaActual.format(formatoHora));
        lblTime.setHorizontalAlignment(JLabel.CENTER);
        lblTime.setVerticalAlignment(JLabel.CENTER);
        lblTime.setFont(new Font("Arial", Font.BOLD, 48));
        lblTime.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        lblTime.setForeground(Color.DARK_GRAY);
        add(lblTime, BorderLayout.CENTER);

        add(buttonPanel, BorderLayout.NORTH);
        add(speedPanel, BorderLayout.SOUTH);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart) {
            detener = false;
            temporizador.start();
        } else if (e.getSource() == btnStop) {
            detener = true;
            temporizador.stop();
        } else if (e.getSource() == temporizador) {
            horaActual = horaActual.plusSeconds(1);
            lblTime.setText(horaActual.format(formatoHora));
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        velocidad = (11 - sliderSpeed.getValue()) * 100;
        temporizador.setDelay(velocidad);
    }

    public static void main(String[] args) {
        new Parcial2corte();
    }
}
