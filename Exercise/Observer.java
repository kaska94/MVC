package Exercise;

public class Observer implements SomeListner {
	public Observer() {
		
	}

	@Override
	public void someEventPerformed() {
		System.out.println("Wtf!");

	}

}
