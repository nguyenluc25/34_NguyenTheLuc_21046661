package Tuan4_34_QuanLySachAbstract;

import java.util.ArrayList;



public class Sach_Collection {
	private ArrayList<Sach> dsSach;
	
	public Sach_Collection() {
		dsSach = new ArrayList<Sach>();
	}
	
	public void napDuLieuTuFile() {
		dsSach = Database.docTuFile();
	}
	
	public boolean themSach(Sach sach) {
		if(!dsSach.contains(sach)) {
			dsSach.add(sach);
			return true;
		}
		else 
			return false;
	}
	
	public boolean xoaSach(String maSach) {
		Sach sach = new Sach(maSach);
		if(dsSach.contains(sach)) {
			dsSach.remove(sach);
			return true;
		}
		else 
			return false;
	}
	
	public Sach timKiem(String maSach) {
		Sach sach = new Sach(maSach);
		if(dsSach.contains(sach))
			return dsSach.get(dsSach.indexOf(sach));
		else 
			return null;
	}
	
	public int getSize() {
		return dsSach.size();
	}
	
	public Sach getElement(int index) {
		if(index < 0 || index > dsSach.size())
			return null;
		else
			return dsSach.get(index);
	}

	public ArrayList<Sach> getDsSach() {
		return dsSach;
	}

	public void setDsSach(ArrayList<Sach> dsSach) {
		this.dsSach = dsSach;
	}
	
	
}
