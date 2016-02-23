package AdapterPattern;

public class ConsoleLogWriterInheritence extends ConsoleWriter implements LogWriter {

	@Override
	public void out(String text) {
		writeConsole("text");
		
	}

 
}
