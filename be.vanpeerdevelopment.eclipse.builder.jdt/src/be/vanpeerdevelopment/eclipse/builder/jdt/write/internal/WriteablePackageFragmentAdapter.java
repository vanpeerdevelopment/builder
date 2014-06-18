package be.vanpeerdevelopment.eclipse.builder.jdt.write.internal;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteException;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.WriteablePackageFragment;

public class WriteablePackageFragmentAdapter implements WriteablePackageFragment {

	private IPackageFragment packageFragment;

	public WriteablePackageFragmentAdapter(IPackageFragment packageFragment) {
		this.packageFragment = packageFragment;
	}

	@Override
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