package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder.compilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder;

public class CompilationUnitTestBuilder {

	private static final String DEFAULT_NAME = "Person";
	private static final PackageDeclaration DEFAULT_PACKAGE_DECLARATION = aPackageDeclaration().build();

	private CompilationUnitBuilder builder;

	private CompilationUnitTestBuilder() {
		builder = compilationUnit();
	}

	public static CompilationUnitTestBuilder aCompilationUnit() {
		return new CompilationUnitTestBuilder()
				.withName(DEFAULT_NAME)
				.withPackageDeclaration(DEFAULT_PACKAGE_DECLARATION);
	}

	public CompilationUnit build() {
		return builder.build();
	}

	public CompilationUnitTestBuilder withName(String name) {
		builder.withName(name);
		return this;
	}

	public CompilationUnitTestBuilder withPackageDeclaration(PackageDeclaration packageDeclaration) {
		builder.withPackageDeclaration(packageDeclaration);
		return this;
	}
}