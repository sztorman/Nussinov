package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import Algorithm.Nussinov;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea displayArea;
	private JTextArea imputTextArea;
	private static JButton btnMatrix = null;
	private static JButton btnPairs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		setBounds(100, 100, 1054, 625);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrProjektMbi = new JTextArea();
		txtrProjektMbi.setEditable(false);
		txtrProjektMbi.setFont(new Font("Monospaced", Font.PLAIN, 18));
		txtrProjektMbi.setLineWrap(true);
		txtrProjektMbi
				.setText("      Projekt MBI\r\n  Nussinov Algorithm\r\n\r\nAutorzy:\r\nOlga Ku\u017Cmi\u0144ska\r\nMicha\u0142 Uziak\r\nTomasz Adamiec");
		txtrProjektMbi.setBounds(10, 11, 265, 218);
		contentPane.add(txtrProjektMbi);

		imputTextArea = new JTextArea();
		imputTextArea.setBounds(10, 240, 265, 146);
		contentPane.add(imputTextArea);

		displayArea = new JTextArea();
		displayArea.setEditable(false);
		displayArea.setBounds(285, 13, 743, 562);
		contentPane.add(displayArea);

		btnPairs = new JButton("Poka\u017C pary");
		btnPairs.setBounds(10, 400, 265, 80);
		contentPane.add(btnPairs);
		btnPairs.addActionListener(this);

		btnMatrix = new JButton("Poka\u017C macierz");
		btnMatrix.setBounds(10, 495, 265, 80);
		contentPane.add(btnMatrix);
		btnMatrix.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		String input;
		if (button == btnMatrix) {
			input  = imputTextArea.getText();
			Nussinov nussinov = new Nussinov(input);
			int[][] matrix = nussinov.getMatrix();
			displayArea.setText(nussinov.getMatrixAsText(matrix));
		} if (button == btnPairs) {
			input  = imputTextArea.getText();
			Nussinov nussinov = new Nussinov(input);
			Map<Integer, Integer> map = nussinov.getMap();
			displayArea.setText(map.toString());
		}
	}
}
