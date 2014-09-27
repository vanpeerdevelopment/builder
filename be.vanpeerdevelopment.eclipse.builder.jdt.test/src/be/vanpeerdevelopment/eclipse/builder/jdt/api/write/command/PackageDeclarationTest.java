package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.IPackageFragmentTestBuilder.PACKAGE_NAME;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class PackageDeclarationTest extends UnitTest {

	@Test
	public void toCode() {
		PackageDeclaration packageDeclaration = aPackageDeclaration()
				.withName(PACKAGE_NAME)
				.build();

		String code = packageDeclaration.toCode();

		assertThat(code).isEqualTo("package " + PACKAGE_NAME + ";");
	}
}