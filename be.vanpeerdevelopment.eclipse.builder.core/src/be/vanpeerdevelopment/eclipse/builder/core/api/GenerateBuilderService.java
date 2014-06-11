package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

public interface GenerateBuilderService {

	void generateBuilder(IPath compilationUnitLocation);

	String getJavaClassName(IPath compilationUnitLocation);
}