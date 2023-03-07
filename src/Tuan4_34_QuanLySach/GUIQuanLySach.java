package Tuan4_34_QuanLySach;

import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;


public class GUIQuanLySach extends JFrame{
	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamSX;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnXoa;
	private DefaultTableModel modelDanhSach;
	private JTable tableDanhSach;

	public GUIQuanLySach() {
		// TODO Auto-generated constructor stub
		setTitle("Quản lý sách");
		setSize(1000, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		// RE
		JPanel panelRE = new JPanel();
		panelRE.setBorder(BorderFactory.createTitledBorder("Records Edittor"));
		panelRE.setLayout(new BoxLayout(panelRE, BoxLayout.Y_AXIS));
		
		Box b1 = Box.createHorizontalBox();
		JLabel lblMaSach = new JLabel("Mã sách: ");
		txtMaSach = new JTextField();
		b1.add(lblMaSach);
		b1.add(txtMaSach);
		
		Box b2 = Box.createHorizontalBox();
		JLabel lblTuaSach = new JLabel("Tựa sách: ");
		txtTuaSach = new JTextField();
		JLabel lblTacGia = new JLabel("Tác giả: ");
		txtTacGia = new JTextField();
		b2.add(lblTuaSach);
		b2.add(txtTuaSach);
		b2.add(lblTacGia);
		b2.add(txtTacGia);
		
		Box b3 = Box.createHorizontalBox();
		JLabel lblNamSX= new JLabel("Năm sản xuất: ");
		txtNamSX = new JTextField();
		JLabel lblNhaXB = new JLabel("Nhà xuất bản: ");
		txtNhaXB = new JTextField();
		b3.add(lblNamSX);
		b3.add(txtNamSX);
		b3.add(lblNhaXB);
		b3.add(txtNhaXB);
		
		Box b4 = Box.createHorizontalBox();
		JLabel lblSoTrang= new JLabel("Số trang: ");
		txtSoTrang = new JTextField();
		JLabel lblDonGia = new JLabel("Đơn giá: ");
		txtDonGia = new JTextField();
		b4.add(lblSoTrang);
		b4.add(txtSoTrang);
		b4.add(lblDonGia);
		b4.add(txtDonGia);
		
		Box b5 = Box.createHorizontalBox();
		JLabel lblISBN = new JLabel("International Standard Book Number (ISBN): ");
		txtISBN = new JTextField();
		b5.add(lblISBN);
		b5.add(txtISBN);
		
		panelRE.add(b1);
		panelRE.add(b2);
		panelRE.add(b3);
		panelRE.add(b4);
		panelRE.add(b5);
		
		// center
		JPanel panelCenter = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoaRong = new JButton("Xóa rỗng");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		
		panelCenter.add(btnThem);
		panelCenter.add(btnXoaRong);
		panelCenter.add(btnSua);
		panelCenter.add(btnXoa);
		
		
		// danh sách
		JPanel panelDS = new JPanel();
		panelDS.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		modelDanhSach = new DefaultTableModel();
		tableDanhSach = new JTable(modelDanhSach);
		
		JScrollPane sp = new JScrollPane(tableDanhSach, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		panelDS.add(sp);
		
		panel.add(panelRE);
		panel.add(panelCenter);
		panel.add(panelDS);
		this.add(panel);
	}
	
	public static void main(String[] args) {
		new GUIQuanLySach().setVisible(true);
	}
}
