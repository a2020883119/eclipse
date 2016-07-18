package day03;

class Teacher extends Person implements Mami{

	public Teacher(String name){
		this.name = name;
	}
	@Override
	void move() {
		// TODO Auto-generated method stub
		System.out.println("move-teacher");
	}

	@Override
	void work() {
		// TODO Auto-generated method stub
		System.out.println("work-teacher");
	}
	
	void who(){
		System.out.println("I'm teacher!");
	}
	@Override
	public void haha() {
		// TODO Auto-generated method stub
		System.out.println("haha-teacher");
	}
	@Override
	public void heihei() {
		// TODO Auto-generated method stub
		System.out.println("heihei-teacher");
	}
}
