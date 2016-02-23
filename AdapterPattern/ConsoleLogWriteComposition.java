package AdapterPattern;

public class ConsoleLogWriteComposition implements LogWriter{

	ConsoleWriter consoleWriter = new ConsoleWriter();
	@Override
	public void out(String text) {
		consoleWriter.writeConsole(text);
		
	}
}
