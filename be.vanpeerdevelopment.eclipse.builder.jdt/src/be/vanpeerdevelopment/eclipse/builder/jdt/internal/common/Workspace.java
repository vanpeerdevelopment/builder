package be.vanpeerdevelopment.eclipse.builder.jdt.internal.common;

import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.eclipse.jdt.core.JavaCore.create;
import static org.eclipse.jdt.core.JavaCore.createCompilationUnitFrom;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadablePackageFragment;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.write.WriteablePackageFragment;

public class Workspace {

	public ReadableCompilationUnit getReadableCompilationUnit(IPath compilationUnitLocation) {
		return new ReadableCompilationUnit(getICompilationUnit(compilationUnitLocation));
	}

	public WriteablePackageFragment getWriteablePackageFragment(IPath packageLocation) {
		return new WriteablePackageFragment(getIPackageFragment(packageLocation));
	}

	public ReadablePackageFragment getReadablePackageFragment(IPath packageLocation) {
		return new ReadablePackageFragment(getIPackageFragment(packageLocation));
	}

	private ICompilationUnit getICompilationUnit(IPath compilationUnitLocation) {
		IFile compilationUnit = getWorkspace()
				.getRoot()
				.getFileForLocation(compilationUnitLocation);
		return createCompilationUnitFrom(compilationUnit);
	}

	private IPackageFragment getIPackageFragment(IPath packageLocation) {
		IContainer packageFragment = getWorkspace()
				.getRoot()
				.getContainerForLocation(packageLocation);
		return (IPackageFragment) create(packageFragment);
	}
}