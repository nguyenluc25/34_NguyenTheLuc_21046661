package Tuan2_34_ThongTinNhanVien;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVien_Collection implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<NhanVien> dsNV;
	
	public NhanVien_Collection() {
		dsNV = new ArrayList<NhanVien>();
	}
	
	//thêm 1 nhân viên vào danh sách
	public boolean themNhanVien(NhanVien nv) {
		if(dsNV.contains(nv))
			return false;
		dsNV.add(nv);
		return true;
	}
	//Tìm kiếm nhân viên khi biết mã nhân viên
	public NhanVien timKiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv))
			return dsNV.get(dsNV.indexOf(nv));
		return null;
	}
	//Xóa nhân viên khi biết mã nhân viên
	public boolean xoaNhanVien(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
		return false;
	}
	
	//trả về số lượng phần tử trong danh sách
	public int getSize() {
		return dsNV.size();
	}
	
	//phương thức lấy 1 phần tử tại vị trí chỉ định index
	public NhanVien getElement(int index) {
		if(index < 0 || index > dsNV.size())
			return null;
		return dsNV.get(index);
	}

	public ArrayList<NhanVien> getDsNV() {
		return dsNV;
	}

	public void setDsNV(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}

}