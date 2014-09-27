package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclaration.PackageDeclarationBuilder.packageDeclaration;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.IPackageFragmentTestBuilder.PACKAGE_NAME;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclaration.PackageDeclarationBuilder;

public class PackageDeclarationTestBuilder {

	private static final String DEFAULT_NAME = PACKAGE_NAME;

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