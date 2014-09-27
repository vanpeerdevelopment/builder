package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder.compilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.TypeTestBuilder.aType;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ICompilationUnitTestBuilder.COMPILATION_UNIT_NAME;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder;

public class CompilationUnitTestBuilder {

	private static final String DEFAULT_NAME = COMPILATION_UNIT_NAME;
	private static final PackageDeclaration DEFAULT_PACKAGE_DECLARATION = aPackageDeclaration().build();
	private static final Type DEFAULT_TYPE = aType().build();

	private CompilationUnitBuilder builder;

	private CompilationUnitTestBuilder() {
		builder = compilationUnit();
	}

	public static CompilationUnitTestBuilder aCompilationUnit() {
		return new CompilationUnitTestBuilder()
				.withName(DEFAULT_NAME)
				.withPackageDeclaration(DEFAULT_PACKAGE_DECLARATION)
				.withType(DEFAULT_TYPE);
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

	public CompilationUnitTestBuilder withType(Type type) {
		builder.withType(type);
		return this;
	}
}