package be.vanpeerdevelopment.eclipse.builder.core.api;

import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine;
import be.vanpeerdevelopment.eclipse.builder.core.internal.GenerateBuilderServiceImpl;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModelFactory;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModelFactory;

public class GenerateBuilderServiceFactory {

	private JdtReadModelFactory jdtReadModelFactory;
	private JdtWriteModelFactory jdtWriteModelFactory;

	public GenerateBuilderServiceFactory() {
		jdtReadModelFactory = new JdtReadModelFactory();
		jdtWriteModelFactory = new JdtWriteModelFactory();
	}

	public GenerateBuilderService createGenerateBuilderService() {
		return new GenerateBuilderServiceImpl(
				new BuilderPatternEngine(jdtReadModelFactory.createJdtReadModel()),
				jdtWriteModelFactory.createJdtWriteModel());
	}
}