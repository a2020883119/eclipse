package day17;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zoo zoo = new Zoo();
		for (int i = 0; i < zoo.animal.length; i++) {
			if(zoo.animal[i] instanceof Bird){
				Bird bird = (Bird)zoo.animal[i];
				System.out.println("名字：" + bird.getName() + "\n颜色："+ bird.getColor() + "\n类：" + bird.getClass());
				bird.fly();
				System.out.println();
			}
			if(zoo.animal[i] instanceof Cat){
				Cat cat = (Cat)zoo.animal[i];
				System.out.println("名字：" + cat.getName() + "\n颜色：" + cat.getColor() + "\n类：" + cat.getClass());
				cat.cream();
				System.out.println();
			}
			if(zoo.animal[i] instanceof Dog){
				Dog dog = (Dog)zoo.animal[i];
				System.out.println("名字：" + dog.getName() + "\n颜色：" + dog.getColor() + "\n类：" + dog.getClass());
				dog.bark();
				System.out.println();
			}
		}
		System.out.println("hahaha");
	}

}
