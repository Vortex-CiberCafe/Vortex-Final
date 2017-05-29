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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vortex.bbdd.BD_Vortex;
import vortex.modelos.Productos;
import vortex.modelos.Socio;

public class PanelDependiente_ComprobarStock extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelDependiente_ComprobarStock frame2;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDependiente_ComprobarStock frame16 = new PanelDependiente_ComprobarStock();
					frame16.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelDependiente_ComprobarStock() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		int inicioalto = alto / 4;
		int inicioancho = ancho / 3;
		ancho = ancho / 4;
		alto = alto / 2;

		setTitle(" Vortex Dependiente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, 475, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUsuarios = new JLabel("Productos:");
		lblUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsuarios.setBounds(40, 70, 111, 29);
		contentPane.add(lblUsuarios);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(161, 76, 123, 20);

		Vector<Productos> productos = bd.ver_Productos();

		for (int i = 0; i < productos.size(); i++)
			comboBox.addItem(productos.get(i).getNombre());
		
		// comboBox.addItem(bd.ver_productos().get(1));
		contentPane.add(comboBox);

		JLabel label_1 = new JLabel(" ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(201, 162, 186, 29);
		contentPane.add(label_1);
		

		JButton btnComprobarStock = new JButton("Comprobar Stock");
		btnComprobarStock.setFont(new Font("Dialog", Font.BOLD, 10));
		btnComprobarStock.setBounds(161, 118, 151, 23);
		contentPane.add(btnComprobarStock);

		btnComprobarStock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				String seleccionCombo = (String) comboBox.getSelectedItem();
				int filas = bd.verStock(seleccionCombo);

				label_1.setText(filas + " unidades disponibles");
				switch (filas) {
				case -1:
					label_1.setText("Error");
					break;
				case -2:
					System.out.println("Problemas tecnicos");
					break;
				}

			}

		});

		JLabel lblTiempoRestante = new JLabel("Cantidad Restante:");
		lblTiempoRestante.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiempoRestante.setForeground(Color.WHITE);
		lblTiempoRestante.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTiempoRestante.setBounds(40, 162, 137, 29);
		contentPane.add(lblTiempoRestante);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVolver.setBounds(275, 220, 113, 23);
		contentPane.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelDependiente frame13 = new PanelDependiente();
				frame13.setVisible(true);
				dispose();

			}

		});

		JLabel label = new JLabel("Vortex\u2122");
		label.setForeground(Color.RED);
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(390, 401, 67, 23);
		contentPane.add(label);

	}
}
