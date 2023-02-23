package Tuan1_34_PTBac2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GiaiPTBacHai extends JFrame implements ActionListener {
	private JButton btnGiai;
	private JButton btnXoaRong;
	private JButton btnThoat;
	private JTextField txtA;
	private JTextField txtB;
	private JTextField txtC;
	private JTextField txtKQ;

	public GiaiPTBacHai() {
		// TODO Auto-generated constructor stub
		setTitle("^-^");
		setSize(500, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		craeteGUI();

		btnGiai.addActionListener(this);
		btnThoat.addActionListener(this);
		btnXoaRong.addActionListener(this);
	}

	public static void main(String[] args) {
		new GiaiPTBacHai().setVisible(true);
	}

	private void craeteGUI() {
		JPanel pNorth = new JPanel();
		this.add(pNorth, BorderLayout.NORTH);
		pNorth.add(new JLabel("Giai Phuong Trinh Bac Hai"));
		pNorth.setBackground(Color.CYAN);

		JPanel pCenter = new JPanel();
		pCenter.setLayout(null);
		this.add(pCenter, BorderLayout.CENTER);

		JLabel lblA, lblB, lblC, lblKQ;
		pCenter.add(lblA = new JLabel("Nhap a:"));
		lblA.setBounds(20, 40, 100, 30);
		pCenter.add(txtA = new JTextField());
		txtA.setBounds(120, 40, 300, 30);

		pCenter.add(lblB = new JLabel("Nhap b:"));
		lblB.setBounds(20, 90, 100, 30);
		pCenter.add(txtB = new JTextField());
		txtB.setBounds(120, 90, 300, 30);

		pCenter.add(lblC = new JLabel("Nhap c:"));
		lblC.setBounds(20, 140, 100, 30);
		pCenter.add(txtC = new JTextField());
		txtC.setBounds(120, 140, 300, 30);

		pCenter.add(lblKQ = new JLabel("Ket Qua:"));
		lblKQ.setBounds(20, 190, 100, 30);
		pCenter.add(txtKQ = new JTextField());
		txtKQ.setBounds(120, 190, 300, 30);
		txtKQ.setEditable(false);

		JPanel pSouth = new JPanel();
		this.add(pSouth, BorderLayout.SOUTH);
		pSouth.setBorder(BorderFactory.createTitledBorder("Chon tac vu"));

		pSouth.add(btnGiai = new JButton("Giai"));
		pSouth.add(btnXoaRong = new JButton("Xoa rong"));
		pSouth.add(btnThoat = new JButton("Thoat"));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnGiai)) {
			giaiPTBacHai();
		} else if (o.equals(btnThoat)) {
			System.exit(0);
		}
		else {
			txtA.setText(null);
			txtB.setText(null);
			txtC.setText(null);
		}
	}

	private void giaiPTBacHai() {
		if (isDouble(txtA) && isDouble(txtB) && isDouble(txtC)) {
			double a = Double.parseDouble(txtA.getText());
			double b = Double.parseDouble(txtB.getText());
			double c = Double.parseDouble(txtC.getText());
			if (a == 0) {
				if (b == 0) {
					txtKQ.setText("Phương trình vô nghiệm");
				} else {
					txtKQ.setText("x = " + (-c / b));
				}
				return;
			}

			double delta = b * b - 4 * a * c;
			double x1, x2;
			if (delta > 0) {
				x1 = (-b + Math.sqrt(delta)) / (2 * a);
				x2 = (-b - Math.sqrt(delta)) / (2 * a);
				txtKQ.setText("x1 = " + x1 + " x2 = " + x2);
			} else if (delta == 0) {
				x1 = -b / (2 * a);
				txtKQ.setText("x1 = x2 = " + x1);
			} else {
				txtKQ.setText("Phương trình vô nghiệm");
			}
		}
		
		else {
			txtKQ.setText("Vui lòng nhập số nguyên");
		}
	}

	private boolean isDouble(JTextField text) {
		boolean result = true;
		try {
			Double.parseDouble(text.getText());
		} catch (NumberFormatException ex) {
			result = false;
		}
		return result;
	}
}
