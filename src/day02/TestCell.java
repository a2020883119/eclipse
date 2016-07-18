package day02;

import org.junit.Test;

public class TestCell {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testToString();
		testEquals();
		
	}
	
	@Test
	public static void testToString(){
		Cell cell = new Cell(4, 5);
		System.out.println(cell);
	}
	
	public static void testEquals(){
		Cell cella = new Cell(3, 4);
		Cell cellb = new Cell(3, 4);
		Cell cellc = new Cell(1, 2);
		System.out.println(cella.equals(cellb));
		System.out.println(cella.equals(cellc));
	}
}
