package be.vanpeerdevelopment.eclipse.builder.jdt.internal.common;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.eclipse.jdt.core.JavaCore.create;
import static org.eclipse.jdt.core.JavaCore.createCompilationUnitFrom;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.IPackageFragment;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;

public class Workspace {

	public ReadableCompilationUnit getCompilationUnit(IPath compilationUnitLocation) {
		IFile compilationUnit = getWorkspace()
				.getRoot()
				.getFileForLocation(compilationUnitLocation);
		return new ReadableCompilationUnit(createCompilationUnitFrom(compilationUnit));
	}

	public IPackageFragment getPackage(IPath packageLocation) {
		IContainer packageFragment = getWorkspace()
				.getRoot()
				.getContainerForLocation(packageLocation);
		return (IPackageFragment) create(packageFragment);
	}
}