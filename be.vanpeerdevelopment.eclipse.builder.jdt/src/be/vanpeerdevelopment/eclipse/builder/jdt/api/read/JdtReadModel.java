package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.eclipse.jdt.core.JavaCore.createCompilationUnitFrom;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;

import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;

public class JdtReadModel {

	private Workspace workspace;

	public JdtReadModel() {
		workspace = new Workspace();
	}

	public ReadableCompilationUnit getCompilationUnit(IPath compilationUnitLocation) {
		IFile file = workspace.getFile(compilationUnitLocation);
		ICompilationUnit compilationUnit = createCompilationUnitFrom(file);
		return new ReadableCompilationUnit(compilationUnit);
	}
}