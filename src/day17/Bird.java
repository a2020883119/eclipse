package day17;

public class Bird extends Animal implements Fly{
	
	Bird(String name, String color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void fly() {
		// TODO Auto-generated method stub
		System.out.println("Bird can fly");
	}
	
}	
