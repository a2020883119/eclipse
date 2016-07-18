package day03;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

public class TestCalendar {
	/**
	 * test getInstance() method
	 */
	@Test
	public void testGetInstance(){
		Calendar c =  Calendar.getInstance();
		System.out.println(c.getClass().getName());
		System.out.println(c.getTime());
		System.out.println(c.getTimeZone());
		
		GregorianCalendar g = new GregorianCalendar(2013, Calendar.DECEMBER, 25);
		System.out.println(g.getTime());
		
		
	}
	/**
	 * test set() method
	 */
	@Test
	public void testSet(){
		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime());
		c.set(Calendar.YEAR, 2013);
		c.set(Calendar.MONTH, Calendar.DECEMBER);
		c.set(Calendar.DATE, 25);
		c.set(Calendar.HOUR, 22);
		System.out.println(c.getTime());
	}
	/**
	 * test Get method
	 */
	@Test
	public void testGet(){
		Calendar c = Calendar.getInstance();
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);
	}
	/**
	 * output the number of days of month in a year
	 */
	@Test
	public void testGetActualMaximum(){
		int year = 2016;
		Calendar c = Calendar.getInstance();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.DATE, 1);
		
		for (int month = Calendar.JANUARY; month < Calendar.DECEMBER; month++) {
			c.set(Calendar.MONTH, month);
			System.out.println(year + " " + month + " " + c.getActualMaximum(Calendar.DATE) + " ");
		}
	}
	
	/**
	 * test add() method 
	 * 
	 */
	@Test
	public void testAdd(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, +1);
		System.out.println(calendar.getTime());
		calendar.add(Calendar.MONTH, -3);
		System.out.println(calendar.getTime());
	}
	/**
	 * test setTime() and getTime() method 
	 */
	@Test
	public void testSetTimeAndGetTime(){
		Calendar calendar = Calendar.getInstance();
		Date date = new Date();
		
		calendar.setTime(date);
		System.out.println(calendar.getTime());
		date = calendar.getTime();
		System.out.println(date);
	}
	
	
}
