package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class PackageDeclaration extends ValueObject {

	private String name;

	private PackageDeclaration() {
	}

	public String getName() {
		return name;
	}

	public String toCode() {
		return new StringBuilder()
				.append("package ")
				.append(name)
				.append(";")
				.toString();
	}

	public static class PackageDeclarationBuilder {

		private PackageDeclaration packageDeclaration;

		private PackageDeclarationBuilder() {
			packageDeclaration = new PackageDeclaration();
		}

		public static PackageDeclarationBuilder packageDeclaration() {
			return new PackageDeclarationBuilder();
		}

		public PackageDeclaration build() {
			return packageDeclaration;
		}

		public PackageDeclarationBuilder withName(String name) {
			packageDeclaration.name = name;
			return this;
		}
	}
}