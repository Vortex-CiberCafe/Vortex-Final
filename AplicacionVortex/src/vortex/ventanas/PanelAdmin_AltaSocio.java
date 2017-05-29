package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vortex.bbdd.BD_Vortex;
import vortex.modelos.Socio;

public class PanelAdmin_AltaSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelAdmin_AltaSocio frame3;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdmin_AltaSocio frame3 = new PanelAdmin_AltaSocio();
					frame3.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelAdmin_AltaSocio() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		int alto= (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho= (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		
		int inicioalto=alto/4;
		int inicioancho=ancho/3;
		ancho=ancho/4;
		alto=alto/2;

		setTitle(" Vortex Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, 475, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("DNI:");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Dialog", Font.BOLD, 11));
		label.setBounds(53, 54, 75, 29);
		contentPane.add(label);
		
				textField = new JTextField();
				textField.setBounds(133, 59, 86, 20);
				contentPane.add(textField);
				textField.setColumns(10);

		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNombre.setBounds(53, 94, 75, 29);
		contentPane.add(lblNombre);
		
				textField_1 = new JTextField();
				textField_1.setColumns(10);
				textField_1.setBounds(133, 99, 86, 20);
				contentPane.add(textField_1);

		JLabel lblDireccion = new JLabel("Direccion:");
		lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccion.setForeground(Color.BLACK);
		lblDireccion.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDireccion.setBounds(53, 134, 75, 29);
		contentPane.add(lblDireccion);
		
				textField_2 = new JTextField();
				textField_2.setColumns(10);
				textField_2.setBounds(133, 139, 86, 20);
				contentPane.add(textField_2);

		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Dialog", Font.BOLD, 11));
		lblTelefono.setBounds(53, 174, 75, 29);
		contentPane.add(lblTelefono);
		
				textField_3 = new JTextField();
				textField_3.setColumns(10);
				textField_3.setBounds(133, 179, 86, 20);
				contentPane.add(textField_3);

		JLabel lblCorreo = new JLabel("Correo:");
		lblCorreo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCorreo.setForeground(Color.BLACK);
		lblCorreo.setFont(new Font("Dialog", Font.BOLD, 11));
		lblCorreo.setBounds(53, 214, 75, 29);
		contentPane.add(lblCorreo);
		
				textField_4 = new JTextField();
				textField_4.setColumns(10);
				textField_4.setBounds(133, 219, 86, 20);
				contentPane.add(textField_4);

		JLabel lblNick = new JLabel("Nick:");
		lblNick.setHorizontalAlignment(SwingConstants.LEFT);
		lblNick.setForeground(Color.BLACK);
		lblNick.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNick.setBounds(248, 134, 67, 29);
		contentPane.add(lblNick);
		
				textField_5 = new JTextField();
				textField_5.setColumns(10);
				textField_5.setBounds(320, 139, 86, 20);
				contentPane.add(textField_5);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 11));
		lblPassword.setBounds(248, 174, 67, 29);
		contentPane.add(lblPassword);

				textField_6 = new JTextField();
				textField_6.setColumns(10);
				textField_6.setBounds(320, 179, 86, 20);
				contentPane.add(textField_6);

		JButton btnDarAlta = new JButton("Dar Alta");
		btnDarAlta.setForeground(Color.BLACK);
		btnDarAlta.setFont(new Font("Dialog", Font.BOLD, 12));
		btnDarAlta.setBounds(326, 277, 113, 23);
		contentPane.add(btnDarAlta);

		btnDarAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				// AQUI AÑADES LA INTRODUCCION DE DATOS A LA BBDD
				System.out.println("DNI: " + textField.getText() + "\nNombre: " + textField_1.getText() + "\nDireccion: " + textField_2.getText()
						+ "\nTelefono: " + textField_3.getText() + "\nCorreo: " + textField_4.getText() + "\nNick: " + textField_5.getText()
						+ "\nPassword: " + textField_6.getText());

				Socio socio = new Socio(textField.getText(), textField_4.getText(), textField_5.getText(), textField_6.getText(),
						textField_1.getText(), textField_2.getText(), textField_3.getText(), 0, LocalDate.now(), 0, LocalDate.now(), LocalDate.now());
				int filas = bd.anadir_Socio(socio);
				switch (filas) {
				case 1:
					System.out.println("\nSocio añadido");
					break;
				case 0:
					System.out.println("\nNo añadido");
					break;
				case -1:
					System.out.println("\nProblemas técnicos");
					break;

				}

			}

		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVolver.setBounds(326, 322, 113, 23);
		contentPane.add(btnVolver);
		
		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelAdmin frame2 = new PanelAdmin();
				frame2.setVisible(true);
				dispose();

			}

		});
		
		JLabel label_2 = new JLabel("Vortex\u2122");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(390, 401, 67, 23);
		contentPane.add(label_2);

	};
}
