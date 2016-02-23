package FactoryPattern;

public class App {

	public static void main(String[] args) {
		Animal animal = AnimalFactory.createAnimal(0);
		animal.speak();

	}

}
