package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 860, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(10, 207, 265, 97);
		contentPane.add(textArea);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(10, 333, 265, 97);
		contentPane.add(btnNewButton);

		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setBounds(318, 13, 516, 417);
		contentPane.add(textArea_1);

		JTextArea txtrProjektMbi = new JTextArea();
		txtrProjektMbi.setEditable(false);
		txtrProjektMbi.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrProjektMbi.setLineWrap(true);
		txtrProjektMbi
				.setText("      Projekt MBI\r\n  Nussinov Algorithm\r\n\r\nAutorzy:\r\nOlga Ku\u017Cmi\u0144ska\r\nMicha\u0142 Uziak\r\nTomasz Adamiec");
		txtrProjektMbi.setBounds(10, 11, 265, 185);
		contentPane.add(txtrProjektMbi);
	}
}
