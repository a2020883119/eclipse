package day10;
import java.io.*;

import day18.Product;

public class TestDataOutput_InputStream {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("d:/gege.java");
		try{
			FileOutputStream fs = new FileOutputStream(file);
			DataOutputStream da = new DataOutputStream(fs);
			da.writeUTF("使用writeUTF写入");
			da.writeChars("使用writeChars写入");
			da.writeBytes("使用writeBytes写入");
			da.close();
			fs.close();
			FileInputStream fis = new FileInputStream(file);
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readUTF());
			System.out.println(dis.readChar());
			System.out.println(dis.readByte());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}

}

//File file = new File("d:/tempTestJavaIO/product.txt");
//try{
//	if(!file.exists()){
//		file.createNewFile();
//	}
//	FileOutputStream fos = new FileOutputStream(file);
//	ObjectOutputStream oos = new ObjectOutputStream(fos);
//	oos.writeObject(p1);
//	oos.close();
//	fos.close();
//}
//catch(Exception e){
//	e.printStackTrace();
//}
//
//try{
//	FileInputStream fis = new FileInputStream(file);
//	ObjectInputStream ois = new ObjectInputStream(fis);
//	Product product = (Product)ois.readObject();
//	System.out.println(product.getDate());
//	ois.close();
//	fis.close();
//}
//catch(Exception e){
//	e.printStackTrace();
//}
