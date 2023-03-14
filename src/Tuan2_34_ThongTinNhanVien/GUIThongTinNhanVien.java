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
		// thiáº¿t láº­p thuá»™c tÃ­nh cho JFrame
		setTitle("^-^");
		setSize(900, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		// pháº§n north

		JPanel panelNorth = new JPanel();
		this.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("THÃ”NG TIN NHÃ‚N VIÃŠN");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 25));
		panelNorth.add(lblTitle);
		

		// pháº§n center

		// khai bÃ¡o cÃ¡c component
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new BoxLayout(panelCenter, BoxLayout.Y_AXIS));
		this.add(panelCenter, BorderLayout.CENTER);

		// pháº§n nháº­p dá»¯ liá»‡u
		
		
		
		

		JLabel lblMaNV = new JLabel("MÃ£ nhÃ¢n viÃªn: ");
		txtMaNV = new JTextField(55);
		Box b1 = Box.createHorizontalBox();
		b1.add(lblMaNV);
		b1.add(txtMaNV);
		
		
		JLabel lblHo = new JLabel("Há»�: ");
		txtHo = new JTextField();
		JLabel lblTen = new JLabel("TÃªn nhÃ¢n viÃªn: ");
		txtTen = new JTextField();
		Box b2 = Box.createHorizontalBox();
		b2.add(lblHo);
		b2.add(txtHo);
		b2.add(lblTen);
		b2.add(txtTen);
		
		
		JLabel lblTuoi = new JLabel("Tuá»•i: ");
		txtTuoi = new JTextField();
		JLabel lblPhai = new JLabel("PhÃ¡i: ");
		radioBtnNam = new JRadioButton("Nam", true);
		radioBtnNu = new JRadioButton("Ná»¯");
		group = new ButtonGroup();
		group.add(radioBtnNam);
		group.add(radioBtnNu);
		Box b3 = Box.createHorizontalBox();
		b3.add(lblTuoi);
		b3.add(txtTuoi);
		b3.add(lblPhai);
		b3.add(radioBtnNam);
		b3.add(radioBtnNu);
		
		
		JLabel lblLuong = new JLabel("Tiá»�n LÆ°Æ¡ng: ");
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

		// pháº§n table
		String[] column = { "MÃ£ NV", "Há»�", "TÃªn", "PhÃ¡i", "Tuá»•i", "Tiá»�n lÆ°Æ¡ng" };
		String[] options = { "Nam", "Ná»¯" };

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
		

		
		
		

		// pháº§n south
		JPanel panelSouth = new JPanel();
		this.add(panelSouth, BorderLayout.SOUTH);

		JPanel panelSouthLeft = new JPanel();
		JLabel lblTim = new JLabel("Nháº­p mÃ£ sá»‘ cáº§n tÃ¬m: ");
		txtTim = new JTextField(7);
		btnTim = new JButton("TÃ¬m");

		panelSouthLeft.add(lblTim);
		panelSouthLeft.add(txtTim);
		panelSouthLeft.add(btnTim);

		JPanel panelSouthRight = new JPanel();
		btnThem = new JButton("ThÃªm");
		btnXoaTrang = new JButton("XÃ³a tráº¯ng");
		btnXoa = new JButton("XÃ³a");
		btnSua = new JButton("Sá»­a");
		btnLuu = new JButton("LÆ°u");
		btnLamMoi = new JButton("LÃ m má»›i");
		
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
		listNV.napDuLieuTuFile();
		docDuLieuTuArrayListVaoModel();
		
//		taoCung();
		// sá»± kiá»‡n
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
					JOptionPane.showMessageDialog(this, "Vui lÃ²ng nháº­p Ä‘áº§y Ä‘á»§ thÃ´ng tin");
				} else {
					NhanVien nv = new NhanVien(maNV, hoNV, tenNV, phai, tuoi, tienLuong);
					if (!listNV.themNhanVien(nv))
						JOptionPane.showMessageDialog(this, "MÃ£ nhÃ¢n viÃªn trÃ¹ng");
					else {
						String gioiTinh;
						if (radioBtnNam.isSelected())
							gioiTinh = "Nam";
						else
							gioiTinh = "Ná»¯";
						modelNhanVien.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), gioiTinh,
								nv.getTuoi(), nv.getTienLuong() });
						JOptionPane.showMessageDialog(this, "ThÃªm nhÃ¢n viÃªn thÃ nh cÃ´ng");
					}
				}
				
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "Vui lÃ²ng nháº­p thÃ´ng tin há»£p lá»‡");
			}
		}
		
		if(o.equals(btnXoaTrang)) {
			xoaTrang();
		}
		if(o.equals(btnXoa)) {
			int r = tableNhanVien.getSelectedRow();
			if(r < 0)
				JOptionPane.showMessageDialog(this, "Vui lÃ²ng chá»�n nhÃ¢n viÃªn báº¡n muá»‘n xÃ³a!!");
			else {
				if(JOptionPane.showConfirmDialog(this, "Báº¡n cÃ³ cháº¯c cháº¯n muá»‘n xÃ³a nhÃ¢n viÃªn nÃ y khÃ´ng?" + tableNhanVien.getValueAt(r, 1) + " " + tableNhanVien.getValueAt(r, 2), "Lá»±a chá»�n", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
					modelNhanVien.removeRow(r);
					NhanVien nv = listNV.getElement(r);
					listNV.xoaNhanVien(nv.getMaNV());
					xoaTrang();
					JOptionPane.showMessageDialog(this, "XÃ³a thÃ nh cÃ´ng");
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
						gioiTinh = "Ná»¯";
					modelNhanVien.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), gioiTinh, nv.getTuoi(),
							nv.getTienLuong() });
				} else {
					JOptionPane.showMessageDialog(this, "KhÃ´ng tÃ¬m tháº¥y mÃ£ nhÃ¢n viÃªn");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Vui lÃ²ng nháº­p mÃ£ nhÃ¢n viÃªn cáº§n tÃ¬m");
			}
		}
		if(o.equals(btnSua)) {
			String str = txtMaNV.getText();
			if(str != null && str.trim().length() > 0) {
				NhanVien nv = listNV.timKiem(str);
				if(nv != null) {
					if(JOptionPane.showConfirmDialog(this, "Báº¡n cÃ³ cháº¯c cháº¯n muá»‘n cáº­p nháº­t nhÃ¢n viÃªn cÃ³ mÃ£ " + str + " nÃ y khÃ´ng?","ThÃ´ng bÃ¡o",JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						nv.setHoNV(txtHo.getText());
						nv.setTenNV(txtTen.getText());
						nv.setHoNV(txtHo.getText());
						nv.setPhai(radioBtnNam.isSelected());
						nv.setTuoi(Integer.parseInt(txtTuoi.getText()));
						nv.setTienLuong(Double.parseDouble(txtLuong.getText()));
						
						xoaHetDuLieuTrenTableModel();
						docDuLieuTuArrayListVaoModel();
						xoaTrang();
						
						JOptionPane.showMessageDialog(this, "Cáº­p nháº­t thÃ nh cÃ´ng");
					} else {
						JOptionPane.showMessageDialog(this, "Cáº­p nháº­t khÃ´ng thÃ nh cÃ´ng");
					}
				} else {
					JOptionPane.showMessageDialog(this, "KhÃ´ng tÃ¬m tháº¥y nhÃ¢n viÃªn");
				}
			} else {
				JOptionPane.showMessageDialog(this, "Chá»�n nhÃ¢n viÃªn muá»‘n cáº­p nháº­t!!");
			}
		}
		if(o.equals(btnLuu)) {
			try {
				Database.ghiXuongFile(listNV.getDsNV());
				JOptionPane.showMessageDialog(this, "LÆ°u thÃ´ng tin thÃ nh cÃ´ng");
			} catch (Exception e2) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(this, "LÆ°u thÃ´ng tin khÃ´ng thÃ nh cÃ´ng");
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
				gioiTinh = "Ná»¯";
			modelNhanVien.addRow(new Object[] { nv.getMaNV(), nv.getHoNV(), nv.getTenNV(), gioiTinh, nv.getTuoi(),
					nv.getTienLuong() });
		}
	}

	private void xoaHetDuLieuTrenTableModel() {
		DefaultTableModel dm = (DefaultTableModel) tableNhanVien.getModel();
		dm.getDataVector().removeAllElements();
	}
	
	private void taoCung() {
		NhanVien nv1 = new NhanVien("1111", "Nguyá»…n", "HoÃ ng", true, 26, 4500);
		NhanVien nv2 = new NhanVien("2222", "LÃª", "Thu", false, 28, 5000);
		NhanVien nv3 = new NhanVien("3333", "HoÃ ng", "LÃª", true, 30, 5000);
		NhanVien nv4 = new NhanVien("4444", "Tráº§n", "Lan", false, 27, 3500);
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
