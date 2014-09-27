package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class CompilationUnit extends ValueObject {

	public static final String JAVA_EXTENSION = ".java";

	private String name;

	private CompilationUnit() {
	}

	public String getName() {
		return name;
	}

	public String getNameWithExtension() {
		return new StringBuilder(name)
				.append(JAVA_EXTENSION)
				.toString();
	}

	public static class CompilationUnitBuilder {

		private CompilationUnit compilationUnit;

		private CompilationUnitBuilder() {
			compilationUnit = new CompilationUnit();
		}

		public static CompilationUnitBuilder compilationUnit() {
			return new CompilationUnitBuilder();
		}

		public CompilationUnit build() {
			return compilationUnit;
		}

		public CompilationUnitBuilder withName(String name) {
			compilationUnit.name = name;
			return this;
		}
	}
}