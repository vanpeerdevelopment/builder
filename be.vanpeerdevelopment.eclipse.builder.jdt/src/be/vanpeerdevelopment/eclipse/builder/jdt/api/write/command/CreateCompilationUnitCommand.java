package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import org.eclipse.core.runtime.IPath;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class CreateCompilationUnitCommand extends ValueObject {

	private IPath packageLocation;
	private CompilationUnit compilationUnit;

	private CreateCompilationUnitCommand() {
	}

	public IPath getPackageLocation() {
		return packageLocation;
	}

	public CompilationUnit getCompilationUnit() {
		return compilationUnit;
	}

	private void validate() {
		validatePackageLocation();
		validateCompilationUnit();
		validateCompilationUnitIsInSamePackage();
	}

	private void validatePackageLocation() {
		if (packageLocation == null)
			throw new ValidationException("Package location is required.");
	}

	private void validateCompilationUnit() {
		if (compilationUnit == null)
			throw new ValidationException("Compilation unit is required.");
	}

	private void validateCompilationUnitIsInSamePackage() {
		if (!compilationUnit.isInPackage(packageLocation))
			throw new ValidationException(
					"Compilation unit has to be in same package as create compilation unit command.");
	}

	public static class CreateCompilationUnitCommandBuilder {

		private CreateCompilationUnitCommand command;

		private CreateCompilationUnitCommandBuilder() {
			command = new CreateCompilationUnitCommand();
		}

		public static CreateCompilationUnitCommandBuilder createCompilationUnitCommand() {
			return new CreateCompilationUnitCommandBuilder();
		}

		public CreateCompilationUnitCommand build() {
			command.validate();
			return command;
		}

		public CreateCompilationUnitCommandBuilder withPackageLocation(IPath packageLocation) {
			command.packageLocation = packageLocation;
			return this;
		}

		public CreateCompilationUnitCommandBuilder withCompilationUnit(CompilationUnit compilationUnit) {
			command.compilationUnit = compilationUnit;
			return this;
		}
	}
}