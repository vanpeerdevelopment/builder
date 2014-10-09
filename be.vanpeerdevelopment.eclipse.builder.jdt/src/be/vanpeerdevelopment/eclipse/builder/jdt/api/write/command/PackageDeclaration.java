package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static org.apache.commons.lang3.StringUtils.isBlank;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.ValueObject;

public class PackageDeclaration extends ValueObject {

	private String name;

	private PackageDeclaration() {
	}

	public String toCode() {
		return new StringBuilder()
				.append("package ")
				.append(name)
				.append(";")
				.toString();
	}

	private void validate() {
		if (isBlank(name))
			throw new ValidationException("Name can not be blank.");
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
			packageDeclaration.validate();
			return packageDeclaration;
		}

		public PackageDeclarationBuilder withName(String name) {
			packageDeclaration.name = name;
			return this;
		}
	}
}