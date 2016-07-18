package day17;

public class Cat extends Animal implements Cream{

	Cat(String name, String color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void cream() {
		// TODO Auto-generated method stub
		System.out.println("Cat can cream");
	}
	
}
