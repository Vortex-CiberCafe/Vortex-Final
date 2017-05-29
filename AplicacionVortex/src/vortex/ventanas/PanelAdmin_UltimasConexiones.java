package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vortex.bbdd.BD_Vortex;
import vortex.modelos.Socio;

public class PanelAdmin_UltimasConexiones extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelAdmin_UltimasConexiones frame2;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdmin_UltimasConexiones frame6 = new PanelAdmin_UltimasConexiones();
					frame6.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelAdmin_UltimasConexiones() {
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
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\logo.png"));

		JLabel lblUsuarios = new JLabel("Usuarios:");
		lblUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsuarios.setBounds(60, 70, 111, 29);
		contentPane.add(lblUsuarios);

		JLabel label_1 = new JLabel(" ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(221, 162, 186, 29);
		contentPane.add(label_1);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(181, 76, 123, 20);

		Vector<Socio> socios = bd.ver_socios();

		for (int i = 0; i < socios.size(); i++)
			comboBox.addItem(socios.get(i).getUsuario());

		// comboBox.addItem(bd.ver_socios().get(1));
		contentPane.add(comboBox);

		JButton btnComprobarConexion = new JButton("Comprobar Conexion");
		btnComprobarConexion.setFont(new Font("Dialog", Font.BOLD, 10));
		btnComprobarConexion.setBounds(181, 118, 151, 23);
		contentPane.add(btnComprobarConexion);

		btnComprobarConexion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * Funcion que nos devuelve la ultima conexion del socio
				 * 
				 */

				String seleccionCombo = (String) comboBox.getSelectedItem();
				// System.out.println(seleccionCombo);
				LocalDate UltimaConexion = bd.ver_ultimaConexion(seleccionCombo);

				if (UltimaConexion == null)
					label_1.setText("Error");
				else
					label_1.setText(UltimaConexion.toString());

			}

		});

		JLabel lblUltima = new JLabel("Ultima Conexion:");
		lblUltima.setHorizontalAlignment(SwingConstants.LEFT);
		lblUltima.setForeground(Color.WHITE);
		lblUltima.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUltima.setBounds(60, 162, 137, 29);
		contentPane.add(lblUltima);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVolver.setBounds(275, 220, 113, 23);
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
