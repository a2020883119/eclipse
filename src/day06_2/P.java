package day06_2;

public class P {
	public static void main(String [] arg){
		Cb cb100 = new Cb();

//		int [][] a = new int[1][100];
//		System.out.println(a[0].length);
//		Cb cb = new Cb(20);
		for(int i = 1; i < 150; i++){
			cb100.add(i);
		}
		
//		cb100.add(1, 222);
//		cb100.remove();
//		Cb  cbn = new Cb(120);
//		cb100.add(1);
//		cb100.add(1);
//		cb100.add(140, 5);
		cb100.remove(100);
		show(cb100);
		System.out.println();
//		cb100.change(101, 100);
//		show(cb);
//		System.out.println(cb100.find(99));
//		System.out.println(cb100.findLast(88));
		
	}
	
	static void show(Cb cb){
		int count = 0;
		for(int i = 0; i <= cb.vl / cb.va[0].length; i++){
			for(int j = 0; j < cb.va[0].length; j++){
				if(count == cb.vl){
					return;
				}
				System.out.print(cb.va[i][j] + "  ");
				count++;
			}
		}
	}
}
