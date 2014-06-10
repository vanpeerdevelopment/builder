package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.JdtReadModel;

public class GenerateBuilderService {

	private JdtReadModel jdtReadModel;

	public GenerateBuilderService() {
		jdtReadModel = new JdtReadModel();
	}

	public String getJavaClassName(IPath fileLocation) {
		return jdtReadModel.getJavaClassName(fileLocation);
	}
}