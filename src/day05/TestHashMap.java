package day05;
import java.util.Map;
import org.junit.Test;
import java.util.HashMap;
import java.util.Collections;
public class TestHashMap {
	
	/**
	 * ͳ�ƿ�����������pm�����ֵ
	 */
	@Test
	public void test1(){
		String pm25 = "ũչ��=423,����=134,��˹=435,����=742,����=435,����=345,�Ǿ�=954,��̨=234,��̨=365,̧̧=333,���=123,����=765,�쵼=365,����=123,ͨ��=432,��˹=234,����=567,�ճ�=546,����=546,����=234,��=543,��ʾ=567,����=432,��ͷ=231,����=432,����=258,����=12,����=43,����=344,����=432,˾��=3423,���=234,��=342,����=234,��˹=324,��˹�ٷ�=342,������=321,�����=324";
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
