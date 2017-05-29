package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vortex.bbdd.BD_Vortex;

public class PanelSocio_Pass extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelSocio_Pass frame12;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelSocio_Pass frame12 = new PanelSocio_Pass();
					frame12.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelSocio_Pass() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		int inicioalto = alto / 4;
		int inicioancho = ancho / 3;
		ancho = ancho / 4;
		alto = alto / 2;
		setTitle(" Vortex Socio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, 475, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* Icono Ventana */
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\coffeeV.png"));

		JLabel lblAntiguoNick = new JLabel("Antigua Password:");
		lblAntiguoNick.setHorizontalAlignment(SwingConstants.LEFT);
		lblAntiguoNick.setForeground(Color.WHITE);
		lblAntiguoNick.setFont(new Font("Dialog", Font.BOLD, 14));
		lblAntiguoNick.setBounds(69, 57, 142, 29);
		contentPane.add(lblAntiguoNick);

		textField = new JTextField();
		textField.setBounds(232, 63, 113, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNuevoNick = new JLabel("Nueva Password:");
		lblNuevoNick.setHorizontalAlignment(SwingConstants.LEFT);
		lblNuevoNick.setForeground(Color.WHITE);
		lblNuevoNick.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNuevoNick.setBounds(69, 111, 142, 29);
		contentPane.add(lblNuevoNick);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(232, 117, 113, 20);
		contentPane.add(textField_1);

		JLabel lblRepitePassword = new JLabel("Repite Password:");
		lblRepitePassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblRepitePassword.setForeground(Color.WHITE);
		lblRepitePassword.setFont(new Font("Dialog", Font.BOLD, 14));
		lblRepitePassword.setBounds(69, 165, 142, 29);
		contentPane.add(lblRepitePassword);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(232, 171, 113, 20);
		contentPane.add(textField_2);

		JLabel lblEstaSeguroDe = new JLabel("Esta seguro de que desea cambiar su password?");
		lblEstaSeguroDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstaSeguroDe.setForeground(Color.WHITE);
		lblEstaSeguroDe.setFont(new Font("Dialog", Font.BOLD, 11));
		lblEstaSeguroDe.setBounds(92, 212, 316, 29);
		contentPane.add(lblEstaSeguroDe);

		JButton btnContinuar = new JButton("Continuar");
		btnContinuar.setForeground(Color.BLACK);
		btnContinuar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnContinuar.setBounds(274, 257, 113, 23);
		contentPane.add(btnContinuar);

		btnContinuar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int filas = bd.updatePassSocio(textField.getText(), textField_1.getText(), textField_2.getText());
				switch (filas) {
				case -1:
					System.out.println("ERROR, intentalo mas tarde");
					break;
				case 0:
					System.out.println("Las contraseñas no coinciden");
					break;
				case 1:
					PanelSocio frame10 = new PanelSocio();
					frame10.setVisible(true);
					dispose();
					break;
				}

			}

		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVolver.setBounds(274, 302, 113, 23);
		contentPane.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}

		});

		JLabel label_2 = new JLabel("Vortex\u2122");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(390, 401, 67, 23);
		contentPane.add(label_2);

	}
}
