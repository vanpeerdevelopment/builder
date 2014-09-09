package be.vanpeerdevelopment.eclipse.builder.jdt.read.internal;

import static org.eclipse.jdt.core.JavaCore.createCompilationUnitFrom;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;

import be.vanpeerdevelopment.eclipse.builder.jdt.common.Workspace;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.ReadableCompilationUnit;

public class JdtReadModelImpl implements JdtReadModel {

	private Workspace workspace;

	public JdtReadModelImpl() {
		workspace = new Workspace();
	}

	@Override
	public ReadableCompilationUnit getCompilationUnit(IPath compilationUnitLocation) {
		IFile file = workspace.getFile(compilationUnitLocation);
		ICompilationUnit compilationUnit = createCompilationUnitFrom(file);
		return new ReadableCompilationUnitAdapter(compilationUnit);
	}
}