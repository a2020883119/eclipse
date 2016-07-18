package day03;
import org.junit.Test;

public class SonOfTeacher extends Teacher{
	
	public SonOfTeacher(String name) {
		super(name);
		super.who();
		this.who();
		// TODO Auto-generated constructor stub
	}
	void sqrt() {
		// TODO Auto-generated method stub
		System.out.println("sqrt-sonofteacher");
	}
	
}
