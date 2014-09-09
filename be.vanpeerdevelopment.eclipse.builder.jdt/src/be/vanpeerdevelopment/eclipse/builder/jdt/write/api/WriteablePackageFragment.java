package be.vanpeerdevelopment.eclipse.builder.jdt.write.api;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

public class WriteablePackageFragment {

	private IPackageFragment packageFragment;

	WriteablePackageFragment(IPackageFragment packageFragment) {
		this.packageFragment = packageFragment;
	}

	public void createCompilationUnit(WriteableCompilationUnit compilationUnit) {
		try {
			createCompilationUnitIgnoringException(compilationUnit);
		} catch (JavaModelException e) {
			throw new JdtWriteException(
					"Something went wrong while creating the following compilation unit: "
							+ compilationUnit.getNameWithExtension(), e);
		}
	}

	private void createCompilationUnitIgnoringException(WriteableCompilationUnit compilationUnit)
			throws JavaModelException {
		packageFragment.createCompilationUnit(
				compilationUnit.getNameWithExtension(),
				"",
				true,
				null);
	}
}