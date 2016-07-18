package day05;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.StringTokenizer;

import org.junit.Test;


public class TestFile {
	
	@Test
	public void testLength(){
		File file = new File("haha.txt");
		System.out.println(file);
	}
	
	@Test
	public void testFile(){
		File parent = new File("parent");
		File son = new File(parent, "son.java");
		System.out.println(son);
		System.out.println(parent);
		System.out.println(son.isFile());
		System.out.println(parent.isDirectory());
		son.mkdir();		
	}
	
	@Test
	public void testFile2() throws IOException{
		File file = new File("src"+File.separator+"test.java");
		if(file.exists()){
			file.createNewFile();
			System.out.println("create file is OK!");
		}
		System.out.println("already has one!");
	}
	
	@Test
	public void testListFiles(){
		File dir = new File(".."+File.separator+".."+File.separator+".."+File.separator+"..");
		File []  subs = dir.listFiles();
		for(File sub : subs){
			System.out.println(sub);
		}
	}

	@Test
	public void testFilterFilter(){
		File parent = new File(".");
		File [] sons = parent.listFiles(new FileFilter(){
			public boolean accept(File file){
				return file.getName().endsWith(".txt");
			}
		});
		for(File son : sons){
			System.out.println(son);
		}
	}
	
	@Test
	public void testWrite()throws Exception{
		RandomAccessFile raf = new RandomAccessFile("haha.txt", "rw");
		raf.write(33);
		raf.close();
	}
	
	@Test
	public void testRead()throws Exception{
		RandomAccessFile raf = new RandomAccessFile("haha.txt", "r");
		int d = raf.read();
		System.out.println(d);
	}
	
	@Test
	public void testWriteByteArry()throws Exception{
		RandomAccessFile raf = new RandomAccessFile("haha.txt", "rw");
		byte [] buf = "hello world!".getBytes();
		raf.write(buf);
		raf.close();
	}
	
	@Test
	public void testReadByteArry()throws Exception{
		RandomAccessFile raf = new RandomAccessFile("haha.txt", "r");
		byte [] buf = new byte[100];
		int count = raf.read(buf);
		System.out.println(count);
		System.out.println(new String(buf));
		raf.close();
	}
	
	@Test
	public void testPointer()throws Exception{
		RandomAccessFile raf = new RandomAccessFile("haha.txt", "r");
		System.out.println("指针位置:" + raf.getFilePointer());
		raf.skipBytes(5);
		System.out.println("指针位置:" + raf.getFilePointer());
		byte [] buf = new byte[10];
		int count = raf.read(buf);
		System.out.println("读出的内容：" + new String(buf) + "\n长度：" + count);
		raf.seek(0);
		System.out.println("指针位置:"+raf.getFilePointer());
		raf.close();
	}

	@Test
	public void test(){
		int a = 10;
		int b = 11;
		System.out.println("a:" + a + ", b:" + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println("a:" + a + ", b:" + b);
	}

	@Test
	public void testArrays_fill(){
		long startM = Runtime.getRuntime().totalMemory();
		System.out.println("startM:" + startM);
		int [] arr = new int[5];
		Arrays.fill(arr, 9);
		for(int a : arr){
			System.out.print(a + ", ");
		}
		
		System.out.println("");
		Arrays.fill(arr, 3, 4, 8);
		for(int a : arr){
			System.out.print(a + ", ");
		}
		
		System.out.println("");
		Arrays.sort(arr);
		for(int a : arr){
			System.out.print(a + ", ");
		}
		
		System.out.println("");
		int arr2[] = Arrays.copyOf(arr, 20);
		for(int a : arr2){
			System.out.print(a + ", ");
		}
		System.out.println("");
		System.out.println("arr2.length:" + arr2.length);
		System.out.println("arr.length:" + arr.length);
		
		int arr3[] = Arrays.copyOfRange(arr, 1, 3);
		for(int a : arr3){
			System.out.print(a + ", ");
		}
		System.out.println("");
		System.out.println("arr3.length:" + arr3.length);
		System.out.println("arr.length:" + arr.length);
		
		long endM = Runtime.getRuntime().totalMemory();
		System.out.println("endM:" + endM);
	}
	
	@Test
	public void insert(){
		int [] array = new int []{1, 5, 2, 7, 4, 8};
		System.out.println("排序前：");
		for(int a : array){
			System.out.print(a + "  ");
		}
		int temp;//要插得值
		int j;//要插得位置
		for(int i = 1; i < array.length; i++){
			temp = array[i];
			for(j = i - 1; j >= 0 && array[j] > temp; j--){
				array[j + 1] = array[j];
			}
			array[j + 1] = temp;
		}
		System.out.println("排序后：");
		for(int a : array){
			System.out.print(a + "  ");
		}
	}
	
	@Test
	public void string(){
		char [] a = {'s', 't', 'u', 'd', 'e', 'n', 't'};
		String aarr = new String(a, 3, 3);
		System.out.println(aarr);
		String arrr1 = new String(a);
		System.out.println(arrr1.indexOf("ud"));
		System.out.println(arrr1.lastIndexOf("nt"));
		System.out.println(arrr1.charAt(4));
		String haha = "    s h i s h iq u d i ao k o n g ge   ";
		System.out.println(haha.trim());
		StringTokenizer st = new StringTokenizer(haha, " ");
		StringBuffer sb = new StringBuffer();
		while(st.hasMoreTokens()){
			sb.append(st.nextToken());
		}
		System.out.println(new String(sb));
		haha = haha.replace(" ", "");
		System.out.println(haha);
		haha = haha.replaceFirst("s", "xxxxx");
		System.out.println(haha);
		
	}

	@Test
	public void testString(){
		String s1 = "I am Guo Jinsheng";
		String s4 = new String("I am Guo Jinsheng");
		String s2 = s1.toLowerCase();
		String s3 = s1.toUpperCase();
		System.out.println(s1.equals(s2));//  equals 比较每个字符 区分大小写 字符总长度
		System.out.println(s1.equalsIgnoreCase(s2)); //忽视大小写
		System.out.println(s1 == s4);
		System.out.println(s1 == s1);// == 比较内存地址
		
	}

	@Test
	public void testSplit(){
		String str = "123,234,124,124,124,3,2,23.24.15";
		String [] strSplit = str.split("[,.]");
		for(String strT : strSplit){
			System.out.println(strT);
		}
	}
	
	@Test
	public void testStringIfNumber(){
		String str= "123456789o7";
		
		char [] strCharArr = str.toCharArray();
		for(int i = 0; i < strCharArr.length; i++){
			if(!Character.isDigit(strCharArr[i])){
				System.out.println(str+"不是数字！");
				return;
			}
		}
		System.out.println(str+"是数字！");
	}

	
	@Test
	public void haha(){
		
	}
	
	
	
	
}
