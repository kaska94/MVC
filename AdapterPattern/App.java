package AdapterPattern;
/*
 * Use when you need to synchronize classes or interfaces 
 */
public class App {
	public static void main(String[] args) {
		// has functionality from LogWriter Interface and ConsoleWeriter Class via Composition
		ConsoleLogWriteComposition logWriter = new ConsoleLogWriteComposition();
		
		//implements LogWriter interface
		Logger log = new Logger(logWriter);
		
		// this calls ConsoleWriter.writeConsole(text);
		log.write("First try");
		
		// has functionality from LogWriter Interface and ConsoleWeriter Class via Inheritence
		ConsoleLogWriterInheritence logWriterInheritence = new ConsoleLogWriterInheritence();
		
		//implements LogWriter interface
		Logger logger = new Logger(logWriterInheritence);
		
		// this calls super().writeConsole(text); (ConsoleWriter.writeConsole(text);)
		log.write("test");
	}
}
