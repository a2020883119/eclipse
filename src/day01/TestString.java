package day01;

import java.util.Scanner;

import org.junit.Test;


public class TestString {
	@Test
	public void testConstantPool(){
		String s1 = "hello";
		String s2 = "hello";
		System.out.println(s1 == s2);
		String s3 = new String("hello");
		System.out.println(s1 == s3);
		
		String indexOfString = "I can because i think i can.";
		System.out.println(indexOfString.indexOf("can") + 1);
		System.out.println(indexOfString.indexOf("can", 5));
		System.out.println(indexOfString.indexOf("cana", 7));
		
		String subString = "I can because i think i can.";
		System.out.println(subString.substring(7, 17));
		System.out.println(subString.substring(7));
		System.out.println(subString.substring(7, 17));
		
		String trimString = " I can because i think i can. ";
		System.out.println(trimString);
		System.out.println(trimString.length());
		System.out.println(trimString = trimString.trim());
		System.out.println(trimString.length());
		
		String charAtString = " I can because i think i can. ";
		for(int i = 0; i < charAtString.length(); i++){
			char c = charAtString.charAt(i);
			System.out.print(c + " ");
		}
		System.out.println();
		
		String endsWith = "I can because i think i can.";
		System.out.println(endsWith.endsWith("."));
		System.out.println(endsWith.endsWith("a"));
		System.out.println(endsWith.startsWith("."));
		System.out.println(endsWith.startsWith("I"));
		
		String upperAndLower = "I can because i think i can.";
		System.out.println(upperAndLower.toLowerCase());
		System.out.println(upperAndLower.toUpperCase());
		
		double pi = 3.1415926;
		int value = 123;
		char [] charArr = {'a', 'b', 'c', 'd', 'e', 'f'};
		boolean boo = true;
		System.out.println(String.valueOf(pi));
		System.out.println(String.valueOf(value));
		System.out.println(String.valueOf(charArr));
		System.out.println(String.valueOf(boo));
		
		StringBuffer sBuffer = new StringBuffer("Programming Language:");
		sBuffer.append("java").append(" cpp").append(" C#").append(" objective-c");
		System.out.println(sBuffer);
		
		System.out.println(sBuffer.indexOf("C#"));
		System.out.println(sBuffer.insert(29, " php"));
		
		System.out.println(sBuffer.delete(0, 12));
		
		String testSubString = "someapp/manager/emplist.action";
		System.out.println(testSubString.substring(16));
		
		String huiwen = "abccba";
		StringBuffer wenhui = new StringBuffer(huiwen);
		System.out.println(wenhui.reverse().toString().equals(huiwen));
		
		char a = '你';
		int c = a;
		System.out.println(c);
		for (int i = 0; i < 1; i++) {
			int u = i;
			char s = (char)u;
			System.out.print(" 【" + i + "】" + s);
			if (i % 10 == 0) {
				System.out.println();
			}
		}
		
		String emailRegEx = "[0-9]{5,10}+@[Qq]{2}\\.[com]{3}";
		Scanner scanner = new Scanner(System.in);
		String email = "490187769@qq.com";
		System.out.println(email.matches(emailRegEx));
		email = "123@11.cn";
		System.out.println(email.matches(emailRegEx));
		
		String splitString = "hah1a, o1o, nih1ao,  h1aha, o1k,ba1baba, ";
		String [] getSplitStrings = splitString.split(",");
		for (String string : getSplitStrings) {
			System.out.print("*" + string + "*-");
		}
		System.out.println();
		splitString = splitString.replaceAll("\\d", "数字");
		System.out.println("\\t");
		System.out.println(splitString);
		System.out.println( getSplitStrings.toString());
		System.out.println( getSplitStrings);
		
		
		String s11,s21,s31,s4;       
		s11=new String("we are students");      
		s21="We are students";       
		s31="We are students";
		s4=new String(s11);
		System.out.println(s11.equals(s21));           
		System.out.println(s11 == s21);           
		System.out.println(s31==s21);       
		System.out.println(s11.equals(s4));           
		System.out.println(s11==s4);
		
		Number d = 1234.1234;
		Number f = 12345;
		
		System.out.println(d.getClass().getName());
		System.out.println(f.getClass().getName());
		
		System.out.println(d.intValue());
		System.out.println(f.intValue());
		System.out.println(d.doubleValue());
		System.out.println(f.doubleValue());
		
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		//正则表达式不加空格
		String emailRegString = "^[a-zA-Z0-9_\\\\.-]+@([a-zA-Z0-9]+\\.)+[a-zA-Z0-9]{2,4}$";
		System.out.println(email.matches(emailRegString));
		System.out.println(email);
		
		String splitString2 = "java cpp php c# o-c";
		String [] getSpliString = splitString2.split(" ");
		for (String string : getSpliString) {
			System.out.print(string);
		}
		System.out.println();
		
		String splitString3 = "100+200+3-400=1234";
		String [] getSpliString2 = splitString3.split("[\\+\\-=]");
		for (String string : getSpliString2) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		String numString = "abc124haha4332ahah4h3h3";
		System.out.println(numString.replaceAll("\\d+", "数字"));
		System.out.println(numString.replaceAll("\\d", "数字"));
		System.out.println(numString.replaceAll("\\w+", "字"));
		System.out.println(numString.replaceAll("\\w", "字"));
		
		
		
		
	}

}
