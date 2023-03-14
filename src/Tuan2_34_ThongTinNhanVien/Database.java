package Tuan2_34_ThongTinNhanVien;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Database {
	private static String FILENAME = "data/DsNV.txt";
	
	public static void ghiXuongFile(ArrayList<NhanVien> ds) {
		BufferedWriter bw;
		
		try {
			FileWriter fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write("MaNV;Ho;Ten;Phai;Tuoi;TienLuong\n");
			for(NhanVien nv : ds) {
				bw.write(nv.toString() + "\n");
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static ArrayList<NhanVien> docTuFile(){
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		BufferedReader br = null;
		
		try {
			File f = new File(FILENAME);
			if(f.exists()) {
				FileReader fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);
				br.readLine();
				while(br.ready()) {
					String line = br.readLine();
					if(line != null && !line.trim().equals("")) {
						String[] data = line.split(";");
						boolean p = false;
						if(data[3].equals("true")) {
							p = true;
						}
						NhanVien nv = new NhanVien(data[0], data[1], data[2], p, Integer.parseInt(data[4]), Double.parseDouble(data[5]));
						ds.add(nv);
					}
				}
				br.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return ds;
	}
}
