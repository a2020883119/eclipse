package day03;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Teacher p1 = new Teacher("lisang");
		SonOfTeacher sonofteacher = new SonOfTeacher("shili");
		sonofteacher.move();
		p1 = sonofteacher;
		p1.move();
	}
}
