package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.ClassDefinitionTestBuilder.aClassDefinition;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder.compilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ICompilationUnitTestBuilder.COMPILATION_UNIT_NAME;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder;

public class CompilationUnitTestBuilder {

	private static final String DEFAULT_NAME = COMPILATION_UNIT_NAME;
	private static final PackageDeclaration DEFAULT_PACKAGE_DECLARATION = aPackageDeclaration().build();
	private static final ClassDefinition DEFAULT_CLASS_DEFINITION = aClassDefinition().build();

	private CompilationUnitBuilder builder;

	private CompilationUnitTestBuilder() {
		builder = compilationUnit();
	}

	public static CompilationUnitTestBuilder aCompilationUnit() {
		return new CompilationUnitTestBuilder()
				.withName(DEFAULT_NAME)
				.withPackageDeclaration(DEFAULT_PACKAGE_DECLARATION)
				.withClassDefinition(DEFAULT_CLASS_DEFINITION);
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

	public CompilationUnitTestBuilder withClassDefinition(ClassDefinition classDefinition) {
		builder.withClassDefinition(classDefinition);
		return this;
	}
}