package day10;

public class Equals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "1234";
		String str2 = "1234";
		String str3 = new String("1234");
		String str4 = new String("1234");
		
		System.out.println("------  equals  --------");
		if(str.equals(str2)){
			System.out.println("str.equals(str2): " + str.equals(str2));
		}else{
			System.out.println("str.equals(str2): " + str.equals(str2));			
		}
		if(str.equals(str4)){
			System.out.print("str.equals(str4): ");
			System.out.println(str.equals(str4));
		}else{
			System.out.print("str.equals(str4): ");
			System.out.println(str.equals(str4));
		}
		System.out.println("------  ==  --------");
		if(str == str2){
			System.out.print("str == str2: ");
			System.out.println(str == str2);
		}else{
			System.out.print("str == str2: ");
			System.out.println(str == str2);			
		}
		if(str == str4){
			System.out.print("str == str4: ");
			System.out.println(str == str4);
		}else{
			System.out.print("str == str4: ");
			System.out.println(str == str4);
		}
		
	}

}
