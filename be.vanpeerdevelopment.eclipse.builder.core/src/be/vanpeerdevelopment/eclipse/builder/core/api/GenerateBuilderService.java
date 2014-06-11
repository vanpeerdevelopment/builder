package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModelFactory;

public class GenerateBuilderService {

	private JdtReadModel jdtReadModel;

	public GenerateBuilderService() {
		jdtReadModel = JdtReadModelFactory.createJdtReadModel();
	}

	public String getJavaClassName(IPath fileLocation) {
		return jdtReadModel.getJavaClassName(fileLocation);
	}
}