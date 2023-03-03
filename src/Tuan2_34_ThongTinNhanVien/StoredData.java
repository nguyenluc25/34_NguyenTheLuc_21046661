package Tuan2_34_ThongTinNhanVien;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class StoredData {
	public void writeFile(Object obj, String path) throws Exception, IOException{
		FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(obj);
		oos.flush();
		oos.close();
	}
	
	public Object readFile(String path) throws Exception, IOException{
		Object obj = null;
		FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		obj = ois.readObject();
		ois.close();
		return obj;
	}
}
