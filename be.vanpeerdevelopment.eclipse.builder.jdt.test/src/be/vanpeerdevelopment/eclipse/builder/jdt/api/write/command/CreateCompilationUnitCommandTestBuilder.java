package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder.createCompilationUnitCommand;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder;

public class CreateCompilationUnitCommandTestBuilder {

	private static final IPath DEFAULT_PACKAGE_LOCATION = new Path("Default package location");
	private static final String DEFAULT_NAME = "Vehicle";

	private CreateCompilationUnitCommandBuilder builder;

	private CreateCompilationUnitCommandTestBuilder() {
		builder = createCompilationUnitCommand();
	}

	public static CreateCompilationUnitCommandTestBuilder aCreateCompilationUnitCommand() {
		return new CreateCompilationUnitCommandTestBuilder()
				.withPackageLocation(DEFAULT_PACKAGE_LOCATION)
				.withName(DEFAULT_NAME);
	}

	public CreateCompilationUnitCommand build() {
		return builder.build();
	}

	public CreateCompilationUnitCommandTestBuilder withPackageLocation(IPath packageLocation) {
		builder.withPackageLocation(packageLocation);
		return this;
	}

	public CreateCompilationUnitCommandTestBuilder withName(String name) {
		builder.withName(name);
		return this;
	}
}