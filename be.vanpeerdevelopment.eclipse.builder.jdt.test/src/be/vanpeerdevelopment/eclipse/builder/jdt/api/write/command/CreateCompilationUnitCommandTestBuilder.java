package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnitTestBuilder.aCompilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder.createCompilationUnitCommand;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;

import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder;

public class CreateCompilationUnitCommandTestBuilder {

	private static final IPath DEFAULT_PACKAGE_LOCATION = new Path("/project/src/be.vanpeerdevelopment.eclipse.builder");
	private static final CompilationUnit DEFAULT_COMPILATION_UNIT = aCompilationUnit()
			.withPackageDeclaration(aPackageDeclaration()
					.withName("be.vanpeerdevelopment.eclipse.builder")
					.build())
			.build();

	private CreateCompilationUnitCommandBuilder builder;

	private CreateCompilationUnitCommandTestBuilder() {
		builder = createCompilationUnitCommand();
	}

	public static CreateCompilationUnitCommandTestBuilder aCreateCompilationUnitCommand() {
		return new CreateCompilationUnitCommandTestBuilder()
				.withPackageLocation(DEFAULT_PACKAGE_LOCATION)
				.withCompilationUnit(DEFAULT_COMPILATION_UNIT);
	}

	public CreateCompilationUnitCommand build() {
		return builder.build();
	}

	public CreateCompilationUnitCommandTestBuilder withPackageLocation(IPath packageLocation) {
		builder.withPackageLocation(packageLocation);
		return this;
	}

	public CreateCompilationUnitCommandTestBuilder withCompilationUnit(CompilationUnit compilationUnit) {
		builder.withCompilationUnit(compilationUnit);
		return this;
	}
}