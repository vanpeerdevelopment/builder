package be.vanpeerdevelopment.eclipse.builder.jdt.write.api.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.write.api.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder.createCompilationUnitCommand;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder;

public class CreateCompilationUnitCommandTestBuilder {

	private static final IPath DEFAULT_SIBLING_COMPILATION_UNIT_LOCATION = new Path("default location");
	private static final String DEFAULT_NAME = "Vehicle";

	private CreateCompilationUnitCommandBuilder builder;

	private CreateCompilationUnitCommandTestBuilder() {
		builder = createCompilationUnitCommand()
				.withSiblingCompilationUnitLocation(DEFAULT_SIBLING_COMPILATION_UNIT_LOCATION)
				.withName(DEFAULT_NAME);
	}

	public static CreateCompilationUnitCommandTestBuilder aCreateCompilationUnitCommand() {
		return new CreateCompilationUnitCommandTestBuilder();
	}

	public CreateCompilationUnitCommand build() {
		return builder.build();
	}

	public CreateCompilationUnitCommandTestBuilder withSiblingCompilationUnitLocation(
			IPath siblingCompilationUnitLocation) {
		builder.withSiblingCompilationUnitLocation(siblingCompilationUnitLocation);
		return this;
	}

	public CreateCompilationUnitCommandTestBuilder withName(String name) {
		builder.withName(name);
		return this;
	}
}