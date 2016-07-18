package day03;

import org.junit.Test;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.util.Collections;
//import org.junit.Test;

public class TestCollectionn {
	/**
	 * 
	 */
	@Test
	public void addAll_containsAll(){
		Collection<String> cells = new ArrayList<String>();
		cells.add("one");
		cells.add("two");
		cells.add("three");
		cells.add("four");
		System.out.println("Collection<String> cells?\t" + cells);
		
		
		Collection<String> strList = new ArrayList<String>();
		strList.add("one");
		strList.add("two");
		strList.add("three");
		
		System.out.println("cells.containsAll(strList)?\t" + cells.containsAll(strList));
		
		strList.add("five");
		
		System.out.println("cells.containsAll(strList)?\t" + cells.containsAll(strList));
		
		//hasNext()  next()
		Iterator<String> it = cells.iterator();
		System.out.println("before cells.remove() " + cells);
		
		while (it.hasNext()){
			String tempStr = it.next();
			System.out.println(tempStr);
			if(tempStr.indexOf("on") != -1){
				it.remove();
				System.out.println(tempStr + "   remove");
			}
		}
		System.out.println("after cells.remove() " + cells);
		
		cells.add("one");
		System.out.println("----------------foreach-------------");
		for(String str : cells){
			System.out.println(str);
		}

	}
	@Test
	public void testList(){
		List<String> list= new ArrayList<String>();
		list.add("one");
		list.add("two");
		list.add("three");
		list.add("four");
		list.add("five");
		
		System.out.println(list);
		
		String str = list.set(1, "****");
		System.out.println(str);
		
		System.out.println(list);
		
		list.set(1, list.set(4, list.get(1)));
		
		System.out.println(list);
		
		list.add(0, "zelo");
		
		System.out.println(list);
		
		list.remove(0);
		
		System.out.println(list);
		
		List<Integer> intList = new ArrayList();
		for(int i = 0; i < 10; i++){
			intList.add(i, i);
		}
		System.out.println(intList);
		List<Integer> intList2 = intList.subList(3, 8);
		System.out.println(intList2);
		for(int i = 0; i < intList2.size(); i++){
			intList2.set(i, intList2.get(i) * 10);
		}
		System.out.println(intList2);
		intList2.subList(1, 2).clear();
		System.out.println(intList2);
		Integer [] intArr;
		intArr = intList.toArray(new Integer [] {});
		System.out.println(intArr);
		for(Integer a : intArr){
			System.out.print(Integer.valueOf(a) + " ");
		}
		String [] string = new String[]{"yi", "er", "san", "si"};
		List<String> strToString = Arrays.asList(string);
		System.out.println();
		System.out.println(string);
		for(String a : string){
			System.out.print(a + " ");
		}
		System.out.println();
		System.out.println(strToString);
		List<Integer> integer = new ArrayList<Integer>();
		Random ran = new Random();
		for(int i = 0; i < 10; i++){
			integer.add(ran.nextInt(20));
		}
		System.out.println(integer);
		Collections.sort(integer);
		System.out.println(integer);
		
	}
	
	//@Test
	//pulic void 
	

}
