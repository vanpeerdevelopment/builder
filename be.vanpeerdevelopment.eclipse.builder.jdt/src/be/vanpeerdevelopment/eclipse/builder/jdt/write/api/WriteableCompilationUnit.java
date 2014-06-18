package be.vanpeerdevelopment.eclipse.builder.jdt.write.api;

public class WriteableCompilationUnit {

	public static final String JAVA_EXTENSION = ".java";
	private String name;

	private WriteableCompilationUnit() {
	}

	public String getName() {
		return name;
	}

	public String getNameWithExtension() {
		return new StringBuilder(name)
				.append(JAVA_EXTENSION)
				.toString();
	}

	public static class WriteableCompilationUnitBuilder {

		private WriteableCompilationUnit compilationUnit;

		private WriteableCompilationUnitBuilder() {
			compilationUnit = new WriteableCompilationUnit();
		}

		public static WriteableCompilationUnitBuilder writeableCompilationUnit() {
			return new WriteableCompilationUnitBuilder();
		}

		public WriteableCompilationUnit build() {
			return compilationUnit;
		}

		public WriteableCompilationUnitBuilder withName(String name) {
			compilationUnit.name = name;
			return this;
		}
	}
}