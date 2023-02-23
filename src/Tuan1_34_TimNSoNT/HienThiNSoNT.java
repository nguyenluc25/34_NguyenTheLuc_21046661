package Tuan1_34_TimNSoNT;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class HienThiNSoNT extends JFrame implements ActionListener {
	private JTextField txtNhap;
	private JButton btnGenerate;
	private JTextArea taPrime;

	public HienThiNSoNT() {
		// TODO Auto-generated constructor stub
		setTitle("Primes");
		setSize(400, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		createGUI();

		btnGenerate.addActionListener(this);
	}

	public static void main(String[] args) {
		new HienThiNSoNT().setVisible(true);
	}

	private void createGUI() {
		setLayout(null);

		add(txtNhap = new JTextField());
		txtNhap.setBounds(50, 30, 200, 30);
		add(btnGenerate = new JButton("Generate"));
		btnGenerate.setBounds(250, 30, 100, 30);

		JScrollPane sp;
		add(sp = new JScrollPane(taPrime = new JTextArea()));
		sp.setBounds(50, 70, 300, 170);
		taPrime.setEditable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		showSNT();
	}

	private void showSNT() {
		int count = 0;
		int i = 2;
		String s = "";
		if (isInt(txtNhap)) {
			int a = Integer.parseInt(txtNhap.getText());
			if (a < 0) {
				s = "Vui lòng nhập số nguyên dương";
			} else {
				while (count < a) {
					if (isPrimeNumber(i)) {
						s = s + String.valueOf(i) + "\n";
						count++;
					}
					i++;
				}
			}
		} else {
			s = "Vui lòng nhập số nguyên";
		}
		taPrime.setText(s);

	}

	private boolean isPrimeNumber(int n) {
		if (n < 2) {
			return false;
		}
		int i;
		int squareRoot = (int) Math.sqrt(n);
		for (i = 2; i <= squareRoot; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	private boolean isInt(JTextField text) {
		boolean result = true;
		try {
			Integer.parseInt(text.getText());
		} catch (NumberFormatException ex) {
			result = false;
		}
		return result;
	}
}
