package be.vanpeerdevelopment.eclipse.builder.jdt.read.api;

import org.eclipse.core.runtime.IPath;

public interface JdtReadModel {

	ReadableCompilationUnit getCompilationUnit(IPath compilationUnitLocation);
}