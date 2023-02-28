package Tuan2_34_ThongTinNhanVien;

import java.util.ArrayList;

public class NhanVien_Collection {
	private ArrayList<NhanVien> dsNV;
	
	public NhanVien_Collection() {
		dsNV = new ArrayList<NhanVien>();
	}
	
	// Them nhan vien
	public boolean themNhanVien(NhanVien nv) {
		if(dsNV.contains(nv))
			return false;
		dsNV.add(nv);
		return true;
	}
	
	public boolean xoaNhanVien(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
		return false;
	}
	
	public NhanVien timKiem(String maNV) {
		NhanVien nv = new NhanVien(maNV);
		if(dsNV.contains(nv))
			return dsNV.get(dsNV.indexOf(nv));
		return null;
	}
	
	public ArrayList<NhanVien> getDsNV(){
		return dsNV;
	}
	
	public void setDsNV(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}
	
	public NhanVien getElement(int index) {
		if(index < 0 || index >= dsNV.size())
			return null;
		return dsNV.get(index);
	}
	
	public int getSize() {
		return dsNV.size();
	}
 }
