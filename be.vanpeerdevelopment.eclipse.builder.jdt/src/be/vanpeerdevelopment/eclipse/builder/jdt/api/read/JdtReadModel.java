package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;

import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;

public class JdtReadModel {

	private Workspace workspace;

	public JdtReadModel() {
		workspace = new Workspace();
	}

	public ReadableCompilationUnit getCompilationUnit(IPath compilationUnitLocation) {
		ICompilationUnit compilationUnit = workspace.getCompilationUnit(compilationUnitLocation);
		return new ReadableCompilationUnit(compilationUnit);
	}
}