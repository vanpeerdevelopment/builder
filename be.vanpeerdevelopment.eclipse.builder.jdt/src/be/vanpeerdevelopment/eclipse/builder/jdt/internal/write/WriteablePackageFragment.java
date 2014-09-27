package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteException;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit;

public class WriteablePackageFragment {

	private IPackageFragment packageFragment;

	public WriteablePackageFragment(IPackageFragment packageFragment) {
		this.packageFragment = packageFragment;
	}

	public void createCompilationUnit(CompilationUnit compilationUnit) {
		try {
			createCompilationUnitIgnoringException(compilationUnit);
		} catch (JavaModelException e) {
			throw new JdtWriteException(
					"Something went wrong while creating the following compilation unit: "
							+ compilationUnit.getNameWithExtension(), e);
		}
	}

	private void createCompilationUnitIgnoringException(CompilationUnit compilationUnit)
			throws JavaModelException {
		packageFragment.createCompilationUnit(
				compilationUnit.getNameWithExtension(),
				compilationUnit.toCode(),
				true,
				null);
	}
}