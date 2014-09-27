package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteException;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class WriteablePackageFragment {

	private IPackageFragment packageFragment;

	public WriteablePackageFragment(IPackageFragment packageFragment) {
		this.packageFragment = packageFragment;
	}

	public void createCompilationUnit(CreateCompilationUnitCommand command) {
		try {
			createCompilationUnitIgnoringException(command);
		} catch (JavaModelException e) {
			throw new JdtWriteException(
					"Something went wrong while creating the following compilation unit: "
							+ command.getCompilationUnit().getNameWithExtension(), e);
		}
	}

	private void createCompilationUnitIgnoringException(CreateCompilationUnitCommand command)
			throws JavaModelException {
		packageFragment.createCompilationUnit(
				command.getCompilationUnit().getNameWithExtension(),
				"package " + packageFragment.getElementName() + ";",
				true,
				null);
	}
}