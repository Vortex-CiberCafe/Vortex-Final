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
import vortex.modelos.Socio;

public class PanelAdmin_VerTiempos extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelAdmin_VerTiempos frame7;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdmin_VerTiempos frame7 = new PanelAdmin_VerTiempos();
					frame7.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelAdmin_VerTiempos() {
		BD_Vortex bd = new BD_Vortex("mysql-properties.xml");

		int alto = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		int inicioalto = alto / 4;
		int inicioancho = ancho / 3;
		ancho = ancho / 4;
		alto = alto / 2;

		setTitle(" Vortex Admin - Ver Tiempos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(inicioancho, inicioalto, 475, 463);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		/* Icono Ventana */
		setIconImage(Toolkit.getDefaultToolkit().getImage("icon\\coffeeV.png"));

		/* Se recorre la base de datos, mete los socios en un vector y los enseña */
		JLabel lblUsuarios = new JLabel("Usuarios:");
		lblUsuarios.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsuarios.setBounds(60, 70, 111, 29);
		contentPane.add(lblUsuarios);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(181, 76, 123, 20);

		Vector<Socio> socios = bd.ver_socios();

		JLabel label_1 = new JLabel(" ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(221, 162, 186, 29);
		contentPane.add(label_1);

		for (int i = 0; i < socios.size(); i++)
			comboBox.addItem(socios.get(i).getUsuario());

		// comboBox.addItem(bd.ver_socios().get(1));
		contentPane.add(comboBox);

		/* Muestra la cantidad de minutos restantes de dicho socio */
		JButton btnComprobarTiempo = new JButton("Comprobar Tiempo");
		btnComprobarTiempo.setFont(new Font("Dialog", Font.BOLD, 10));
		btnComprobarTiempo.setBounds(181, 118, 151, 23);
		contentPane.add(btnComprobarTiempo);

		btnComprobarTiempo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * Funcion que nos devuelve el tiempo restante del socio
				 * 
				 */
				String seleccionCombo = (String) comboBox.getSelectedItem();
				int filas = bd.ver_Tiempos(seleccionCombo);

				label_1.setText(filas + " minutos disponibles");
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

		JLabel lblTiempoRestante = new JLabel("Tiempo restante:");
		lblTiempoRestante.setHorizontalAlignment(SwingConstants.LEFT);
		lblTiempoRestante.setForeground(Color.WHITE);
		lblTiempoRestante.setFont(new Font("Dialog", Font.BOLD, 14));
		lblTiempoRestante.setBounds(60, 162, 137, 29);
		contentPane.add(lblTiempoRestante);

		/* Botón para cerrar la sesión y volver al login */
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

		/* Trade Mark Vortex */
		JLabel label = new JLabel("Vortex\u2122");
		label.setForeground(Color.RED);
		label.setFont(new Font("Dialog", Font.BOLD, 15));
		label.setBounds(390, 401, 67, 23);
		contentPane.add(label);

	}
}
