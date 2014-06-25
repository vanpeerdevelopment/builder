package be.vanpeerdevelopment.eclipse.builder.jdt.write.api;

import be.vanpeerdevelopment.eclipse.builder.jdt.write.internal.JdtWriteModelImpl;

public class JdtWriteModelFactory {

	public JdtWriteModel createJdtWriteModel() {
		return new JdtWriteModelImpl();
	}
}