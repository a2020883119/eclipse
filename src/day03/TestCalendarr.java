package day03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

public class TestCalendarr {
	/**
	 * test getInstance
	 */
	@Test
	public void testGetInstance(){
		Calendar calendar = Calendar.getInstance();
		System.out.println("ʵ�����ͣ�" + calendar.getClass().getName());
		System.out.println("����ʱ�䣺" + calendar.getTime());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss E");
		//System.out.println("����ʱ�䣺" + sdf.format(calendar));
		Date date = new Date();
//		date = date.setTime(calendar);
//		date.getTime();
		
	}
	
	
	
	
}
