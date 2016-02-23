package AdapterPattern;

public class Logger {
	public LogWriter logWriter;

	public Logger(LogWriter log) {
		logWriter = log;
	}

	public void write(String text) {
		logWriter.out(text);
	}
}
