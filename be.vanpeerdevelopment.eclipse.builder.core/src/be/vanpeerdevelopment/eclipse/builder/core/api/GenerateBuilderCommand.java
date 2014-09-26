package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

public class GenerateBuilderCommand {

	private IPath sourceCompilationUnitLocation;

	private GenerateBuilderCommand() {
	}

	public IPath getSourceCompilationUnitLocation() {
		return sourceCompilationUnitLocation;
	}

	public IPath getDestinationPackageLocation() {
		return sourceCompilationUnitLocation.removeLastSegments(1);
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

		public GenerateBuilderCommandBuilder withSourceCompilationUnitLocation(IPath sourceCompilationUnitLocation) {
			generateBuilderCommand.sourceCompilationUnitLocation = sourceCompilationUnitLocation;
			return this;
		}
	}
}