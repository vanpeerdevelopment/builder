package be.vanpeerdevelopment.eclipse.builder.core.api;

import static be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderCommand.GenerateBuilderCommandBuilder.generateBuilderCommand;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderCommand.GenerateBuilderCommandBuilder;

public class GenerateBuilderCommandTestBuilder {

	private GenerateBuilderCommandBuilder builder;

	private GenerateBuilderCommandTestBuilder() {
		builder = generateBuilderCommand();
	}

	public static GenerateBuilderCommandTestBuilder aGenerateBuilderCommand() {
		return new GenerateBuilderCommandTestBuilder();
	}

	public GenerateBuilderCommand build() {
		return builder.build();
	}

	public GenerateBuilderCommandTestBuilder withCompilationUnitLocation(IPath compilationUnitLocation) {
		builder.withCompilationUnitLocation(compilationUnitLocation);
		return this;
	}
}