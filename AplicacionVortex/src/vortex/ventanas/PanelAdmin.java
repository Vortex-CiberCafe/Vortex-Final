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

		int alto= (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
		int ancho= (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
		
		int inicioalto=alto/4;
		int inicioancho=ancho/3;
		ancho=ancho/4;
		alto=alto/2;
		setTitle("Vortex Admin");
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
		label.setBounds(40, 70, 111, 29);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(Constantes.user);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Dialog", Font.BOLD, 14));
		label_1.setBounds(150, 70, 111, 29);
		contentPane.add(label_1);

		JButton btnDarAltaSocio = new JButton("Dar Alta Socio");
		btnDarAltaSocio.setForeground(Color.BLACK);
		btnDarAltaSocio.setFont(new Font("Dialog", Font.BOLD, 11));
		btnDarAltaSocio.setBounds(60, 144, 146, 23);
		contentPane.add(btnDarAltaSocio);

		btnDarAltaSocio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelAdmin_AltaSocio frame3 = new PanelAdmin_AltaSocio();
				frame3.setVisible(true);
				dispose();
			}

		});

		JButton btnDarBajaSocio = new JButton("Dar Baja Socio");
		btnDarBajaSocio.setForeground(Color.BLACK);
		btnDarBajaSocio.setFont(new Font("Dialog", Font.BOLD, 11));
		btnDarBajaSocio.setBounds(246, 144, 146, 23);
		contentPane.add(btnDarBajaSocio);

		btnDarBajaSocio.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelAdmin_BajaSocio frame4 = new PanelAdmin_BajaSocio();
				frame4.setVisible(true);
				dispose();
			}

		});

		JButton btnDarConexiones = new JButton("Dar Conexion");
		btnDarConexiones.setForeground(Color.BLACK);
		btnDarConexiones.setFont(new Font("Dialog", Font.BOLD, 11));
		btnDarConexiones.setBounds(60, 197, 145, 23);
		contentPane.add(btnDarConexiones);
		
		btnDarConexiones.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelAdmin_DarConexion frame5 = new PanelAdmin_DarConexion();
				frame5.setVisible(true);
				dispose();
			}

		});

		JButton btnLastConnects = new JButton("Ultimas Conexiones");
		btnLastConnects.setForeground(Color.BLACK);
		btnLastConnects.setFont(new Font("Dialog", Font.BOLD, 11));
		btnLastConnects.setBounds(246, 197, 146, 23);
		contentPane.add(btnLastConnects);
		
		btnLastConnects.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelAdmin_UltimasConexiones frame6 = new PanelAdmin_UltimasConexiones();
				frame6.setVisible(true);
				dispose();
			}

		});
		
		JButton btnComprobarTiempos = new JButton("Ver Tiempos");
		btnComprobarTiempos.setForeground(Color.BLACK);
		btnComprobarTiempos.setFont(new Font("Dialog", Font.BOLD, 11));
		btnComprobarTiempos.setBounds(60, 251, 146, 23);
		contentPane.add(btnComprobarTiempos);
		
		btnComprobarTiempos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelAdmin_VerTiempos frame7 = new PanelAdmin_VerTiempos();
				frame7.setVisible(true);
				dispose();
			}

		});

		JButton btnCerrarCaja = new JButton("Cerrar Caja");
		btnCerrarCaja.setForeground(Color.BLACK);
		btnCerrarCaja.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCerrarCaja.setBounds(246, 250, 146, 23);
		contentPane.add(btnCerrarCaja);
		
		btnCerrarCaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PanelAdmin_CerrarCaja frame8 = new PanelAdmin_CerrarCaja();
				frame8.setVisible(true);
				dispose();
			}

		});

		JLabel label_2 = new JLabel("Vortex\u2122");
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Dialog", Font.BOLD, 15));
		label_2.setBounds(390, 401, 67, 23);
		contentPane.add(label_2);

	}
}
