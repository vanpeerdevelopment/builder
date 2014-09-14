package be.vanpeerdevelopment.eclipse.builder.jdt.write.api;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.command.CreateCompilationUnitCommand;

public class WriteablePackageFragment {

	private IPackageFragment packageFragment;

	WriteablePackageFragment(IPackageFragment packageFragment) {
		this.packageFragment = packageFragment;
	}

	public void createCompilationUnit(CreateCompilationUnitCommand command) {
		try {
			createCompilationUnitIgnoringException(command);
		} catch (JavaModelException e) {
			throw new JdtWriteException(
					"Something went wrong while creating the following compilation unit: "
							+ command.getNameWithExtension(), e);
		}
	}

	private void createCompilationUnitIgnoringException(CreateCompilationUnitCommand command)
			throws JavaModelException {
		packageFragment.createCompilationUnit(
				command.getNameWithExtension(),
				"",
				true,
				null);
	}
}