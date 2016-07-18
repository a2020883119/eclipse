package day05;

import java.util.Scanner;

public class TenToTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(true){
			System.out.println("-----------------------------------------------------------");
			System.out.print("num-a:");
			int a, b;
			a = scanner.nextInt(); 
			System.out.print("num-b:");
			b = scanner.nextInt();
			System.out.println("原来数a:\t\t"+ttt(a));
			System.out.println("Ioper:\t\t"+ttt(Ioper(a, b)));;
			System.out.println("LSL:\t\t"+ttt(LSL(a)));
			System.out.println("运算后\t\ta:"+a+" b:"+b);
			if(a == 0){
				break;
			}
		}
	}
	public static String ttt(int a){
		String str = "";
		int b;
		for(int i = 1; i <= 32; i++)
		{
			b = a;
			b = b >>> 31;
			str += Integer.toString(b);
			if(i % 4 == 0){
				str += " ";
			}
			a = a << 1;
		}
		return str;
	}
	
	
	public static int Ioper(int a, int b){
		int temp;
		for(int i = 1; i <= b; i++)
		{
	 		
			temp = a;
			a = a << 1;
			System.out.println("\t\t\t\t第"+ i + "次");
			System.out.println("a << 1后\t\t" + ttt(a));
			System.out.println("temp >>> 31前\t"+ ttt(temp));
			temp = temp >>> 31;
			System.out.println("temp >>> 31后\t"+ ttt(temp));
			a = a | temp;
			System.out.println("a | temp后\t" + ttt(a));
		}
		return a;
	}
	
	public static int LSL(int a){
		return Ioper(a, 16);
	}

}
