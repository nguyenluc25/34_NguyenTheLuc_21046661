package Tuan4_34_QuanLySachAbstract;

import javax.swing.table.AbstractTableModel;

public class SachTableModel extends AbstractTableModel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Sach_Collection ds;
	private String[] colsNames = { "Mã sách", "Tựa sách", "Tác giả", "Năm sản xuất", "Nhà xuất bản", "Số trang", "Đơn giá",
	"ISBN" };
	
	public SachTableModel(Sach_Collection data) {
		// TODO Auto-generated constructor stub
		ds = data;
	}
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return ds.getSize();
	}
	

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return colsNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Sach s = ds.getElement(rowIndex);
		switch (columnIndex) {
		case 0: 
			return s.getMaSach();
		case 1:
			return s.getTuaSach();
		case 2:
			return s.getTacGia();
		case 3:
			return s.getNamXuatBan();
		case 4:
			return s.getNhaXuatBan();
		case 5:
			return s.getSoTrang();
		case 6:
			return s.getDonGia();
		case 7:
			return s.getISBN();
		}
		return new String();
	}
	
	
	public void setValueAt(Object value, int row, int col) {
		Sach s = ds.getElement(row);
		switch(row) {
		case 0:
			s.setMaSach((String) value);
			break;
		case 1:
			s.setTuaSach((String) value);
			break;
		case 2:
			s.setTacGia((String) value);
			break;
		case 3:
			s.setNamXuatBan((int) value);
			break;
		case 4:
			s.setNhaXuatBan((String) value);
			break;
		case 5:
			s.setSoTrang((int) value);
			break;
		case 6:
			s.setDonGia((double) value);
			break;
		case 7:
			s.setISBN((String) value);
		}
	}
	
	public String getColumnName(int col) {
		return colsNames[col];
	}
}
	
