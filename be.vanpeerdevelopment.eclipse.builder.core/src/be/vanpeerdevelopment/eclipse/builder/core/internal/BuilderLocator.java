package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine.BUILDER_SUFFIX;

import org.eclipse.core.runtime.IPath;

public class BuilderLocator {

	public IPath getBuilderLocation(IPath destinationPackageLocation, IPath sourceCompilationUnitLocation) {
		return destinationPackageLocation
				.append(getCompilationUnitName(sourceCompilationUnitLocation) + BUILDER_SUFFIX + ".java");
	}

	private String getCompilationUnitName(IPath compilationUnitLocation) {
		return compilationUnitLocation.removeFileExtension().lastSegment();
	}
}