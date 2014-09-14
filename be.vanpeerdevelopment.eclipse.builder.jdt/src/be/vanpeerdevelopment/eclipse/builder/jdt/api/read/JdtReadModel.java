package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;

public class JdtReadModel {

	private Workspace workspace;

	public JdtReadModel() {
		workspace = new Workspace();
	}

	public ReadableCompilationUnit getCompilationUnit(IPath compilationUnitLocation) {
		return workspace.getCompilationUnit(compilationUnitLocation);
	}
}