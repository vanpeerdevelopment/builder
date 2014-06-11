package be.vanpeerdevelopment.eclipse.builder.core.api;

import org.eclipse.core.runtime.IPath;

public interface GenerateBuilderService {

	String getJavaClassName(IPath classLocation);
}