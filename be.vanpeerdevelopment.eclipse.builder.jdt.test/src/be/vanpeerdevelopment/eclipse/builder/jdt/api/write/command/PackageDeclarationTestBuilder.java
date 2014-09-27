package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclaration.PackageDeclarationBuilder.packageDeclaration;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclaration.PackageDeclarationBuilder;

public class PackageDeclarationTestBuilder {

	private static final String DEFAULT_NAME = "be.vanpeerdevelopment.eclipse.builder";

	private PackageDeclarationBuilder builder;

	private PackageDeclarationTestBuilder() {
		builder = packageDeclaration();
	}

	public static PackageDeclarationTestBuilder aPackageDeclaration() {
		return new PackageDeclarationTestBuilder()
				.withName(DEFAULT_NAME);
	}

	public PackageDeclaration build() {
		return builder.build();
	}

	public PackageDeclarationTestBuilder withName(String name) {
		builder.withName(name);
		return this;
	}
}