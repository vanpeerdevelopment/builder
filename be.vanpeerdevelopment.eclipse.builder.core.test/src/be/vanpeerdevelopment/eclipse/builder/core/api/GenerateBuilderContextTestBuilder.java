package be.vanpeerdevelopment.eclipse.builder.core.api;

import static be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderContext.GenerateBuilderContextBuilder.generateBuilderContext;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderContext.GenerateBuilderContextBuilder;

public class GenerateBuilderContextTestBuilder {

	private GenerateBuilderContextBuilder builder;

	private GenerateBuilderContextTestBuilder() {
		builder = generateBuilderContext();
	}

	public static GenerateBuilderContextTestBuilder aGenerateBuilderContext() {
		return new GenerateBuilderContextTestBuilder();
	}

	public GenerateBuilderContext build() {
		return builder.build();
	}

	public GenerateBuilderContextTestBuilder withCompilationUnitLocation(IPath compilationUnitLocation) {
		builder.withCompilationUnitLocation(compilationUnitLocation);
		return this;
	}
}