package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import org.eclipse.core.runtime.IPath;

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

	public static class CreateCompilationUnitCommandBuilder {

		private CreateCompilationUnitCommand command;

		private CreateCompilationUnitCommandBuilder() {
			command = new CreateCompilationUnitCommand();
		}

		public static CreateCompilationUnitCommandBuilder createCompilationUnitCommand() {
			return new CreateCompilationUnitCommandBuilder();
		}

		public CreateCompilationUnitCommand build() {
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