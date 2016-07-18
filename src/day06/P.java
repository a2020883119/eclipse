package day06;

public class P {
	public static void main(String [] arg){
//		Cb cb100 = new Cb();
		Cb cb = new Cb(20);
		for(int i =1; i < 111; i++){
			cb.add(i);
		}
//		cb100.
//		Cb  cbn = new Cb(120);
//		cb100.add(1);
//		cb100.add(1);
//		cb100.add(1);
//		cb100.remove(100);
//		cb100.add(102, 5);
//		cb100.change(101, 100);
//		show(cb100);
		show(cb);
//		System.out.println(cb100.find(23));
//		System.out.println(cb100.findLast(99));
		
	}
	
	static void show(Cb cb){
		int zz = cb.vl;
		for(int i = 0; i < cb.max; i++){
			if(i + 1== cb.vl && cb.vl != 0){
				System.out.println("["+ (i + 1) +"]\t\t" + cb.va[i] + "\t <-------指针[vl]-["+cb.vl+"] 缓冲区[max]-["+cb.max+"]");
				continue;
			}
			if(zz == 0){
				System.out.println("\t\t\t <-------指针[vl]-["+cb.vl+"] 缓冲区[max]-["+cb.max+"]");
				zz++;
			}
			
			System.out.println("["+ (i + 1) +"]\t\t" + cb.va[i]);
		}
	}
}
