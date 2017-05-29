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

public class PanelDependiente extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static PanelDependiente frame2;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelDependiente frame13 = new PanelDependiente();
					frame13.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	public PanelDependiente() {
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

		JButton btnCobrar = new JButton("Cobrar");
		btnCobrar.setForeground(Color.BLACK);
		btnCobrar.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCobrar.setBounds(60, 144, 146, 23);
		contentPane.add(btnCobrar);

		btnCobrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelDependiente_Cobrar frame14 = new PanelDependiente_Cobrar();
				frame14.setVisible(true);
				dispose();
			}

		});

		JButton btnPedirProductos = new JButton("Pedir Productos");
		btnPedirProductos.setForeground(Color.BLACK);
		btnPedirProductos.setFont(new Font("Dialog", Font.BOLD, 11));
		btnPedirProductos.setBounds(247, 144, 146, 23);
		contentPane.add(btnPedirProductos);

		btnPedirProductos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelDependiente_PedirProductos frame15 = new PanelDependiente_PedirProductos();
				frame15.setVisible(true);
				dispose();
			}

		});

		JButton btnStock = new JButton("Comprobar Stock");
		btnStock.setForeground(Color.BLACK);
		btnStock.setFont(new Font("Dialog", Font.BOLD, 11));
		btnStock.setBounds(60, 197, 146, 23);
		contentPane.add(btnStock);

		btnStock.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelDependiente_ComprobarStock frame16 = new PanelDependiente_ComprobarStock();
				frame16.setVisible(true);
				dispose();
			}

		});

		JButton btnCaja = new JButton("Cerrar Caja");
		btnCaja.setForeground(Color.BLACK);
		btnCaja.setFont(new Font("Dialog", Font.BOLD, 11));
		btnCaja.setBounds(247, 197, 146, 23);
		contentPane.add(btnCaja);

		btnCaja.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelDependiente_CerrarCaja frame17 = new PanelDependiente_CerrarCaja();
				frame17.setVisible(true);
				dispose();
			}

		});

		JButton btnNuevoProducto = new JButton("Nuevo Producto");
		btnNuevoProducto.setForeground(Color.BLACK);
		btnNuevoProducto.setFont(new Font("Dialog", Font.BOLD, 11));
		btnNuevoProducto.setBounds(60, 246, 146, 23);
		contentPane.add(btnNuevoProducto);

		btnNuevoProducto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PanelDependiente_NuevoProducto frame20 = new PanelDependiente_NuevoProducto();
				frame20.setVisible(true);
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
