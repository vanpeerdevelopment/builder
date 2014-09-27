package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder.compilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit.CompilationUnitBuilder;

public class CompilationUnitTestBuilder {

	private static final String DEFAULT_NAME = "Person";

	private CompilationUnitBuilder builder;

	private CompilationUnitTestBuilder() {
		builder = compilationUnit();
	}

	public static CompilationUnitTestBuilder aCompilationUnit() {
		return new CompilationUnitTestBuilder()
				.withName(DEFAULT_NAME);
	}

	public CompilationUnit build() {
		return builder.build();
	}

	public CompilationUnitTestBuilder withName(String name) {
		builder.withName(name);
		return this;
	}
}