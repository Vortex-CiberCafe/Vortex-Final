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

import vortex.bbdd.BD_Vortex;
import vortex.modelos.Productos;

public class PanelDependiente_PedirProductos extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelDependiente_PedirProductos frame15;
	private JPanel contentPane;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDependiente_PedirProductos frame15 = new PanelDependiente_PedirProductos();
					frame15.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelDependiente_PedirProductos() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		int inicioalto = alto / 4;
		int inicioancho = ancho / 3;
		ancho = ancho / 4;
		alto = alto / 2;

		setTitle(" Vortex Admin - Pedir Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, 475, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* Icono Ventana */
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\coffeeV.png"));

		/* Se recorre la base de datos, mete los productos en un vector y los enseña */
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

		// comboBox.addItem(bd.ver_productos().get(1));

		contentPane.add(comboBox);

		/* Cantidad de productos a pedir*/
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setHorizontalAlignment(SwingConstants.CENTER);
		lblCantidad.setForeground(Color.WHITE);
		lblCantidad.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCantidad.setBounds(40, 118, 111, 29);
		contentPane.add(lblCantidad);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(161, 124, 123, 20);
		contentPane.add(textField_1);

		JLabel lblDeseaPedirEsta = new JLabel("Desea pedir esta cantidad?");
		lblDeseaPedirEsta.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeseaPedirEsta.setForeground(Color.WHITE);
		lblDeseaPedirEsta.setFont(new Font("Dialog", Font.BOLD, 11));
		lblDeseaPedirEsta.setBounds(139, 178, 273, 29);
		contentPane.add(lblDeseaPedirEsta);

		/* Actualiza la base de datos con la cantidad del producto seleccionado */
		JButton btnCobrar = new JButton("Pedir");
		btnCobrar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCobrar.setBounds(299, 223, 113, 23);
		contentPane.add(btnCobrar);

		btnCobrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int cantidad = Integer.parseInt(textField_1.getText());
				String seleccionCombo = (String) comboBox.getSelectedItem();
				int filas = bd.pedirProductos(bd.verCodProducto(seleccionCombo), cantidad);
				switch (filas) {
				case 1:
					PanelDependiente frame13 = new PanelDependiente();
					frame13.setVisible(true);
					dispose();
					break;
				case 0:
					System.out.println("Error");
					break;
				case -1:
					System.out.println("Error");
					break;
				}
			}

		});

		/* Botón para cerrar este panel y volver al Panel Dependiente */
		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVolver.setBounds(299, 267, 113, 23);
		contentPane.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelDependiente frame13 = new PanelDependiente();
				frame13.setVisible(true);
				dispose();
			}

		});

		/* Trade Mark Vortex */
		JLabel label = new JLabel("Vortex\u2122");
		label.setForeground(Color.RED);
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(390, 401, 67, 23);
		contentPane.add(label);

	}
}
