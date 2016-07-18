package day05;
import java.util.Map;
import org.junit.Test;
import java.util.HashMap;
import java.util.Collections;
public class TestHashMap {
	
	/**
	 * 统计空气质量监测点pm的最高值
	 */
	@Test
	public void test1(){
		String pm25 = "农展馆=423,东四=134,西斯=435,妈咪=742,毫升=435,减肥=345,那就=954,天台=234,后台=365,抬抬=333,妈的=123,就在=765,领导=365,划分=123,通过=432,西斯=234,里面=567,日常=546,晚上=546,请问=234,简单=543,显示=567,尼玛=432,日头=231,启动=432,日照=258,焦作=12,北京=43,饺子=344,考考=432,司考=3423,马克=234,简单=342,加上=234,阿斯=324,阿斯蒂芬=342,阿萨德=321,你猜是=324";
		String [] a = pm25.split("[=,]");
		for(String str : a){
			System.out.print(str + " ");
		}
		System.out.println();
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i = 0; i < a.length; i += 2){
			map.put(a[i], Integer.parseInt(a[i + 1]));
		}
		System.out.println(map);
	}
}
