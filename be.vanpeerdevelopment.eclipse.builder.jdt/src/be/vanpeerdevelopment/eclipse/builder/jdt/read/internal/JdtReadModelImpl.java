package be.vanpeerdevelopment.eclipse.builder.jdt.read.internal;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.JavaCore;

import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModel;

public class JdtReadModelImpl implements JdtReadModel {

	@Override
	public ReadableCompilationUnit getCompilationUnit(IPath compilationUnitLocation) {
		IFile file = getFile(compilationUnitLocation);
		ICompilationUnit compilationUnit = JavaCore.createCompilationUnitFrom(file);
		return new ReadableCompilationUnitAdapter(compilationUnit);
	}

	private IFile getFile(IPath fileLocation) {
		return getWorkspace()
				.getRoot()
				.getFileForLocation(fileLocation);
	}
}