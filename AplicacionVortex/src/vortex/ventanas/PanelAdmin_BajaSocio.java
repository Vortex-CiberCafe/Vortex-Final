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

public class PanelAdmin_BajaSocio extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelAdmin_BajaSocio frame2;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdmin_BajaSocio frame4 = new PanelAdmin_BajaSocio();
					frame4.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelAdmin_BajaSocio() {
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

		JLabel lblEstaSeguroDe = new JLabel("Esta seguro de que desea eliminar a este usuario?");
		lblEstaSeguroDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblEstaSeguroDe.setForeground(Color.WHITE);
		lblEstaSeguroDe.setFont(new Font("Dialog", Font.BOLD, 11));
		lblEstaSeguroDe.setBounds(71, 141, 357, 29);
		contentPane.add(lblEstaSeguroDe);

		JButton btnEliminarSocio = new JButton("Eliminar Socio");
		btnEliminarSocio.setFont(new Font("Dialog", Font.BOLD, 11));
		btnEliminarSocio.setBounds(276, 194, 113, 23);
		contentPane.add(btnEliminarSocio);

		btnEliminarSocio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String seleccionCombo = (String) comboBox.getSelectedItem();
				System.out.println(seleccionCombo);
				int filas = bd.bajaSocio(seleccionCombo);
				switch (filas) {
				case 1:
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
		btnVolver.setBounds(276, 232, 113, 23);
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
