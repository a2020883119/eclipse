package day08;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.List;

public class Arraylist_A_Z {
	
	
	public static void main(String [] args){
		System.out.println("------------------------first---------------------");
		ArrayList<Character> a = new ArrayList<Character>();
		for(int i = (int)'A';i <= 'Z'; i++){
			a.add((char)i);
		}
		System.out.println("after put A - Z:" + a);
		System.out.println("size:" + a.size());
		for(int i = 0;i < 26; i++){
			a.set(i, (char)((int)a.get(i) + 1));
		}
		System.out.println("after add one erveryone:" + a);
		System.out.println("size:" + a.size());
		
		System.out.println("------------------------second---------------------");
		
		HashSet<Character> h = new HashSet<Character>();
		for(int i = 25;i >= 0; i--){
			h.add(a.get(i));
		}
		Iterator it2 = h.iterator();
		
		
		System.out.println("after copy and reserve:" + h);
		System.out.println("------------------------third----------------------");
		
		TreeMap<Character, String> t = new TreeMap<Character, String>();
		char temp;
		int i = 1;
		Iterator it = h.iterator();
		while(it.hasNext()){
			t.put(temp = (Character) it.next(), new String(temp + "" + i +  i * i));
			i++;
		}
		System.out.println(t);
	}
	
}
