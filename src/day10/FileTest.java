package day10;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {
	public static void main(String [] args) throws IOException{
		File file = new File("d:/123", "word.txt");
		File file2 = new File("d:\\321/word2.txt");
//		file.delete();
//		file2.delete();
		System.out.println(file.exists());
		System.out.println(file2.exists());
		file.createNewFile();			//创建文件
		file2.createNewFile();
		file.mkdir();
		System.out.println(file.getAbsolutePath() +""+ file.lastModified());
		System.out.println(file2.getAbsolutePath());
	}
	@Test
	public void testFile(){
		File file = new File("d:\test", "word.txt");
		
	}
}
