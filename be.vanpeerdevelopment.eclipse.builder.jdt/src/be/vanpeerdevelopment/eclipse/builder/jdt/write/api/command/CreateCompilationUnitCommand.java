package be.vanpeerdevelopment.eclipse.builder.jdt.write.api.command;

import org.eclipse.core.runtime.IPath;

public class CreateCompilationUnitCommand {

	public static final String JAVA_EXTENSION = ".java";

	private IPath siblingCompilationUnitLocation;
	private String name;

	private CreateCompilationUnitCommand() {
	}

	public IPath getSiblingCompilationUnitLocation() {
		return siblingCompilationUnitLocation;
	}

	public String getName() {
		return name;
	}

	public String getNameWithExtension() {
		return new StringBuilder(name)
		.append(JAVA_EXTENSION)
		.toString();
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

		public CreateCompilationUnitCommandBuilder withSiblingCompilationUnitLocation(
				IPath siblingCompilationUnitLocation) {
			command.siblingCompilationUnitLocation = siblingCompilationUnitLocation;
			return this;
		}

		public CreateCompilationUnitCommandBuilder withName(String name) {
			command.name = name;
			return this;
		}
	}
}