package Tuan4_34_QuanLySach;

public class Sach {
	private String maSach;
	private String tuaSach;
	private String tacGia;
	private int namXuatBan;
	private String nhaXuatBan;
	private int soTrang;
	private double donGia;
	private String ISBN;
	public Sach() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Sach(String maSach) {
		this.maSach = maSach;
	}
	
	public Sach(String maSach, String tuaSach, String tacGia, int namXuatBan, String nhaXuatBan, int soTrang,
			double donGia, String iSBN) {
		super();
		this.maSach = maSach;
		this.tuaSach = tuaSach;
		this.tacGia = tacGia;
		this.namXuatBan = namXuatBan;
		this.nhaXuatBan = nhaXuatBan;
		this.soTrang = soTrang;
		this.donGia = donGia;
		ISBN = iSBN;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maSach == null) ? 0 : maSach.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sach other = (Sach) obj;
		if (maSach == null) {
			if (other.maSach != null)
				return false;
		} else if (!maSach.equals(other.maSach))
			return false;
		return true;
	}
	
	
}
