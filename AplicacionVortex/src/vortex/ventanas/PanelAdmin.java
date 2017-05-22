package vortex.ventanas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import vortex.Constantes;

public class PanelAdmin extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelAdmin frame2;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelAdmin frame2 = new PanelAdmin();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelAdmin() {
		setTitle("Vortex Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton button = new JButton("Cerrar Sesion");
		button.setForeground(Color.RED);
		button.setFont(new Font("Dialog", Font.BOLD, 12));
		button.setBounds(269, 11, 113, 23);
		contentPane.add(button);

		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}

		});

		JLabel label = new JLabel("Bienvenido:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Dialog", Font.BOLD, 14));
		label.setBounds(10, 43, 111, 29);
		contentPane.add(label);

		JButton btnDarAltaSocio = new JButton("Dar Alta Socio");
		btnDarAltaSocio.setForeground(Color.BLACK);
		btnDarAltaSocio.setFont(new Font("Dialog", Font.BOLD, 11));
		btnDarAltaSocio.setBounds(30, 117, 146, 23);
		contentPane.add(btnDarAltaSocio);

		btnDarAltaSocio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelAdmin_AltaSocio frame3 = new PanelAdmin_AltaSocio();
				frame3.setVisible(true);
				dispose();
			}

		});

		JButton btnDarBajaSocio = new JButton("Dar Baja Socio");
		btnDarBajaSocio.setForeground(Color.BLACK);
		btnDarBajaSocio.setFont(new Font("Dialog", Font.BOLD, 11));
		btnDarBajaSocio.setBounds(216, 117, 146, 23);
		contentPane.add(btnDarBajaSocio);

		btnDarBajaSocio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("asd");

			}

		});

		JButton btnComprobarConexiones = new JButton("Dar Conexion");
		btnComprobarConexiones.setForeground(Color.BLACK);
		btnComprobarConexiones.setFont(new Font("Dialog", Font.BOLD, 11));
		btnComprobarConexiones.setBounds(30, 170, 145, 23);
		contentPane.add(btnComprobarConexiones);

		JButton btnVerTiempos = new JButton("Ver Tiempos");
		btnVerTiempos.setForeground(Color.BLACK);
		btnVerTiempos.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVerTiempos.setBounds(30, 223, 146, 23);
		contentPane.add(btnVerTiempos);

		JButton btnVerConexiones = new JButton("Ver Conexiones");
		btnVerConexiones.setForeground(Color.BLACK);
		btnVerConexiones.setFont(new Font("Dialog", Font.BOLD, 11));
		btnVerConexiones.setBounds(216, 170, 146, 23);
		contentPane.add(btnVerConexiones);

		JButton btnCerrarCaja = new JButton("Cerrar Caja");
		btnCerrarCaja.setForeground(Color.BLACK);
		btnCerrarCaja.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCerrarCaja.setBounds(216, 223, 146, 23);
		contentPane.add(btnCerrarCaja);

		JLabel label_2 = new JLabel("Vortex\u2122");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(315, 339, 67, 23);
		contentPane.add(label_2);

		JLabel label_1 = new JLabel(Constantes.user);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(120, 43, 111, 29);
		contentPane.add(label_1);
	}
}
