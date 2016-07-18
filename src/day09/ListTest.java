package day09;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class ListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		System.out.println("-------------------------first-------------------------------");
		/**
		 * first
		 */
		//get data size 100 | 100w list
		final int size = 100;
		Random ran = new Random();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++){
			list.add(ran.nextInt(100));
		}
		show(list);
		System.out.println("前三分之一数量：" + list.size() / 3);
		long one = System.currentTimeMillis();
		
		System.out.println("-------------------------second-------------------------------");
		/**
		 * second
		 */
		//sort one third list data
		int temp;
		int j;
		for(int i = 1; i <= list.size() / 3; i++){
			temp = list.get(i);
			for(j = i - 1; j >= 0 && list.get(j) > temp; j--){
				list.set(j + 1, list.get(j));
			}
			list.set(j + 1, temp);
			System.out.println("i:" + i);
		}
		show(list);
		System.out.println("前三分之一数量：" + list.size() / 3 + "\n前三分之一排序完成 ");
		for(int i = list.size() / 3; i <= list.size() - 1; i++){
			temp = list.get(i);
			for(j = i - 1; j >= 0 && list.get(j) > temp; j--){
				list.set(j + 1, list.get(j));
			}
			list.set(j + 1, temp);
			System.out.println("i:" + i);
		}	
		System.out.println("后三分之二插入之后：");
		show(list);
		System.out.println("list.size():" + list.size());
		
		long two = System.currentTimeMillis();
		System.out.println("-------------------------third-------------------------------");
		/**
		 * third
		 */
		int intTem;
		int i = -1;
		int k = 0;
		while(k < size){
			i++;
			intTem = list.get(i);
			if(intTem / 3 == intTem / 3.0){
				list.remove(i);
				i--;
			}
			k++;
		}
		show(list);
		long end = System.currentTimeMillis();
		System.out.println(one - start);
		System.out.println(two - one);
		System.out.println(end - two);
		System.out.println(end - start);
	}
	/**
	 * 显示方法
	 * @param list
	 */
	public static void show(List<Integer> list){
		int count = 0;
		Iterator ite = list.iterator();
		count = 0;
		while(ite.hasNext()){
			System.out.println("[" + count + "]\t"+ite.next());
			count++;
		}
		System.out.println("list.size:" + list.size());
	}

}
