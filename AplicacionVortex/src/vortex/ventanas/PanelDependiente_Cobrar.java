package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vortex.Constantes;
import vortex.bbdd.BD_Vortex;
import vortex.modelos.Productos;
import vortex.modelos.Socio;

public class PanelDependiente_Cobrar extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelDependiente_Cobrar frame2;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDependiente_Cobrar frame13 = new PanelDependiente_Cobrar();
					frame13.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelDependiente_Cobrar() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");
		double precio = 0.0;

		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		int inicioalto = alto / 4;
		int inicioancho = ancho / 4;
		ancho = ancho / 4;
		alto = alto / 2;

		setTitle(" Vortex Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, 517, 522);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("Cerrar Sesion");
		button.setForeground(Color.RED);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(344, 11, 113, 23);
		contentPane.add(button);

		JLabel lblProductos = new JLabel("Productos:");
		lblProductos.setHorizontalAlignment(SwingConstants.CENTER);
		lblProductos.setForeground(Color.WHITE);
		lblProductos.setFont(new Font("Dialog", Font.BOLD, 14));
		lblProductos.setBounds(40, 70, 111, 29);
		contentPane.add(lblProductos);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(161, 76, 123, 20);

		Vector<Productos> productos = bd.ver_Productos();

		for (int i = 0; i < productos.size(); i++)
			comboBox.addItem(productos.get(i).getNombre());

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(307, 76, 123, 20);
		contentPane.add(textField_1);

		// comboBox.addItem(bd.ver_productos().get(1));

		contentPane.add(comboBox);

		JLabel lblCantidad = new JLabel("Tiempo:");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCantidad.setBounds(40, 122, 111, 29);
		contentPane.add(lblCantidad);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(161, 28, 123, 20);

		Vector<Socio> socios = bd.ver_socios();

		for (int i = 0; i < socios.size(); i++)
			comboBox_1.addItem(socios.get(i).getUsuario());

		contentPane.add(comboBox_1);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(161, 128, 123, 20);
		contentPane.add(textField);

		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setForeground(Color.WHITE);
		lblPrecio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblPrecio.setBounds(40, 206, 111, 29);
		contentPane.add(lblPrecio);

		JLabel label_1 = new JLabel(precio + "€");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(163, 206, 111, 29);
		contentPane.add(label_1);

		JButton btnComprobarPrecio = new JButton("Comprobar Precio");
		btnComprobarPrecio.setFont(new Font("Dialog", Font.BOLD, 10));
		btnComprobarPrecio.setBounds(161, 172, 123, 23);
		contentPane.add(btnComprobarPrecio);

		btnComprobarPrecio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cantidad = Integer.parseInt(textField_1.getText());
				// int cantidad = 1;
				String seleccionCombo = (String) comboBox.getSelectedItem();
				// System.out.println(seleccionCombo);

				double precio = bd.cobrar(seleccionCombo, cantidad);
				if (precio == -1) {
					System.out.println("Problemas tecnicos");
				} else {
					label_1.setText(precio + "€");
				}
			}

		});

		JLabel lblDeseaCobrar = new JLabel("Desea cobrar?");
		lblDeseaCobrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeseaCobrar.setForeground(Color.WHITE);
		lblDeseaCobrar.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDeseaCobrar.setBounds(114, 246, 273, 29);
		contentPane.add(lblDeseaCobrar);

		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCobrar.setBounds(275, 299, 113, 23);
		contentPane.add(btnCobrar);

		btnCobrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cantidad = Integer.parseInt(textField_1.getText());
				String seleccionCombo = (String) comboBox.getSelectedItem();
				// System.out.println(seleccionCombo);

				double precio = bd.cobrar(seleccionCombo, cantidad);
				if (precio == -1) {
					System.out.println("Problemas tecnicos");
				} else {
					String seleccionSocio = (String) comboBox_1.getSelectedItem();
					int fila = bd.anadirCompra(bd.verCodSocio(seleccionSocio), bd.verCodProducto(seleccionCombo), cantidad);
					int numProductos = bd.restarProductos(bd.verCodProducto(seleccionCombo), cantidad);
					Constantes.cajaDependiente += precio;

					PanelDependiente frame12 = new PanelDependiente();
					frame12.setVisible(true);
					dispose();
				}

			}

		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVolver.setBounds(275, 337, 113, 23);
		contentPane.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelDependiente frame12 = new PanelDependiente();
				frame12.setVisible(true);
				dispose();
			}

		});

		JLabel label = new JLabel("Vortex\u2122");
		label.setForeground(Color.RED);
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(390, 401, 67, 23);
		contentPane.add(label);

		JLabel lblSocio = new JLabel("Socio");
		lblSocio.setHorizontalAlignment(SwingConstants.CENTER);
		lblSocio.setForeground(Color.WHITE);
		lblSocio.setFont(new Font("Dialog", Font.BOLD, 14));
		lblSocio.setBounds(40, 22, 111, 29);
		contentPane.add(lblSocio);

		JLabel lblCantidad_1 = new JLabel("Cantidad:");
		lblCantidad_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad_1.setForeground(Color.WHITE);
		lblCantidad_1.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCantidad_1.setBounds(310, 45, 111, 29);
		contentPane.add(lblCantidad_1);

	}
}
