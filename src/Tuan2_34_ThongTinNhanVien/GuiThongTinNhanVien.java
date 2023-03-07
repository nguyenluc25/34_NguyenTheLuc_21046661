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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class GUIThongTinNhanVien extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private NhanVien_Collection listNV;
	
	private JTextField txtMaNV;
	private JTextField txtHo;
	private JTextField txtTen;
	private JTextField txtTuoi;
	private JTextField txtLuong;
	private JTextField txtTim;
	private JRadioButton radioBtnNam;
	private JRadioButton radioBtnNu;
	private ButtonGroup group;
	private DefaultTableModel modelNhanVien;
	private JTable tableNhanVien;
	private JButton btnTim;
	private JButton btnThem;
	private JButton btnXoaTrang;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnLamMoi;


	public GUIThongTinNhanVien() {
		// TODO Auto-generated constructor stub
		// thiết lập thuộc tính cho JFrame
		setTitle("^-^");
		setSize(730, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// phần north

		JPanel panelNorth = new JPanel();
		this.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("THÔNG TIN NHÂN VIÊN");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		panelNorth.add(lblTitle);
		

		// phần center

		// khai báo các component
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		this.add(panelCenter, BorderLayout.CENTER);

		// phần nhập dữ liệu
		
		
		
		

		JLabel lblMaNV = new JLabel("Mã nhân viên: ");
		txtMaNV = new JTextField(55);
		Box b1 = Box.createHorizontalBox();
		b1.add(lblMaNV);
		b1.add(txtMaNV);
		
		
		JLabel lblHo = new JLabel("Họ: ");
		txtHo = new JTextField();
		JLabel lblTen = new JLabel("Tên nhân viên: ");
		txtTen = new JTextField();
		Box b2 = Box.createHorizontalBox();
		b2.add(lblHo);
		b2.add(txtHo);
		b2.add(lblTen);
		b2.add(txtTen);
		
		
		JLabel lblTuoi = new JLabel("Tuổi: ");
		txtTuoi = new JTextField();
		JLabel lblPhai = new JLabel("Phái: ");
		radioBtnNam = new JRadioButton("Nam", true);
		radioBtnNu = new JRadioButton("Nữ");
		group = new ButtonGroup();
		group.add(radioBtnNam);
		group.add(radioBtnNu);
		Box b3 = Box.createHorizontalBox();
		b3.add(lblTuoi);
		b3.add(txtTuoi);
		b3.add(lblPhai);
		b3.add(radioBtnNam);
		b3.add(radioBtnNu);
		
		
		JLabel lblLuong = new JLabel("Tiền Lương: ");
		txtLuong = new JTextField();
		Box b4 = Box.createHorizontalBox();
		b4.add(lblLuong);
		b4.add(txtLuong);
		
		
		panelCenter.add(b1);
		panelCenter.add(Box.createVerticalStrut(5));
		panelCenter.add(b2);
		panelCenter.add(Box.createVerticalStrut(5));
		panelCenter.add(b3);
		panelCenter.add(Box.createVerticalStrut(5));
		panelCenter.add(b4);
		panelCenter.add(Box.createVerticalStrut(5));
	

		lblHo.setPreferredSize(lblMaNV.getPreferredSize());
		lblTuoi.setPreferredSize(lblMaNV.getPreferredSize());
		lblLuong.setPreferredSize(lblMaNV.getPreferredSize());

		// phần table
		String[] column = { "Mã NV", "Họ", "Tên", "Phái", "Tuổi", "Tiền lương" };
		String[] options = { "Nam", "Nữ" };

		JPanel panelTable = new JPanel();
		panelCenter.add(panelTable);
		modelNhanVien = new DefaultTableModel(column, 0);
		tableNhanVien = new JTable(modelNhanVien);
		JScrollPane sp = new JScrollPane(tableNhanVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sp.setPreferredSize(new Dimension(715, 250));
		panelTable.add(sp);
		
		JComboBox<String> comboBox = new JComboBox<>(options);
		TableColumn phaiColumn;
		phaiColumn = tableNhanVien.getColumnModel().getColumn(3);
		phaiColumn.setCellEditor(new DefaultCellEditor(comboBox));
		

		
		
		

		// phần south
		JPanel panelSouth = new JPanel();
		this.add(panelSouth, BorderLayout.SOUTH);

		JPanel panelSouthLeft = new JPanel();
		JLabel lblTim = new JLabel("Nhập mã số cần tìm: ");
		txtTim = new JTextField(7);
		btnTim = new JButton("Tìm");

		panelSouthLeft.add(lblTim);
		panelSouthLeft.add(txtTim);
		panelSouthLeft.add(btnTim);

		JPanel panelSouthRight = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoaTrang = new JButton("Xóa trắng");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnLuu = new JButton("Lưu");
		btnLamMoi = new JButton("Làm mới");
		
		panelSouthRight.add(btnLamMoi);
		panelSouthRight.add(btnThem);
		panelSouthRight.add(btnXoaTrang);
		panelSouthRight.add(btnXoa);
		panelSouthRight.add(btnSua);
		panelSouthRight.add(btnLuu);

		panelSouth.add(panelSouthLeft);
		panelSouth.add(panelSouthRight);
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split.add(panelSouthLeft);
		split.add(panelSouthRight);
		panelSouth.add(split);
		
		
		listNV = new NhanVien_Collection();
		
		StoredData stData = new StoredData();
		try {
			listNV = (NhanVien_Collection) stData.readFile("data//DsNV.txt");
			docDuLieuTuArrayListVaoModel();
		} catch (Exception e) {
//			 TODO: handle exception
			e.printStackTrace();
		}
//		taoCung();
		// sự kiện
		btnThem.addActionListener(this);
		btnXoa.addActionListener(this);
		btnXoaTrang.addActionListener(this);
		btnSua.addActionListener(this);
		btnTim.addActionListener(this);
		btnLuu.addActionListener(this);
		btnLamMoi.addActionListener(this);
		tableNhanVien.addMouseListener(this);

	}

	public static void main(String[] args) {
		new GUIThongTinNhanVien().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			try {
				String maNV = txtMaNV.getText();
				String hoNV = txtHo.getText();
				String tenNV = txtTen.getText();
				boolean phai = radioBtnNam.isSelected();
				int tuoi = Integer.parseInt(txtTuoi.getText());
				double tienLuong = Double.parseDouble(txtLuong.getText());
				if(maNV.equals("") || hoNV.equals("") || tenNV.equals("") || group.getSelection() == null || tuoi == -1 || tienLuong == -1) {
					JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin");
				} else {
					NhanVien nv = new NhanVien(maNV, hoNV, tenNV, phai, tuoi, tienLuong);
					if (!listNV.themNhanVien(nv))
						JOptionPane.showMessageDialog(this, "Mã nhân viên trùng");
					else {
						String gioiTinh;
						if (radioBtnNam.isSelected())
							gioiTinh = "Nam";
						else
							gioiTinh = "Nữ";
						modelNhanVien.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), gioiTinh,
								nv.getTuoi(), nv.getTienLuong() });
						JOptionPane.showMessageDialog(this, "Thêm nhân viên thành công");
					}
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin hợp lệ");
			}
		}
		
		if(o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		if(o.equals(btnXoa)) {
			int r = tableNhanVien.getSelectedRow();
			if(r < 0)
				JOptionPane.showMessageDialog(this, "Vui lòng chọn nhân viên bạn muốn xóa!!");
			else {
				if(JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa nhân viên này không?" + tableNhanVien.getValueAt(r, 1) + " " + tableNhanVien.getValueAt(r, 2), "Lựa chọn", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					modelNhanVien.removeRow(r);
					NhanVien nv = listNV.getElement(r);
					listNV.xoaNhanVien(nv.getMaNV());
					xoaTrang();
					JOptionPane.showMessageDialog(this, "Xóa thành công");
				}
			}
		}
		if(o.equals(btnTim)) {
			String str = txtTim.getText();
			if(str != null && str.trim().length() > 0) {
				NhanVien nv = listNV.timKiem(str);
				if(nv != null) {
					xoaHetDuLieuTrenTableModel();
					String gioiTinh;
					if (nv.isPhai())
						gioiTinh = "Nam";
					else
						gioiTinh = "Nữ";
					modelNhanVien.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), gioiTinh, nv.getTuoi(),
							nv.getTienLuong() });
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy mã nhân viên");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lòng nhập mã nhân viên cần tìm");
			}
		}
		if(o.equals(btnSua)) {
			String str = txtMaNV.getText();
			if(str != null && str.trim().length() > 0) {
				NhanVien nv = listNV.timKiem(str);
				if(nv != null) {
					if(JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn cập nhật nhân viên có mã " + str + " này không?","Thông báo",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						nv.setHoNV(txtHo.getText());
						nv.setTenNV(txtTen.getText());
						nv.setHoNV(txtHo.getText());
						nv.setPhai(radioBtnNam.isSelected());
						nv.setTuoi(Integer.parseInt(txtTuoi.getText()));
						nv.setTienLuong(Double.parseDouble(txtLuong.getText()));
						
						xoaHetDuLieuTrenTableModel();
						docDuLieuTuArrayListVaoModel();
						xoaTrang();
						
						JOptionPane.showMessageDialog(this, "Cập nhật thành công");
					} else {
						JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
					}
				} else {
					JOptionPane.showMessageDialog(this, "Không tìm thấy nhân viên");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chọn nhân viên muốn cập nhật!!");
			}
		}
		if(o.equals(btnLuu)) {
			try {
				StoredData stData = new StoredData();
				stData.writeFile(listNV, "data//DsNV.txt");
				JOptionPane.showMessageDialog(this, "Lưu thông tin thành công");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Lưu thông tin không thành công");
			}
		}
		if(o.equals(btnLamMoi)) {
			xoaHetDuLieuTrenTableModel();
			docDuLieuTuArrayListVaoModel();
			tableNhanVien.setModel(modelNhanVien);
		}
	}
	
	private void xoaTrang() {
		txtMaNV.setText("");
		txtHo.setText("");
		txtTen.setText("");
		txtLuong.setText("");
		txtTuoi.setText("");
		group.clearSelection();
	}

	private void docDuLieuTuArrayListVaoModel() {
		for (int i = 0; i < listNV.getSize(); i++) {
			NhanVien nv = listNV.getElement(i);
			String gioiTinh;
			if (nv.isPhai())
				gioiTinh = "Nam";
			else
				gioiTinh = "Nữ";
			modelNhanVien.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), gioiTinh, nv.getTuoi(),
					nv.getTienLuong() });
		}
	}

	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableNhanVien.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	private void taoCung() {
		NhanVien nv1 = new NhanVien("1111", "Nguyễn", "Hoàng", true, 26, 4500);
		NhanVien nv2 = new NhanVien("2222", "Lê", "Thu", false, 28, 5000);
		NhanVien nv3 = new NhanVien("3333", "Hoàng", "Lê", true, 30, 5000);
		NhanVien nv4 = new NhanVien("4444", "Trần", "Lan", false, 27, 3500);
		listNV.themNhanVien(nv1);
		listNV.themNhanVien(nv2);
		listNV.themNhanVien(nv3);
		listNV.themNhanVien(nv4);
		docDuLieuTuArrayListVaoModel();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableNhanVien.getSelectedRow();
		txtMaNV.setText(modelNhanVien.getValueAt(row, 0).toString());
		txtHo.setText(modelNhanVien.getValueAt(row, 1).toString());
		txtTen.setText(modelNhanVien.getValueAt(row, 2).toString());
		if(modelNhanVien.getValueAt(row, 3).toString().equals("Nam")) {
			radioBtnNam.setSelected(true);
		}
		else radioBtnNu.setSelected(true);
		txtTuoi.setText(modelNhanVien.getValueAt(row, 4).toString());
		txtLuong.setText(modelNhanVien.getValueAt(row, 5).toString());
		
		
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
