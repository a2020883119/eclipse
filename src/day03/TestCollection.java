package day03;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

import org.junit.Test;

public class TestCollection {
	/**
	 * 集合持有对象的引用
	 */
	@Test
	public void testRef(){
		Collection<Cell> cells = new ArrayList<Cell>();
		cells.add(new Cell(1,2));
		Cell cell = new Cell(3, 4);
		cells.add(cell);
		System.out.println(cell);
		System.out.println(cells);
		cell.drop();
		System.out.println(cell);
		System.out.println(cells);
	}
	/**
	 * test add() method
	 */
	@Test
	public void testAdd(){
		Collection<String> c = new ArrayList<String>();
		System.out.println(c);
		c.add("a");
		c.add("b");
		c.add("c");
		System.out.println(c);
	}
	/**
	 * test contains() method
	 */
	@Test
	public void testContains(){
		Collection<Cell> cells = new ArrayList<Cell>();
		
		cells.add(new Cell(1 ,3));
		cells.add(new Cell(2 ,6));
		cells.add(new Cell(1 ,3));
		cells.add(new Cell(3 ,3));
		cells.add(new Cell(5 ,3));
		
		Cell cell = new Cell(5, 3);
		System.out.println(cells.contains(cell));
	}
	
	/**
	 * test clear() size() isEmpty()
	 */
	@Test
	public void testSizeAndClearAndIsEmpty(){
		Collection<String> c = new HashSet<String>();
		System.out.println(c.isEmpty());
		
		c.add("java");
		c.add("object-c");
		c.add("php");
		c.add("c#");
		c.add("cpp");
		
		System.out.println(c.isEmpty() + " " + c.size());
		c.clear();
		System.out.println(c.isEmpty() + " " + c.size());
	}
}
