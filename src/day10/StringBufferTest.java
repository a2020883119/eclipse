package day10;

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		show();
	}
	public static void show(){
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(true);
		strBuf.append("as.kld.jflk.asd.jf.");
		String [] str = strBuf.toString().split("[.]");
		System.out.println(strBuf);
		for(String s : str){
			System.out.println(s);
		}
		strBuf.append("           afsdf");
		System.out.println("substring: " + strBuf.substring(2, 8));
		System.out.println("trim: "+strBuf.toString().trim());
		System.out.println("replace: "+strBuf.toString().replaceAll(" ", ""));
		System.out.println("strBuf"+strBuf.toString());
	}
}
