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
import vortex.modelos.Socio;

public class PanelAdmin_DarConexion extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelAdmin_DarConexion frame2;
	private JPanel contentPane;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdmin_DarConexion frame5 = new PanelAdmin_DarConexion();
					frame5.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelAdmin_DarConexion() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		
		int inicioalto=alto/4;
		int inicioancho=ancho/4;
		ancho = ancho / 4;
		alto = alto / 2;

		setTitle(" Vortex Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, ancho, alto);
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

		JLabel lblUsuarios = new JLabel("Usuarios:");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsuarios.setBounds(40, 70, 111, 29);
		contentPane.add(lblUsuarios);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(161, 76, 123, 20);

		Vector<Socio> socios = bd.ver_socios();

		for (int i = 0; i < socios.size(); i++)
			comboBox.addItem(socios.get(i).getUsuario());

		// comboBox.addItem(bd.ver_socios().get(1));
		contentPane.add(comboBox);
		
		JLabel lblTiempo = new JLabel("Tiempo:");
		lblTiempo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTiempo.setForeground(Color.WHITE);
		lblTiempo.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTiempo.setBounds(40, 122, 111, 29);
		contentPane.add(lblTiempo);

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

		JLabel label_1 = new JLabel(" ");
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
				int tiempo = Integer.parseInt(textField.getText());
				label_1.setText(" " + Constantes.precio(tiempo) + "€");
			}

		});

		JLabel lblActualizarT = new JLabel("Actualizar tiempo del socio?");
		lblActualizarT.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarT.setForeground(Color.WHITE);
		lblActualizarT.setFont(new Font("Dialog", Font.BOLD, 11));
		lblActualizarT.setBounds(114, 246, 273, 29);
		contentPane.add(lblActualizarT);

		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnActualizar.setBounds(275, 299, 113, 23);
		contentPane.add(btnActualizar);

		btnActualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int tiempo = Integer.parseInt(textField.getText());
				String seleccionCombo = (String) comboBox.getSelectedItem();
				// System.out.println(seleccionCombo);
				int filas = bd.updateMinutos(seleccionCombo, tiempo+Constantes.minutos);
				switch (filas) {
				case 1:
					Constantes.cajaAdmin += Constantes.precio(tiempo);
					PanelAdmin frame2 = new PanelAdmin();
					frame2.setVisible(true);
					dispose();
					System.out.println("OK");
					break;
				case 0:
					System.out.println("El usuario no existe");
					break;
				case -1:
					System.out.println("Problemas tecnicos");
					break;
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
				PanelAdmin frame2 = new PanelAdmin();
				frame2.setVisible(true);
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
