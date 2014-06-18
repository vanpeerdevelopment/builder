package be.vanpeerdevelopment.eclipse.builder.jdt.read.internal;

import static be.vanpeerdevelopment.eclipse.builder.jdt.common.FileUtils.getFile;
import static org.eclipse.jdt.core.JavaCore.createCompilationUnitFrom;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;

import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.read.api.ReadableCompilationUnit;

public class JdtReadModelImpl implements JdtReadModel {

	@Override
	public ReadableCompilationUnit getCompilationUnit(IPath compilationUnitLocation) {
		IFile file = getFile(compilationUnitLocation);
		ICompilationUnit compilationUnit = createCompilationUnitFrom(file);
		return new ReadableCompilationUnitAdapter(compilationUnit);
	}
}