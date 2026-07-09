package CalculadoraVoltaje;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculadoraVoltaje {

    private JFrame frame;
    private JTextField txtAmperios;
    private JTextField txtOhmios;
    private JLabel lblResultado;
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    CalculadoraVoltaje window = new CalculadoraVoltaje();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public CalculadoraVoltaje() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Calculadora de Voltaje");
        frame.setBounds(100, 100, 420, 220);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblAmperios = new JLabel("Amperios:");
        lblAmperios.setBounds(20, 30, 80, 20);
        frame.getContentPane().add(lblAmperios);

        txtAmperios = new JTextField();
        txtAmperios.setBounds(120, 30, 180, 25);
        frame.getContentPane().add(txtAmperios);
        txtAmperios.setColumns(10);

        JLabel lblOhmios = new JLabel("Ohmios:");
        lblOhmios.setBounds(20, 70, 80, 20);
        frame.getContentPane().add(lblOhmios);

        txtOhmios = new JTextField();
        txtOhmios.setBounds(120, 70, 180, 25);
        frame.getContentPane().add(txtOhmios);
        txtOhmios.setColumns(10);

        JButton btnCalcular = new JButton("Calcular Voltaje");
        btnCalcular.setBounds(120, 110, 180, 30);
        frame.getContentPane().add(btnCalcular);
        
        JButton btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setBounds(310, 110, 90, 30);
        frame.getContentPane().add(btnLimpiar);

        btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                txtAmperios.setText("");
                txtOhmios.setText("");
                lblResultado.setText("Voltaje:");
            }
        });

        lblResultado = new JLabel("Voltaje:");
        lblResultado.setBounds(20, 155, 350, 20);
        frame.getContentPane().add(lblResultado);

        btnCalcular.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                try {

                    double amperios = Double.parseDouble(txtAmperios.getText());
                    double ohmios = Double.parseDouble(txtOhmios.getText());

                    if (amperios < 0 || ohmios < 0) {
                        throw new IllegalArgumentException(
                                "Los valores no pueden ser negativos.");
                    }

                    double voltaje = amperios * ohmios;

                    lblResultado.setText("Voltaje: " + voltaje);

                }

                catch (NumberFormatException ex) {
                    lblResultado.setText(
                            "Error: Ingresa valores numéricos válidos.");
                }

                catch (IllegalArgumentException ex) {
                    lblResultado.setText(
                            "Error: " + ex.getMessage());
                }

                catch (Throwable ex) {
                    JOptionPane.showMessageDialog(frame,
                            "Ocurrió un error inesperado.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
