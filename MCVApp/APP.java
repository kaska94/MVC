package MCVApp;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import MCVControler.Controller;
import MVCModel.Model;
import MVCView.View;

public class APP {
	public static void main(String[] args) throws InvocationTargetException,
			InterruptedException {
		SwingUtilities.invokeAndWait(new Runnable() {

			@Override
			public void run() {
				runApp();
			}
		});
	}

	public static void runApp() {
		Model model = new Model();
		
		View view = new View(model);
		
		Controller control = new Controller(model, view);
		
		view.setLoginListener(control);
		
	}
}
