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
import javax.swing.border.LineBorder;

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
		setTitle("Vortex");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Continuar");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(144, 230, 111, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblCargando = new JLabel("Bienvenido:");
		lblCargando.setFont(new Font("Dialog", Font.BOLD, 14));
		lblCargando.setHorizontalAlignment(SwingConstants.CENTER);
		lblCargando.setForeground(Color.WHITE);
		lblCargando.setBounds(75, 155, 111, 29);
		contentPane.add(lblCargando);
		
		JButton btnCerrarSesion = new JButton("Cerrar Sesion");
		btnCerrarSesion.setFont(new Font("Dialog", Font.BOLD, 12));
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(190, 159, 111, 23);
		contentPane.add(lblNewLabel);
		btnCerrarSesion.setForeground(Color.RED);
		btnCerrarSesion.setBounds(269, 11, 113, 23);
		contentPane.add(btnCerrarSesion);
		
		JLabel lblVortex = new JLabel("Vortex\u2122");
		lblVortex.setForeground(Color.RED);
		lblVortex.setFont(new Font("Dialog", Font.BOLD, 15));
		lblVortex.setBounds(315, 339, 67, 23);
		contentPane.add(lblVortex);
		
	}
}
