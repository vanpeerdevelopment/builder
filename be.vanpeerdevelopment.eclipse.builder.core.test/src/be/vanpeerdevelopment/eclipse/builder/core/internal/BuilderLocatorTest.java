package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static org.eclipse.core.runtime.Path.ROOT;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;

public class BuilderLocatorTest extends UnitTest {

	private BuilderLocator builderLocator = new BuilderLocator();

	@Test
	public void getBuilderLocation() {
		IPath destinationPackageLocation = ROOT
				.append("project")
				.append("src")
				.append("be.vanpeerdevelopment.eclipse.builder");
		IPath sourceCompilationUnitLocation = ROOT
				.append("project")
				.append("src")
				.append("be.vanpeerdevelopment.eclipse.builder.person")
				.append("Person.java");

		IPath builderLocation = builderLocator.getBuilderLocation(
				destinationPackageLocation,
				sourceCompilationUnitLocation);

		assertThat(builderLocation).isEqualTo(destinationPackageLocation.append("PersonBuilder.java"));
	}
}