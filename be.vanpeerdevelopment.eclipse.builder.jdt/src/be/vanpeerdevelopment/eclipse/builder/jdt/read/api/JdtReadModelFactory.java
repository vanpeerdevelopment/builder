package be.vanpeerdevelopment.eclipse.builder.jdt.read.api;

import be.vanpeerdevelopment.eclipse.builder.jdt.read.internal.JdtReadModelImpl;

public class JdtReadModelFactory {

	public JdtReadModel createJdtReadModel() {
		return new JdtReadModelImpl();
	}
}