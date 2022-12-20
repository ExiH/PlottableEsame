package ese1;

public class NotPlottableException extends RuntimeException {
	private static final long serialVersionUID = 8124198238284661895L;
	
	public NotPlottableException() {
		super("Figura non plottable");
	}
	public NotPlottableException(String message) {
		super(message);
	}
	
}
