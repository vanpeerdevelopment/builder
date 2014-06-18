package be.vanpeerdevelopment.eclipse.builder.jdt.write.api;

public class JdtWriteException extends RuntimeException {

	private static final long serialVersionUID = -401451602572774969L;

	public JdtWriteException(String message) {
		super(message);
	}

	public JdtWriteException(String message, Throwable cause) {
		super(message, cause);
	}
}