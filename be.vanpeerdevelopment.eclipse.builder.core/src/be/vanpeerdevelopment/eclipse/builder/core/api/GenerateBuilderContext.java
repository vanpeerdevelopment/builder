package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

public class GenerateBuilderContext {

	private IPath compilationUnitLocation;

	private GenerateBuilderContext() {
	}

	public IPath getCompilationUnitLocation() {
		return compilationUnitLocation;
	}

	public IPath getPackageLocation() {
		return compilationUnitLocation.removeLastSegments(1);
	}

	public static class GenerateBuilderContextBuilder {

		private GenerateBuilderContext generateBuilderContext;

		private GenerateBuilderContextBuilder() {
			generateBuilderContext = new GenerateBuilderContext();
		}

		public static GenerateBuilderContextBuilder generateBuilderContext() {
			return new GenerateBuilderContextBuilder();
		}

		public GenerateBuilderContext build() {
			return generateBuilderContext;
		}

		public GenerateBuilderContextBuilder withCompilationUnitLocation(IPath compilationUnitLocation) {
			generateBuilderContext.compilationUnitLocation = compilationUnitLocation;
			return this;
		}
	}
}