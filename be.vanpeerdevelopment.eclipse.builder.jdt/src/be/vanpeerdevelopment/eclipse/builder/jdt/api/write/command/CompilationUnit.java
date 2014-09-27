package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class CompilationUnit extends ValueObject {

	public static final String JAVA_EXTENSION = ".java";

	private String name;
	private PackageDeclaration packageDeclaration;
	private Type type;

	private CompilationUnit() {
	}

	public String getNameWithExtension() {
		return new StringBuilder(name)
				.append(JAVA_EXTENSION)
				.toString();
	}

	public String toCode() {
		return new StringBuilder()
				.append(packageDeclaration.toCode())
				.append("\n")
				.append(type.toCode())
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

		public CompilationUnitBuilder withPackageDeclaration(PackageDeclaration packageDeclaration) {
			compilationUnit.packageDeclaration = packageDeclaration;
			return this;
		}

		public CompilationUnitBuilder withType(Type type) {
			compilationUnit.type = type;
			return this;
		}
	}
}