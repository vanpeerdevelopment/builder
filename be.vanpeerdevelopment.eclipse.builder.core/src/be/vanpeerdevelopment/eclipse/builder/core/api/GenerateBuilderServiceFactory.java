package be.vanpeerdevelopment.eclipse.builder.core.api;

import be.vanpeerdevelopment.eclipse.builder.core.internal.GenerateBuilderServiceImpl;

public class GenerateBuilderServiceFactory {

	public static GenerateBuilderService createGenerateBuilderService() {
		return new GenerateBuilderServiceImpl();
	}
}