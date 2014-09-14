package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

public class GenerateBuilderCommand {

	private IPath compilationUnitLocation;

	private GenerateBuilderCommand() {
	}

	public IPath getCompilationUnitLocation() {
		return compilationUnitLocation;
	}

	public IPath getPackageLocation() {
		return compilationUnitLocation.removeLastSegments(1);
	}

	public static class GenerateBuilderCommandBuilder {

		private GenerateBuilderCommand generateBuilderCommand;

		private GenerateBuilderCommandBuilder() {
			generateBuilderCommand = new GenerateBuilderCommand();
		}

		public static GenerateBuilderCommandBuilder generateBuilderCommand() {
			return new GenerateBuilderCommandBuilder();
		}

		public GenerateBuilderCommand build() {
			return generateBuilderCommand;
		}

		public GenerateBuilderCommandBuilder withCompilationUnitLocation(IPath compilationUnitLocation) {
			generateBuilderCommand.compilationUnitLocation = compilationUnitLocation;
			return this;
		}
	}
}