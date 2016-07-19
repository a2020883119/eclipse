package day10;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.util.Date;

import org.junit.Test;



public class IOTeset {
	public static void main(String[] args) throws Exception {
//		fileIO();
//		fileIOBuf();
//		fileRW();
//		fileRWBuf();
//		fileRWBufL();
//		fileListShow();
//		fileIOByteConverChar();
		fileIOObj();
	}
	// FileInputStream and FileOutputStream
	// BufferedInputStream and BufferOutputStream
	@Test
	static void fileIOBuf() throws IOException{
		File file = new File("D:/tempTestJavaIO/test.java");
		File file2 = new File("D:/tempTestJavaIO/test2.java");
		System.out.println("file if exists:" + file.exists());
		try {
			FileInputStream fis = new FileInputStream(file);
			BufferedInputStream bufis = new BufferedInputStream(fis);
			byte [] temp = new byte [1024];
			int i = 0;
			i = bufis.read(temp);
			System.out.println(new String(temp, 0, i));
			System.out.println("i:" + i);
			
			fis.close();
			bufis.close();
			FileOutputStream fop = new FileOutputStream(file2, true);
			BufferedOutputStream bufops = new BufferedOutputStream(fop);
			System.out.println("temp.length:" + temp.length);
			System.out.println("i:" + i);
			bufops.write(temp, 0, i);
			bufops.write('\n');
			byte [] date = new Date().toString().getBytes();
			bufops.write(date, 0, date.length);
			bufops.flush();
			System.out.println(file2.length());
			fop.close();
			bufops.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	// FileInputStream and FileOutputStream
	@Test
	static void fileIO() throws IOException{
		System.out.println("----------input----------");
		File file = new File("D:/tempTestJavaIO/test.java");
		File file2 = new File("D:/tempTestJavaIO/test3.java");
		FileInputStream fis = new FileInputStream(file);
		System.out.println("if file exists\t\t:" + file.exists());
		System.out.println("if file\t\t\t:" + file.isFile());
		System.out.println("file size\t\t:" + file.length());
		System.out.println("file absolute path:\t\t" + file.getAbsolutePath());
		byte [] temp = new byte [1024];
		int i = fis.read(temp);
		fis.close();
		System.out.println("----------output---------");
		FileOutputStream fos = new FileOutputStream(file2, true);
		fos.write(temp, 0, i);
		System.out.println("if file exists\t\t:" + file2.exists());
		System.out.println("if file\t\t\t:" + file2.isFile());
		System.out.println("file size\t\t:" + file2.length());
		System.out.println("file absolute path\t:" + file2.getAbsolutePath());
		fos.close();
	}
	// FileRead and FileWrite
	@Test
	static void fileRW() throws Exception{
		File file = new File("D:/tempTestJavaIO/test.java");
		File file2 = new File("D:/tempTestJavaIO/test4.java");
		System.out.println("----------input----------");
		FileReader fr = new FileReader(file);
		System.out.println("if file exists\t\t:" + file.exists());
		System.out.println("if file\t\t\t:" + file.isFile());
		System.out.println("file size\t\t:" + file.length());
		System.out.println("file absolute path:\t\t" + file.getAbsolutePath());
		int i;
		char [] temp = new char[1024];
		i = fr.read(temp);
		fr.close();
		System.out.println("----------output---------");
		FileWriter fw = new FileWriter(file2, true);
		fw.write(temp, 0, i);
		fw.close();
		System.out.println("if file exists\t\t:" + file2.exists());
		System.out.println("if file\t\t\t:" + file2.isFile());
		System.out.println("file size\t\t:" + file2.length());
		System.out.println("file absolute path:\t\t" + file2.getAbsolutePath());
	}
	// FileRead and FileWrite
	// BufferedReader and BufferedWriter
	@Test
	static void fileRWBuf() throws IOException{
		File file = new File("D:/tempTestJavaIO/test.java");
		File file2 = new File("D:/tempTestJavaIO/test5.java");
		System.out.println("----------input----------");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int i;
		char [] temp = new char [1024];
		i = br.read(temp);
		br.close();
		fr.close();
		System.out.println("if file exists\t\t:" + file.exists());
		System.out.println("if file\t\t\t:" + file.isFile());
		System.out.println("file size\t\t:" + file.length());
		System.out.println("file absolute path:\t\t" + file.getAbsolutePath());
		System.out.println("----------output---------");
		FileWriter fw = new FileWriter(file2, true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(temp, 0, i);
		bw.flush();
		fw.close();
		bw.close();
		System.out.println("if file exists\t\t:" + file2.exists());
		System.out.println("if file\t\t\t:" + file2.isFile());
		System.out.println("file size\t\t:" + file2.length());
		System.out.println("file absolute path:\t\t" + file2.getAbsolutePath());
	}
	// FileRead and FileWrite
	// BufferedReader and BufferedWriter
	// readLine and writeLine
	@Test
	static void fileRWBufL() throws IOException{
		File file = new File("D:/tempTestJavaIO/test.java");
		File file2 = new File("D:/tempTestJavaIO/test6.java");
		System.out.println("----------input----------");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		int i = 0;
		char [] temp = new char [1024];
		String [] temp2 = new String[1024];
//		i = br.read(temp);
		while((temp2[i] = br.readLine()) != null){
			i++;
		}
		System.out.println("i:" + i);
		br.close();
		fr.close();
		System.out.println("if file exists\t\t:" + file.exists());
		System.out.println("if file\t\t\t:" + file.isFile());
		System.out.println("file size\t\t:" + file.length());
		System.out.println("file absolute path:\t\t" + file.getAbsolutePath());
		System.out.println("----------output---------");
		FileWriter fw = new FileWriter(file2, true);
		BufferedWriter bw = new BufferedWriter(fw);
//		bw.write(temp, 0, i);
		for(int j = 0; j < i; j++){
			bw.write(temp2[j] + "\n");
		}
		bw.flush();
		fw.close();
		bw.close();
		System.out.println("if file exists\t\t:" + file2.exists());
		System.out.println("if file\t\t\t:" + file2.isFile());
		System.out.println("file size\t\t:" + file2.length());
		System.out.println("file absolute path:\t\t" + file2.getAbsolutePath());
	}
	
	//show name of file list
	static void fileListShow(){
		File file = new File("D:/tempTestJavaIO");
		String [] listStr = file.list();
		for(String str : listStr){
			String [] temp = str.split("[.]");
//				System.out.print(temp[1] + "\t");
			String strr = "D:/tempTestJavaIO/" + str;
			System.out.println(str + "\t" + new File(strr).length() + " Byte\t" + new File(strr).canExecute());
		}
	}
	//InputStreamReander and OutputStreamWriter
	@Test
	static void fileIOByteConverChar() throws IOException{
		File file = new File("D:/tempTestJavaIO/test.java");
		File file2 = new File("D:/tempTestJavaIO/test7.java");
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		FileOutputStream fos = new FileOutputStream(file2);
		OutputStreamWriter osw = new OutputStreamWriter(fos);
		char [] temp = new char [1024];
		while(isr.read(temp) != -1){
			osw.write(temp);
		}
		isr.close();
		fis.close();
		osw.close();
		fos.close();
		System.out.println("OK");
	}
	//any test
	@Test
	static void test(){
//		File file = new File("haha.txt");
//		Runtime.getRuntime().exec("notepad haha.txt");
//		System.out.println(Runtime.getRuntime().totalMemory() / 1000.0 + " MB");
//		System.out.println(Runtime.getRuntime().freeMemory() / 1000.0 + " MB");
	}
	//
	@Test
	static void fileIOObj() throws Exception{
		File file = new File("D:/tempTestJavaIO/test8.java");
		Student stu = new Student(101,"小明",'M', "额南焦作");
		Student stu2 = new Student(102,"小好",'M', "河南焦作");
		Student stu3 = new Student(103,"小的",'W', "河南地方");
		Student stu4 = new Student(104,"小单",'W', "河的焦作");
		FileOutputStream fos = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(stu);
		oos.writeObject(stu2);
		oos.writeObject(stu3);
		oos.writeObject(stu4);
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream iso = new ObjectInputStream(fis);
		Object obj = iso.readObject();
		Object obj2 = iso.readObject();
		Object obj3 = iso.readObject();
		Object obj4 = iso.readObject();
		Student stuu = (Student)obj;
		Student stuu2 = (Student)obj2;
		Student stuu3 = (Student)obj3;
		Student stuu4 = (Student)obj4;
		System.out.println(stuu.getId() + "\t" + stuu.getName() + "\t" + stuu.getGender() + "\t" + stuu.getAddr());
		System.out.println(stuu2.getId() + "\t" + stuu2.getName() + "\t" + stuu2.getGender() + "\t" + stuu2.getAddr());
		System.out.println(stuu3.getId() + "\t" + stuu3.getName() + "\t" + stuu3.getGender() + "\t" + stuu3.getAddr());
		System.out.println(stuu4.getId() + "\t" + stuu4.getName() + "\t" + stuu4.getGender() + "\t" + stuu4.getAddr());
	}
	
	
	
	
}
