package Tuan2_34_ThongTinNhanVien;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GuiThongTinNhanVien extends JFrame implements ActionListener, MouseListener{

	private NhanVien_Collection listNV;

	private JLabel lblMaNV;
	private JLabel lblHo;
	private JLabel lblTen;
	private JLabel lblTuoi;
	private JLabel lblPhai;
	private JLabel lblTienLuong;
	private JPanel panelCenter;
	private JTable tblNV;
	private DefaultTableModel model;
	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtTienLuong;
	private JRadioButton radioBtnNam;
	private JRadioButton radioBtnNu;
	private JTextField txtTim;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnLuu;

	private TableColumn phaiColumn;

	private JComboBox comboBox;

	public GuiThongTinNhanVien() {
		// TODO Auto-generated constructor stub
		setTitle("^-^");
		setSize(700, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// North
		JPanel panelNorth = new JPanel();
		JLabel lblTitle = new JLabel("THONG TIN SINH VIEN");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		lblTitle.setForeground(Color.BLUE);
		panelNorth.add(lblTitle);
		add(panelNorth, BorderLayout.NORTH);

		// Center
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
		radioBtnNam = new JRadioButton("Nam", true);
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

		// South
		JPanel panelSouth = new JPanel();

		JPanel panelSouthLeft = new JPanel();
		JLabel lblTim = new JLabel("Nhap ma so can tim: ");
		txtTim = new JTextField(15);
		btnTim = new JButton("Tim");
		panelSouthLeft.add(lblTim);
		panelSouthLeft.add(txtTim);
		panelSouthLeft.add(btnTim);
		panelSouth.add(panelSouthLeft);

		JPanel panelSouthRight = new JPanel();
		btnThem = new JButton("Them");
		btnXoa = new JButton("Xoa");
		btnXoaTrang = new JButton("Xoa trang");
		btnLuu = new JButton("Luu");
		panelSouthRight.add(btnThem);
		panelSouthRight.add(btnXoa);
		panelSouthRight.add(btnXoaTrang);
		panelSouthRight.add(btnLuu);
		panelSouth.add(panelSouthRight);

		JSplitPane split;
		panelSouth.add(split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT));
		split.add(panelSouthLeft);
		split.add(panelSouthRight);
		add(panelSouth, BorderLayout.SOUTH);

		listNV = new NhanVien_Collection();
		
		NhanVien nv1 = new NhanVien("1111", "Nguyen", "Hoang", 26, "Nam", 4500);
		NhanVien nv2 = new NhanVien("2222", "Le", "Thu", 28, "Nu", 5000);
		NhanVien nv3 = new NhanVien("3333", "Hoang", "Le", 30, "Nam", 5000);
		NhanVien nv4 = new NhanVien("4444", "Tran", "Lan", 27, "Nu", 3500);
		
		listNV.themNhanVien(nv1);
		listNV.themNhanVien(nv2);
		listNV.themNhanVien(nv3);
		listNV.themNhanVien(nv4);
		
		docDuLieuTuArrayListVaoModel();
		
		btnThem.addActionListener(this);
		btnTim.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		
	}

	private void taoBang() {
		JPanel panelTable = new JPanel();
		model = new DefaultTableModel();
		tblNV = new JTable(model);
		model.addColumn("Ma NV");
		model.addColumn("Ho");
		model.addColumn("Ten");
		model.addColumn("Tuoi");
		model.addColumn("Phai");
		model.addColumn("Tien luong");
		phaiColumn = tblNV.getColumnModel().getColumn(4);
		String[] options = { "Nam", "Nu" };
		comboBox = new JComboBox<>(options);
		phaiColumn.setCellEditor(new DefaultCellEditor(comboBox));
		panelTable.add(tblNV);
		JScrollPane sp = new JScrollPane(tblNV, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(650, 250));
		panelCenter.add(sp);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			String ma = txtMaNV.getText();
			String ho = txtHo.getText();
			String ten = txtTen.getText();
			int tuoi = Integer.parseInt(txtTuoi.getText());
			String phai;
			if (radioBtnNam.isSelected()) {
				phai = "Nam";
			} else
				phai = "Nu";

			double luong = Double.parseDouble(txtTienLuong.getText());

			NhanVien nv = new NhanVien(ma, ho, ten, tuoi, phai, luong);
			if (!listNV.themNhanVien(nv)) {
				JOptionPane.showMessageDialog(this, "Trung");
			} else {
				model.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), nv.getPhai(),
						nv.getLuong() });
			}
		}
		if (o.equals(btnXoa)) {
			int r = tblNV.getSelectedRow();
			// Xoa trong table
			model.removeRow(r);
			// Xoa trong ArrayList
			NhanVien nv = listNV.getElement(r);
			listNV.xoaNhanVien(nv.getMaNV());
		}

		if (o.equals(btnXoaTrang)) {
			txtMaNV.setText("");
			txtHo.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
			txtTienLuong.setText("");
		}
		
		if(o.equals(btnTim)) {
			timTheoMaNV();
		}
	}

	private void docDuLieuTuArrayListVaoModel() {
		for (int i = 0; i < listNV.getSize(); i++) {
			NhanVien nv = listNV.getElement(i);
			model.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), nv.getPhai(),
					nv.getLuong() });
		}
	}

	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tblNV.getModel();
		dm.getDataVector().removeAllElements();
	}

	private void timTheoMaNV() {
		String maNV = txtTim.getText();
		if (maNV != null && maNV.trim().length() > 0) {
			try {
				NhanVien nv = listNV.timKiem(maNV);
				if (nv != null) {
					xoaHetDuLieuTrenTableModel();
					model.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), nv.getTuoi(), nv.getPhai(),
							nv.getLuong() });
				} else {
					JOptionPane.showMessageDialog(this,"Khong tim thay");
					return ;
				}
			} catch (Exception ex) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this,"Du lieu khong hop le");
				txtTim.selectAll();
				txtTim.requestFocus();
			}
		} else {
			xoaHetDuLieuTrenTableModel();
			docDuLieuTuArrayListVaoModel();
			tblNV.setModel(model);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tblNV.getSelectedRow();
		txtMaNV.setText(model.getValueAt(row, 0).toString());
		txtHo.setText(model.getValueAt(row, 1).toString());
		txtTen.setText(model.getValueAt(row, 2).toString());
		txtTuoi.setText(model.getValueAt(row, 3).toString());
		comboBox.setSelectedItem(model.getValueAt(row, 4).toString());
		txtMaNV.setText(model.getValueAt(row, 5).toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
