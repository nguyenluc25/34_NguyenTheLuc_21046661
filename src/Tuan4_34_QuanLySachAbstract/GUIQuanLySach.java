package Tuan4_34_QuanLySachAbstract;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class GUIQuanLySach extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sach_Collection ds;
	private JTextField txtMaSach;
	private JTextField txtTuaSach;
	private JTextField txtTacGia;
	private JTextField txtNamXB;
	private JTextField txtNhaXB;
	private JTextField txtSoTrang;
	private JTextField txtDonGia;
	private JTextField txtISBN;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnSua;
	private JButton btnXoa;
	private JButton btnLuu;
	private DefaultTableModel modelSach;
	private JTable tableSach;
	private JComboBox<String> comboBox;
	private ArrayList<String> comboBoxData;

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
		b1.add(Box.createHorizontalStrut(512));

		Box b2 = Box.createHorizontalBox();
		JLabel lblTuaSach = new JLabel("Tựa sách: ");
		txtTuaSach = new JTextField();
		JLabel lblTacGia = new JLabel("Tác giả: ");
		txtTacGia = new JTextField();
		b2.add(lblTuaSach);
		b2.add(txtTuaSach);
		b2.add(Box.createHorizontalStrut(50));
		b2.add(lblTacGia);
		b2.add(txtTacGia);

		Box b3 = Box.createHorizontalBox();
		JLabel lblNamXB = new JLabel("Năm xuất bản: ");
		txtNamXB = new JTextField();
		JLabel lblNhaXB = new JLabel("Nhà xuất bản: ");
		txtNhaXB = new JTextField();
		b3.add(lblNamXB);
		b3.add(txtNamXB);
		b3.add(Box.createHorizontalStrut(50));
		b3.add(lblNhaXB);
		b3.add(txtNhaXB);

		Box b4 = Box.createHorizontalBox();
		JLabel lblSoTrang = new JLabel("Số trang: ");
		txtSoTrang = new JTextField();
		JLabel lblDonGia = new JLabel("Đơn giá: ");
		txtDonGia = new JTextField();
		b4.add(lblSoTrang);
		b4.add(txtSoTrang);
		b4.add(Box.createHorizontalStrut(50));
		b4.add(lblDonGia);
		b4.add(txtDonGia);

		Box b5 = Box.createHorizontalBox();
		JLabel lblISBN = new JLabel("International Standard Book Number (ISBN): ");
		txtISBN = new JTextField();
		b5.add(lblISBN);
		b5.add(txtISBN);
		b5.add(Box.createHorizontalStrut(512));

		lblMaSach.setPreferredSize(new Dimension(85, 0));
		lblTuaSach.setPreferredSize(lblMaSach.getPreferredSize());
		lblSoTrang.setPreferredSize(lblMaSach.getPreferredSize());
		lblTacGia.setPreferredSize(lblMaSach.getPreferredSize());
		lblNamXB.setPreferredSize(lblMaSach.getPreferredSize());
		lblNhaXB.setPreferredSize(lblMaSach.getPreferredSize());
		lblDonGia.setPreferredSize(lblMaSach.getPreferredSize());

		txtTuaSach.setPreferredSize(txtMaSach.getPreferredSize());
		txtSoTrang.setPreferredSize(txtMaSach.getPreferredSize());
		txtTacGia.setPreferredSize(txtMaSach.getPreferredSize());
		txtNamXB.setPreferredSize(txtMaSach.getPreferredSize());
		txtNhaXB.setPreferredSize(txtMaSach.getPreferredSize());
		txtDonGia.setPreferredSize(txtMaSach.getPreferredSize());

		panelRE.add(Box.createVerticalStrut(10));
		panelRE.add(b1);
		panelRE.add(Box.createVerticalStrut(10));
		panelRE.add(b2);
		panelRE.add(Box.createVerticalStrut(10));
		panelRE.add(b3);
		panelRE.add(Box.createVerticalStrut(10));
		panelRE.add(b4);
		panelRE.add(Box.createVerticalStrut(10));
		panelRE.add(b5);
		panelRE.add(Box.createVerticalStrut(10));

		// center
		JPanel panelCenter = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoaRong = new JButton("Xóa rỗng");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		btnLuu = new JButton("Lưu");
		JLabel lblTim = new JLabel("Tìm theo mã sách: ");
		comboBox = new JComboBox<>();

		panelCenter.add(btnThem);
		panelCenter.add(btnXoaRong);
		panelCenter.add(btnSua);
		panelCenter.add(btnXoa);
		panelCenter.add(btnLuu);
		panelCenter.add(Box.createHorizontalStrut(50));
		panelCenter.add(lblTim);
		panelCenter.add(comboBox);

		// danh sách
		String[] column = { "Mã sách", "Tựa sách", "Tác giả", "Năm sản xuất", "Nhà xuất bản", "Số trang", "Đơn giá",
				"ISBN" };
		JPanel panelDS = new JPanel();
		panelDS.setBorder(BorderFactory.createTitledBorder("Danh sách các cuốn sách"));
		modelSach = new DefaultTableModel(column, 0);
		tableSach = new JTable(modelSach);

		JScrollPane sp = new JScrollPane(tableSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sp.setPreferredSize(new Dimension(980, 300));
		panelDS.add(sp);

		panel.add(panelRE);
		panel.add(panelCenter);
		panel.add(panelDS);
		this.add(panel);

		//
		ds = new Sach_Collection();
		ds.napDuLieuTuFile();
		comboBoxData = new ArrayList<>();
		
		docDuLieuTuArrayListVaoModel();
		docDuLieuTuArrayListVaoComboBox();
		
		// Sự kiện
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		tableSach.addMouseListener(this);
		comboBox.addActionListener(this);
	}

	public static void main(String[] args) {
		new GUIQuanLySach().setVisible(true);
	}

	private void docDuLieuTuArrayListVaoModel() {
		for (int i = 0; i < ds.getSize(); i++) {
			Sach sach = ds.getElement(i);
			modelSach.addRow(new Object[] { sach.getMaSach(), sach.getTuaSach(), sach.getTacGia(), sach.getNamXuatBan(),
					sach.getNhaXuatBan(), sach.getSoTrang(), sach.getDonGia(), sach.getISBN() });
		}
	}
	
	private void docDuLieuTuArrayListVaoComboBox() {
		for (int i = 0; i < ds.getSize(); i++) {
			Sach sach = ds.getElement(i);
			comboBoxData.add(sach.getMaSach());
		}
		comboBox.setModel(new DefaultComboBoxModel<String>(comboBoxData.toArray(new String[0])));
	}

	private void xoaHetDuLieuTrenModel() {
		DefaultTableModel dm = (DefaultTableModel) tableSach.getModel();
		dm.getDataVector().removeAllElements();
	}

	private boolean isMaSach(JTextField maSach, JTextField tuaSach) {
		char[] charArrayMaSach = maSach.getText().toCharArray();
		char firstCharTuaSach = tuaSach.getText().charAt(0);
		String str = maSach.getText().trim();
		if (str.equals("") || str.length() > 4 || charArrayMaSach[0] != firstCharTuaSach) {
			return false;
		} else {
			for (int i = 1; i < charArrayMaSach.length; i++) {
				if (!Character.isDigit(charArrayMaSach[i])) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isISBN(JTextField isbn) {
		char[] charArrayISBN = isbn.getText().toCharArray();
		int count = 0;
		for (int i = 0; i < charArrayISBN.length; i++) {
			if (!Character.isDigit(charArrayISBN[i]) && charArrayISBN[i] != '-') {
				return false;
			} else if (charArrayISBN[i] == '-' && !Character.isDigit(charArrayISBN[i + 1])) {
				return false;
			}
			if (charArrayISBN[i] == '-')
				count++;
		}
		if (count < 3 || count > 4)
			return false;
		return true;
	}

	private void add() {
		try {
			if (!isMaSach(txtMaSach, txtTuaSach)) {
				JOptionPane.showMessageDialog(this,
						"Mã sách phải theo qui ước sau: Có ký tự đầu là ký tự đầu của tựa sách, theo sau là 3 ký tự số");
				return;
			}
			String maSach = txtMaSach.getText();
			String tuaSach = txtTuaSach.getText();
			String tacGia = txtTacGia.getText();
			int namXB = Integer.parseInt(txtNamXB.getText());
			String nhaXB = txtNhaXB.getText();
			int soTrang = Integer.parseInt(txtSoTrang.getText());
			double donGia = Double.parseDouble(txtDonGia.getText());
			if (!isISBN(txtISBN)) {
				JOptionPane.showMessageDialog(this,
						"ISBN có mẫu dạng X-X-X-X (hoặc X-X-X-X-X). Trong đó, X gồm các ký tự số, ít nhất là 1 ký tự số.");
				return;
			}
			String ISBN = txtISBN.getText();
			Sach sach = new Sach(maSach, tuaSach, tacGia, namXB, nhaXB, soTrang, donGia, ISBN);
			if (ds.themSach(sach)) {
				modelSach.addRow(new Object[] { sach.getMaSach(), sach.getTuaSach(), sach.getTacGia(), sach.getNamXuatBan(),
						sach.getNhaXuatBan(), sach.getSoTrang(), sach.getDonGia(), sach.getISBN() });
				comboBoxData.add(sach.getMaSach());
				comboBox.setModel(new DefaultComboBoxModel<>(comboBoxData.toArray(new String[0])));
				deleteEmpty();
				JOptionPane.showMessageDialog(this, "Thêm thành công");
		
			} else {
				JOptionPane.showMessageDialog(this, "Trùng mã sách!");
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin hợp lệ");
		}
		
	}

	private void deleteRowSelected() {
		String listMaSach = "";
//		String maSach = "";

		if (tableSach.getSelectedRow() < 0)
			JOptionPane.showMessageDialog(this, "Bạn chưa chọn sách để xóa");
		else {
			int[] listIndex = tableSach.getSelectedRows();
			listMaSach += tableSach.getValueAt(listIndex[0], 0);
			for (int i = 1; i < tableSach.getSelectedRowCount(); i++) {
				listMaSach += ", " + tableSach.getValueAt(listIndex[i], 0);
			}

			if (JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn xóa sách có mã: " + listMaSach + "?",
					"Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				try {
					while (tableSach.getSelectedRowCount() > 0) {
						int row = tableSach.getSelectedRow();
						Sach sach = ds.getElement(row);
						comboBoxData.remove(row);
						comboBox.setModel(new DefaultComboBoxModel<>(comboBoxData.toArray(new String[0])));
						ds.xoaSach(sach.getMaSach());
						modelSach.removeRow(row);
						deleteEmpty();
					}
					JOptionPane.showMessageDialog(this, "Xóa thành công");
				} catch (Exception e) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(this, "Xóa thất bại. Đã xảy ra lỗi trong quá trình thực hiện");
				}
			}
		}
	}

	private void update() {
		String maSach = txtMaSach.getText();
		if (maSach != null && maSach.trim().length() > 0) {
			Sach sach = ds.timKiem(maSach);
			if (sach == null) {
				JOptionPane.showMessageDialog(this, "Sách không tồn tại trong danh sách");
			} else {
				if (JOptionPane.showConfirmDialog(this,
						"Bạn có chắc chắn muốn sửa thông tin sách có mã: " + sach.getMaSach().toString() + " ?",
						"Thông báo", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					sach.setMaSach(txtMaSach.getText());
					sach.setTuaSach(txtTuaSach.getText());
					sach.setTacGia(txtTacGia.getText());
					sach.setNhaXuatBan(txtNhaXB.getText());
					if (!isISBN(txtISBN)) {
						JOptionPane.showMessageDialog(this, "Lỗi ISBN");
						return;
					}
					sach.setISBN(txtISBN.getText());
					sach.setNamXuatBan(Integer.parseInt(txtNamXB.getText()));
					sach.setSoTrang(Integer.parseInt(txtSoTrang.getText()));
					sach.setDonGia(Double.parseDouble(txtDonGia.getText()));

					xoaHetDuLieuTrenModel();
					docDuLieuTuArrayListVaoModel();
					deleteEmpty();

					JOptionPane.showMessageDialog(this, "Cập nhật thành công!");
				} else {
					JOptionPane.showMessageDialog(this, "Cập nhật không thành công");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "Vui lòng chọn sách muốn sửa!");
		}
	}

	private void searchComboBox() {
		int row = comboBox.getSelectedIndex();
		txtMaSach.setText(modelSach.getValueAt(row, 0).toString());
		txtTuaSach.setText(modelSach.getValueAt(row, 1).toString());
		txtTacGia.setText(modelSach.getValueAt(row, 2).toString());
		txtNamXB.setText(modelSach.getValueAt(row, 3).toString());
		txtNhaXB.setText(modelSach.getValueAt(row, 4).toString());
		txtSoTrang.setText(modelSach.getValueAt(row, 5).toString());
		txtDonGia.setText(modelSach.getValueAt(row, 6).toString());
		txtISBN.setText(modelSach.getValueAt(row, 7).toString());
		txtMaSach.setEditable(false);
		tableSach.setRowSelectionInterval(row, row);
	}

	private void deleteEmpty() {
		txtMaSach.setText("");
		txtTuaSach.setText("");
		txtTacGia.setText("");
		txtNamXB.setText("");
		txtNhaXB.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		txtMaSach.setEditable(true);
		txtMaSach.requestFocus();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			add();
		}
		if (o.equals(btnXoa)) {
			deleteRowSelected();
		}
		if (o.equals(btnXoaRong)) {
			deleteEmpty();
		}
		if (o.equals(comboBox)) {
			searchComboBox();
		}
		if (o.equals(btnSua)) {
			update();
		}
		if (o.equals(btnLuu)) {
			Database.ghiXuongFile(ds.getDsSach());
			JOptionPane.showMessageDialog(this, "Lưu thành công");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tableSach.getSelectedRow();
		txtMaSach.setText(modelSach.getValueAt(row, 0).toString());
		txtTuaSach.setText(modelSach.getValueAt(row, 1).toString());
		txtTacGia.setText(modelSach.getValueAt(row, 2).toString());
		txtNamXB.setText(modelSach.getValueAt(row, 3).toString());
		txtNhaXB.setText(modelSach.getValueAt(row, 4).toString());
		txtSoTrang.setText(modelSach.getValueAt(row, 5).toString());
		txtDonGia.setText(modelSach.getValueAt(row, 6).toString());
		txtISBN.setText(modelSach.getValueAt(row, 7).toString());
//		txtMaSach.setEditable(false);
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
