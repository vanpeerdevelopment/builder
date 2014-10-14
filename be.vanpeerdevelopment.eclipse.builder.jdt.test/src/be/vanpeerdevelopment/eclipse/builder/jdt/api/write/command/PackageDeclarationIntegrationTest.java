package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import static org.eclipse.core.resources.ResourcesPlugin.getWorkspace;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.junit.Before;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.EclipseTest;

public class PackageDeclarationIntegrationTest extends EclipseTest {

	private IPath packageLocation;

	@Before
	public void setup() {
		packageLocation = getWorkspace()
				.getRoot()
				.getLocation()
				.append(JAVA_PROJECT_NAME)
				.append(JAVA_SOURCE_FOLDER_NAME)
				.append(JAVA_PACKAGE_NAME);
	}

	@Test
	public void isFor_True() {
		PackageDeclaration packageDeclaration = aPackageDeclaration()
				.withName(JAVA_PACKAGE_NAME)
				.build();

		boolean result = packageDeclaration.isFor(packageLocation);

		assertThat(result).isTrue();
	}

	@Test
	public void isFor_False() {
		PackageDeclaration packageDeclaration = aPackageDeclaration()
				.withName(JAVA_PACKAGE_NAME + ".subpackage")
				.build();

		boolean result = packageDeclaration.isFor(packageLocation);

		assertThat(result).isFalse();
	}
}