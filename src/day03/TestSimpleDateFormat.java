package day03;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class TestSimpleDateFormat {
	/**
	 * test format() 
	 */
	@Test
	public void testFormat(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		Date date = new Date();
		System.out.println(sdf.format(date));
	}
	
	/**
	 * test parse()
	 * @throws ParseException 
	 */
	@Test
	public void testParse() throws ParseException{
		String string = new String("2014-11-12 12:12:12 ÐÇÆÚÒ»");
		System.out.println(string);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		Date date;
		date = sdf.parse(string);
		System.out.println(date);
	}
}
