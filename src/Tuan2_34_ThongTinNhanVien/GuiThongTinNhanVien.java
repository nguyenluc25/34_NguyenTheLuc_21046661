package Tuan2_34_ThongTinNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GuiThongTinNhanVien extends JFrame{
	private JLabel lblMaNV;
	private JLabel lblHo;
	private JLabel lblTen;
	private JLabel lblTuoi;
	private JLabel lblPhai;
	private JLabel lblTienLuong;
	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JRadioButton radioBtnNam;
	private JRadioButton radioBtnNu;
	private JTable tblNV;
	private JPanel panelCenter;
	private DefaultTableModel model;



	public GuiThongTinNhanVien() {
		// TODO Auto-generated constructor stub
		setTitle("^-^");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		
		//North
		JPanel panelNorth = new JPanel();
		JLabel lblTitle = new JLabel("THONG TIN SINH VIEN");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		lblTitle.setForeground(Color.BLUE);
		panelNorth.add(lblTitle);
		add(panelNorth, BorderLayout.NORTH);
		
		//Center
		panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		JPanel panelNhap = new JPanel();
		
		Box b = Box.createVerticalBox();
		Box b1 = Box.createHorizontalBox();
		Box b2 = Box.createHorizontalBox();
		Box b3 = Box.createHorizontalBox();
		Box b4 = Box.createHorizontalBox();
		
		lblMaNV = new JLabel("Ma nhan vien: ");
		txtMaNV = new JTextField(54);
		lblHo = new JLabel("Ho: ");
		txtHo = new JTextField();
		lblTen = new JLabel("Ten nhan vien: ");
		txtTen = new JTextField();
		lblTuoi = new JLabel("Tuoi: ");
		txtTuoi = new JTextField();
		lblPhai = new JLabel("Phai: ");
		lblTienLuong = new JLabel("Tien luong: ");
		txtTienLuong = new JTextField();
		
		b1.add(lblMaNV);
		b1.add(txtMaNV);
		b.add(b1);
		b.add(Box.createVerticalStrut(5));
		b2.add(lblHo);
		b2.add(txtHo);
		b2.add(lblTen);
		b2.add(txtTen);
		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		b.add(b2);
		b.add(Box.createVerticalStrut(5));
		b3.add(lblTuoi);
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		b3.add(txtTuoi);
		b3.add(lblPhai);
		radioBtnNam = new JRadioButton("Nam");
		radioBtnNu = new JRadioButton("Nu");
		b3.add(radioBtnNam);
		b3.add(radioBtnNu);
		ButtonGroup group = new ButtonGroup();
		group.add(radioBtnNam);
		group.add(radioBtnNu);
		b.add(b3);
		b.add(Box.createVerticalStrut(5));
		b4.add(lblTienLuong);
		lblTienLuong.setPreferredSize(lblMaNV.getPreferredSize());
		b4.add(txtTienLuong);
		b.add(b4);
		b.add(Box.createVerticalStrut(5));
		panelNhap.add(b);
		
		panelCenter.add(panelNhap);
		taoBang();
		add(panelCenter, BorderLayout.CENTER);
		
		//South
		JPanel panelSouth = new JPanel();
		JPanel panelSouth1 = new JPanel();
		JLabel lblTimMaNV = new JLabel("Nhap ma so can tim: ");
	}
	
	private void taoBang() {
		JPanel panelTable = new JPanel();
		model = new DefaultTableModel();
		tblNV = new JTable(model);
		model.addColumn("Ma NV");
		model.addColumn("Ho");
		model.addColumn("Ten");
		model.addColumn("Phai");
		model.addColumn("Tuoi");
		model.addColumn("Tien luong");
		panelTable.add(tblNV);
		JScrollPane sp = new JScrollPane(tblNV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(0, 400));
		panelCenter.add(sp);
	}
	
	
	
	public static void main(String[] args) {
		new GuiThongTinNhanVien().setVisible(true);
		// test github 
	}
	
}
