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
import vortex.modelos.Productos;

public class PanelDependiente_NuevoProducto extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelDependiente_NuevoProducto frame18;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDependiente_NuevoProducto frame18 = new PanelDependiente_NuevoProducto();
					frame18.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelDependiente_NuevoProducto() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		int inicioalto = alto / 4;
		int inicioancho = ancho / 3;
		ancho = ancho / 4;
		alto = alto / 2;

		setTitle(" Vortex Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, 475, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* Icono Ventana */
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\coffeeV.png"));

		JLabel lblNombre_1 = new JLabel("Nombre: ");
		lblNombre_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre_1.setForeground(Color.BLACK);
		lblNombre_1.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNombre_1.setBounds(53, 54, 75, 29);
		contentPane.add(lblNombre_1);

		textField = new JTextField();
		textField.setBounds(133, 59, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNombre = new JLabel("Tipo:");
		lblNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblNombre.setForeground(Color.BLACK);
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 11));
		lblNombre.setBounds(53, 94, 75, 29);
		contentPane.add(lblNombre);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(133, 99, 86, 20);
		contentPane.add(textField_1);

		JLabel lblDireccion = new JLabel("Precio:");
		lblDireccion.setHorizontalAlignment(SwingConstants.LEFT);
		lblDireccion.setForeground(Color.BLACK);
		lblDireccion.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDireccion.setBounds(53, 134, 75, 29);
		contentPane.add(lblDireccion);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(133, 139, 86, 20);
		contentPane.add(textField_2);

		JLabel lblTelefono = new JLabel("Cantidad:");
		lblTelefono.setHorizontalAlignment(SwingConstants.LEFT);
		lblTelefono.setForeground(Color.BLACK);
		lblTelefono.setFont(new Font("Dialog", Font.BOLD, 11));
		lblTelefono.setBounds(53, 174, 75, 29);
		contentPane.add(lblTelefono);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(133, 179, 86, 20);
		contentPane.add(textField_3);

		JButton btnDarAlta = new JButton("Dar Alta");
		btnDarAlta.setForeground(Color.BLACK);
		btnDarAlta.setFont(new Font("Dialog", Font.BOLD, 12));
		btnDarAlta.setBounds(293, 243, 113, 23);
		contentPane.add(btnDarAlta);

		btnDarAlta.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				// AQUI AÑADES LA INTRODUCCION DE DATOS A LA BBDD
				System.out.println("Nombre: " + textField.getText() + "\nTipo: " + textField_1.getText() + "\nPrecio: "
						+ textField_2.getText() + "\nCantidad: " + textField_3.getText());

				Productos producto = new Productos(textField.getText(), textField_1.getText(),
						Double.parseDouble(textField_2.getText()), Integer.parseInt(textField_3.getText()));
				// System.out.println(producto.toString());
				int filas = bd.anadir_Producto(producto);
				switch (filas) {

				case 1:
					System.out.println("Producto añadido");
					PanelDependiente frame13 = new PanelDependiente();
					frame13.setVisible(true);
					dispose();
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
		btnVolver.setBounds(293, 288, 113, 23);
		contentPane.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelDependiente frame13 = new PanelDependiente();
				frame13.setVisible(true);
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
