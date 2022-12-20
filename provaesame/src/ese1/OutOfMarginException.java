package ese1;

public class OutOfMarginException extends java.lang.Exception {
	private static final long serialVersionUID = 7022105576426353943L;
	public OutOfMarginException() {
		super("Figura fuori dai margini");
	}
	
	public OutOfMarginException(String s) {
		super(s);
	}
}
