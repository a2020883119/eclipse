package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import org.junit.Test;

public class Sells {
	public static void main(String [] args) throws ParseException {
		
		getDate(getTime());;
		
	}
	/**
	 * get product birthday
	 * @return
	 * @throws ParseException 
	 */
	@Test
	public static Date getTime() throws ParseException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("for example:2014-12-12");
//		String getInputString = scanner.next();
		String getInputString = "2014-12-12";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(getInputString);
		System.out.println(date);
		return date;
	}
	/**
	 * 
	 */
	@Test
	public static void getDate(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		Scanner scanner = new Scanner(System.in);
		System.out.println("please input day:");
//		int days = scanner.nextInt();
		int days = 21;
		calendar.add(Calendar.DAY_OF_WEEK, days - 14);
		int weekday = calendar.get(Calendar.DAY_OF_WEEK);
		System.out.println(weekday);
		if (weekday - 3 == 0) {
			weekday =(3 - weekday);
			
		}if (weekday - 3 > 0) {
			weekday =(weekday - 3);
		}
		System.out.println(weekday);
		date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E");
		System.out.println(sdf.format(date));
		
	}
}
