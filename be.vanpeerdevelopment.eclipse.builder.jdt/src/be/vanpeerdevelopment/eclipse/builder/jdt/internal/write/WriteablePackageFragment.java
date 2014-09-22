package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteException;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class WriteablePackageFragment {

	private IPackageFragment packageFragment;

	public WriteablePackageFragment(IPackageFragment packageFragment) {
		this.packageFragment = packageFragment;
	}

	public ReadableCompilationUnit createCompilationUnit(CreateCompilationUnitCommand command) {
		try {
			return createCompilationUnitIgnoringException(command);
		} catch (JavaModelException e) {
			throw new JdtWriteException(
					"Something went wrong while creating the following compilation unit: "
							+ command.getNameWithExtension(), e);
		}
	}

	private ReadableCompilationUnit createCompilationUnitIgnoringException(CreateCompilationUnitCommand command)
			throws JavaModelException {
		ICompilationUnit compilationUnit = packageFragment.createCompilationUnit(
				command.getNameWithExtension(),
				"",
				true,
				null);
		return new ReadableCompilationUnit(compilationUnit);
	}
}