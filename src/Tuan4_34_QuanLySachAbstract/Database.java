package Tuan4_34_QuanLySachAbstract;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Database {
	private static final String FILENAME = "data/sach.txt";
	
	public static void ghiXuongFile(ArrayList<Sach> dsSach) {
		BufferedWriter bw;
		try {
			FileWriter fw = new FileWriter(FILENAME);
			bw = new BufferedWriter(fw);
			bw.write("MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN\n");
			for(Sach s : dsSach) {
				bw.write(s.toString() + "\n");
			}
			bw.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			//Nguyễn Thế Lực
		}
	}
	
	public static ArrayList<Sach> docTuFile(){
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		BufferedReader br = null;
		try {
			File f = new File(FILENAME);
			if(f.exists()) {
				FileReader fr = new FileReader(FILENAME);
				br = new BufferedReader(fr);
				br.readLine();
				while(br.ready()) {
					String line = br.readLine();
					if(line != null && !line.trim().equals("")){
						String[] data = line.split(";");
						Sach sach = new Sach(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], Integer.parseInt(data[5]), Double.parseDouble(data[6]), data[7]);
						dsSach.add(sach);
					}
				}
				br.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dsSach;
	}
}
