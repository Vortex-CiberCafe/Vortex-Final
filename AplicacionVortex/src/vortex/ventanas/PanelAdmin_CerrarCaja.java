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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vortex.Constantes;
import vortex.bbdd.BD_Vortex;

public class PanelAdmin_CerrarCaja extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelAdmin_CerrarCaja frame2;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdmin_CerrarCaja frame8 = new PanelAdmin_CerrarCaja();
					frame8.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelAdmin_CerrarCaja() {
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

		JLabel lblUsuarios = new JLabel("Caja:");
		lblUsuarios.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuarios.setForeground(Color.WHITE);
		lblUsuarios.setFont(new Font("Dialog", Font.BOLD, 14));
		lblUsuarios.setBounds(40, 70, 111, 29);
		contentPane.add(lblUsuarios);

		JLabel label_1 = new JLabel(" " + Constantes.cajaAdmin + "�");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(161, 70, 131, 29);
		contentPane.add(label_1);

		JLabel lblActualizarT = new JLabel("Esta seguro de que desea cerrar la caja?");
		lblActualizarT.setHorizontalAlignment(SwingConstants.CENTER);
		lblActualizarT.setForeground(Color.WHITE);
		lblActualizarT.setFont(new Font("Dialog", Font.BOLD, 11));
		lblActualizarT.setBounds(110, 125, 273, 29);
		contentPane.add(lblActualizarT);

		JButton btnCerrarCaja = new JButton("Cerrar Caja");
		btnCerrarCaja.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCerrarCaja.setBounds(271, 178, 113, 23);
		contentPane.add(btnCerrarCaja);

		btnCerrarCaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Constantes.cajaTotal = Constantes.cajaTotal + Constantes.cajaAdmin;
				Constantes.cajaAdmin = 0;
				PanelAdmin frame2 = new PanelAdmin();
				frame2.setVisible(true);
				dispose();
			}

		});

		JButton btnVolver = new JButton("Volver");
		btnVolver.setForeground(Color.BLACK);
		btnVolver.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVolver.setBounds(271, 220, 113, 23);
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
