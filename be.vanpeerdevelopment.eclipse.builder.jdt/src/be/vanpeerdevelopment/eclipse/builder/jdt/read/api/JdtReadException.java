package be.vanpeerdevelopment.eclipse.builder.jdt.read.api;

public class JdtReadException extends RuntimeException {

	private static final long serialVersionUID = 2879038410942735787L;

	public JdtReadException(String message) {
		super(message);
	}

	public JdtReadException(String message, Throwable cause) {
		super(message, cause);
	}
}