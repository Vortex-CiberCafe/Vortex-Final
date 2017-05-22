package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import vortex.bbdd.BD_Vortex;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static Login frame;
	protected int tipoUser;
	private JPanel panelOrigen;
	private JTextField entradaUser;
	private JPasswordField entradaPass;
	private JComboBox TypeUser;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Login() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");
		/* Titulo de la ventana Java */

		setTitle("Login de Duran");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);

		/* Panel Login Java (Principal) */

		panelOrigen = new JPanel();
		panelOrigen.setForeground(new Color(0, 0, 0));
		panelOrigen.setBackground(new Color(70, 130, 180));
		panelOrigen.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panelOrigen);
		panelOrigen.setLayout(null);

		/* Variable User (panelOrigen) */

		JLabel variableUser = new JLabel("User:");
		variableUser.setFont(new Font("Dialog", Font.BOLD, 14));
		variableUser.setForeground(new Color(0, 0, 139));
		variableUser.setBounds(65, 39, 95, 26);
		panelOrigen.add(variableUser);

		/* Input User (panelOrigen) */

		entradaUser = new JTextField();
		entradaUser.setFont(new Font("Dialog", Font.PLAIN, 14));
		entradaUser.setForeground(Color.BLACK);
		entradaUser.setBounds(178, 42, 147, 20);
		panelOrigen.add(entradaUser);
		entradaUser.setColumns(10);

		/* Variable Password (panelOrigen) */

		JLabel variablePass = new JLabel("Password:");
		variablePass.setFont(new Font("Dialog", Font.BOLD, 14));
		variablePass.setForeground(new Color(0, 0, 128));
		variablePass.setBounds(65, 76, 103, 26);
		panelOrigen.add(variablePass);

		/* Input Password (panelOrigen) */

		entradaPass = new JPasswordField();
		entradaPass.setBounds(178, 79, 147, 20);
		panelOrigen.add(entradaPass);
		entradaPass.setFont(new Font("Dialog", Font.PLAIN, 14));

		JLabel label = new JLabel();
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setBounds(65, 182, 260, 66);
		panelOrigen.add(label);
		label.setVisible(false);

		/* Boton Login */

		JButton botonLogin = new JButton("Login");
		botonLogin.setBackground(Color.WHITE);
		botonLogin.setFont(new Font("Dialog", Font.BOLD, 12));
		botonLogin.setBounds(65, 133, 95, 26);
		panelOrigen.add(botonLogin);

		JLabel lblNewLabel = new JLabel("Vortex\u2122");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(308, 331, 66, 20);
		panelOrigen.add(lblNewLabel);

		TypeUser = new JComboBox();
		TypeUser.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Socio", "Dependiente" }));
		TypeUser.setMaximumRowCount(3);
		TypeUser.setBounds(239, 110, 86, 20);
		panelOrigen.add(TypeUser);

		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String seleccionCombo = (String) TypeUser.getSelectedItem();

				switch (seleccionCombo) {
				case "Admin":
					int filas = bd.loginAdmin(entradaUser.getText(), entradaPass.getText());
					switch (filas) {
					case 1:
						System.out.println("\nConectado como Admin");
						Cargando frame2 = new Cargando();
						frame2.setVisible(true);
						dispose();
						break;
					case 0:
						label.setText("ERROR. Datos incorrectos!");
						label.setVisible(true);
						break;
					case -1:
						System.out.println("\nNo estas conectado");
						break;
					}
					break;

				case "Socio":
					filas = bd.loginSocio(entradaUser.getText(), entradaPass.getText());
					switch (filas) {
					case 1:
						System.out.println("\nConectado como socio");

						break;
					case 0:
						label.setText("ERROR. Datos incorrectos!");
						label.setVisible(true);
						break;
					case -1:
						System.out.println("\nNo estas conectado");
						break;
					}
					break;

				case "Dependiente":
					System.out.println(new String(entradaPass.getPassword()));
					filas = bd.loginDependiente(entradaUser.getText(), entradaPass.getText());
					switch (filas) {
					case 1:
						System.out.println("\nConectado como dependiente");
						break;
					case 0:
						label.setText("ERROR. Datos incorrectos!");
						label.setVisible(true);
						break;
					case -1:
						System.out.println("\nNo estas conectado");
						break;
					}
					break;

				}

			}
		});
		botonLogin.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				/*
				 * String usuario = "duran"; char[] password =
				 * entradaPass.getPassword(); char[] correctPass = new char[] {
				 * 'e', 'n', 't', 'e', 'r' }; if
				 * (entradaUser.getText().equals(usuario) &&
				 * Arrays.equals(password, correctPass)) { if (arg0.getKeyCode()
				 * == KeyEvent.VK_ENTER) {
				 * label.setText("Login completado correctamente!"); Cargando
				 * frame2 = new Cargando(); frame2.setVisible(true); dispose();
				 * } } else { if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				 * label.setText("ERROR. Datos incorrectos!"); } }
				 * label.setVisible(true);
				 */
			}
		});
	}

}
