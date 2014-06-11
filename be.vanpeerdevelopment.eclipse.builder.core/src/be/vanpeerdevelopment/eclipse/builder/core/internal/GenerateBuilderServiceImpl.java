package be.vanpeerdevelopment.eclipse.builder.core.internal;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModelFactory;

public class GenerateBuilderServiceImpl implements GenerateBuilderService {

	private JdtReadModel jdtReadModel;

	public GenerateBuilderServiceImpl() {
		jdtReadModel = JdtReadModelFactory.createJdtReadModel();
	}

	@Override
	public String getJavaClassName(IPath classLocation) {
		return jdtReadModel.getJavaClassName(classLocation);
	}
}