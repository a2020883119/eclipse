package day17;

public class TestAnimal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Zoo zoo = new Zoo();
		for (int i = 0; i < zoo.animal.length; i++) {
			if(zoo.animal[i] instanceof Bird){
				Bird bird = (Bird)zoo.animal[i];
				System.out.println("���֣�" + bird.getName() + "\n��ɫ��"+ bird.getColor() + "\n�ࣺ" + bird.getClass());
				bird.fly();
				System.out.println();
			}
			if(zoo.animal[i] instanceof Cat){
				Cat cat = (Cat)zoo.animal[i];
				System.out.println("���֣�" + cat.getName() + "\n��ɫ��" + cat.getColor() + "\n�ࣺ" + cat.getClass());
				cat.cream();
				System.out.println();
			}
			if(zoo.animal[i] instanceof Dog){
				Dog dog = (Dog)zoo.animal[i];
				System.out.println("���֣�" + dog.getName() + "\n��ɫ��" + dog.getColor() + "\n�ࣺ" + dog.getClass());
				dog.bark();
				System.out.println();
			}
		}
		System.out.println("hahaha");
	}

}
