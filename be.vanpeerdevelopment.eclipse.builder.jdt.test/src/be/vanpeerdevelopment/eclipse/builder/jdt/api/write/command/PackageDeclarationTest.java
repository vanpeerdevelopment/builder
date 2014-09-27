package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class PackageDeclarationTest extends UnitTest {

	private static final String PACKAGE_NAME = "be.vanpeerdevelopment.eclipse.builder.packagedeclaration";

	@Test
	public void getName() throws Exception {
		PackageDeclaration packageDeclaration = aPackageDeclaration()
				.withName(PACKAGE_NAME)
				.build();

		String result = packageDeclaration.getName();

		assertThat(result).isEqualTo(PACKAGE_NAME);
	}
}