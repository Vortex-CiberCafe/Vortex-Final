package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
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

import vortex.Constantes;
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
		
		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		
		int inicioalto=alto/4;
		int inicioancho=ancho/3;
		ancho = ancho / 4;
		alto = alto / 2;

		/* Titulo de la ventana Java */

		setTitle("Login de Duran");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, ancho, alto);

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
		variableUser.setBounds(100, 70, 95, 26);
		panelOrigen.add(variableUser);

		/* Input User */

		entradaUser = new JTextField();
		entradaUser.setFont(new Font("Dialog", Font.PLAIN, 14));
		entradaUser.setForeground(Color.BLACK);
		entradaUser.setBounds(213, 73, 147, 20);
		panelOrigen.add(entradaUser);
		entradaUser.setColumns(10);

		/* Variable Password */

		JLabel variablePass = new JLabel("Password:");
		variablePass.setFont(new Font("Dialog", Font.BOLD, 14));
		variablePass.setForeground(new Color(0, 0, 128));
		variablePass.setBounds(100, 107, 103, 26);
		panelOrigen.add(variablePass);

		/* Input Password */

		entradaPass = new JPasswordField();
		entradaPass.setBounds(213, 110, 147, 20);
		panelOrigen.add(entradaPass);
		entradaPass.setFont(new Font("Dialog", Font.PLAIN, 14));

		JLabel label = new JLabel();
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("Dialog", Font.BOLD, 13));
		label.setBounds(100, 213, 260, 66);
		panelOrigen.add(label);
		label.setVisible(false);

		TypeUser = new JComboBox();
		TypeUser.setModel(new DefaultComboBoxModel(new String[] { "Admin", "Socio", "Dependiente" }));
		TypeUser.setMaximumRowCount(3);
		TypeUser.setBounds(274, 141, 86, 20);
		panelOrigen.add(TypeUser);
		
		/* Boton Login */
		
		JButton botonLogin = new JButton("Login");
		botonLogin.setBackground(Color.WHITE);
		botonLogin.setFont(new Font("Dialog", Font.BOLD, 12));
		botonLogin.setBounds(100, 164, 95, 26);
		panelOrigen.add(botonLogin);

		botonLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String seleccionCombo = (String) TypeUser.getSelectedItem();

				switch (seleccionCombo) {
				case "Admin":
					int filas = bd.loginAdmin(entradaUser.getText(), entradaPass.getText());
					switch (filas) {
					case 1:
						System.out.println("\nConectado como Admin");
						Constantes.user = entradaUser.getText();
						PanelAdmin frame2 = new PanelAdmin();
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
						Constantes.user = entradaUser.getText();

						PanelSocio frame8 = new PanelSocio();
						frame8.setVisible(true);
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

				case "Dependiente":
					System.out.println(new String(entradaPass.getPassword()));
					filas = bd.loginDependiente(entradaUser.getText(), entradaPass.getText());
					switch (filas) {
					case 1:
						System.out.println("\nConectado como dependiente");
						Constantes.user = entradaUser.getText();
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
		
		
		JLabel lblNewLabel = new JLabel("Vortex\u2122");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(391, 404, 66, 20);
		panelOrigen.add(lblNewLabel);
	}

}
