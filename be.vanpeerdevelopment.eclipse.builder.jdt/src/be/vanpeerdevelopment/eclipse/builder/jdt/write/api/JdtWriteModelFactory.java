package be.vanpeerdevelopment.eclipse.builder.jdt.write.api;

import be.vanpeerdevelopment.eclipse.builder.jdt.write.internal.WriteModel;

public class JdtWriteModelFactory {

	public static JdtWriteModel createJdtWriteModel() {
		return new WriteModel();
	}
}