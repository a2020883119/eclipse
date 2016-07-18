package day17;

public class Dog extends Animal implements Bark{

	Dog(String name, String color) {
		super(name, color);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void bark() {
		// TODO Auto-generated method stub
		System.out.println("Dog can bark");
	}
	
}
