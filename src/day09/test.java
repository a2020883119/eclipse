package day09;

public class test {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long time = System.currentTimeMillis();	
		for (int i = 0; i < 100000; i++) {
			for (int j = 0; j < 1000000; j++) {
			}
		}
		long time2 = System.currentTimeMillis();
		System.out.println(time2 - time + "ms");
	}

}
