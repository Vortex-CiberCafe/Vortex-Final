package ventanas;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Cargando extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected static Cargando frame2;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cargando frame2 = new Cargando();
					frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Cargando() {
		setTitle("Login de Duran");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(144, 230, 111, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblCargando = new JLabel("Bienvenido!");
		lblCargando.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblCargando.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargando.setForeground(Color.WHITE);
		lblCargando.setBounds(144, 148, 111, 38);
		contentPane.add(lblCargando);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnCerrarSesion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode()==KeyEvent.VK_ENTER){
					Login frame = new Login();
					frame.setVisible(true);
					dispose();
				}
			}
		});
		btnCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login frame = new Login();
				frame.setVisible(true);
				dispose();
			}
		});
		btnCerrarSesion.setForeground(Color.RED);
		btnCerrarSesion.setBounds(253, 11, 129, 23);
		contentPane.add(btnCerrarSesion);
		
	}
}
