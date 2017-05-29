package vortex.ventanas;

import static java.nio.file.StandardOpenOption.APPEND;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vortex.Constantes;
import vortex.bbdd.BD_Vortex;
import javax.swing.SwingConstants;

public class PanelSocio_NoTime extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static PanelSocio_NoTime frame19;
	protected int tipoUser;
	private JPanel panelOrigen;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) throws IOException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelSocio_NoTime frame19 = new PanelSocio_NoTime();
					frame19.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public PanelSocio_NoTime() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		int inicioalto = alto / 4;
		int inicioancho = ancho / 3;
		ancho = ancho / 4;
		alto = alto / 2;

		/* Titulo de la ventana Java */

		setTitle(" Vortex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, 414, 360);

		/* Icono Ventana */
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\coffeeV.png"));

		/* Panel Login Java */

		panelOrigen = new JPanel();
		panelOrigen.setForeground(new Color(0, 0, 0));
		panelOrigen.setBackground(new Color(102, 153, 204));
		panelOrigen.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelOrigen);
		panelOrigen.setLayout(null);

		/* Variable User */

		JLabel variableUser = new JLabel("User:");
		variableUser.setFont(new Font("Dialog", Font.BOLD, 14));
		variableUser.setForeground(new Color(0, 0, 139));
		variableUser.setBounds(58, 70, 84, 26);
		panelOrigen.add(variableUser);
		
		JLabel label = new JLabel(" " + Constantes.user);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(new Color(0, 0, 139));
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(152, 70, 132, 26);
		panelOrigen.add(label);
		
		JLabel lblNoDisponeDe = new JLabel("No dispone de tiempo de conexion!");
		lblNoDisponeDe.setForeground(new Color(0, 0, 139));
		lblNoDisponeDe.setFont(new Font("Dialog", Font.BOLD, 14));
		lblNoDisponeDe.setBounds(58, 121, 266, 26);
		panelOrigen.add(lblNoDisponeDe);

		JButton botonVolver = new JButton("Volver");
		botonVolver.setBackground(Color.WHITE);
		botonVolver.setFont(new Font("Dialog", Font.BOLD, 12));
		botonVolver.setBounds(58, 175, 95, 26);
		panelOrigen.add(botonVolver);

		botonVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}
		});

		JLabel lblNewLabel = new JLabel("Vortex\u2122");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(330, 302, 66, 20);
		panelOrigen.add(lblNewLabel);
		
	}
}
