package day03;

import java.util.Date;
import org.junit.Test;

public class TestDate {
	/**
	 * ≤‚ ‘getTime£®£©
	 */
	@Test
	public void testGetTime(){
		Date date = new Date();
		System.out.println(date);
		
		//1977 01 01 ms
		long time = date.getTime();
		System.out.println(time);
	}
	
	/**
	 * ≤‚ ‘testSetTime£®£©
	 */
	@Test
	public void testSetTime(){
		Date date = new Date();
		System.out.println(date);
		
		long time = date.getTime();
		
		//add one day
		time += 1000 * 60 * 60 * 24;
		
		date.setTime(time);
		
		System.out.println(date);
	}
}
