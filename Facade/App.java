package Facade;
/*
 * Use when you have constantly calling multiple classes
 * 1) Make another class(Facade) and do it there
 * 2) Call the Facade method with the other class's methods
 */
public class App {
	public static void main(String[] args) {
		GameFacade game = new GameFacade();
		while (true) {
			game.update();
		}
	}
}
