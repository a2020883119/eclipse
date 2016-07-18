package day10;

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
}
