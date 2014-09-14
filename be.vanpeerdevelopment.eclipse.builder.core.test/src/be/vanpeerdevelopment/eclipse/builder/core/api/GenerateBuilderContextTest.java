package be.vanpeerdevelopment.eclipse.builder.core.api;

import static be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderContextTestBuilder.aGenerateBuilderContext;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;

public class GenerateBuilderContextTest extends UnitTest {

	private static final IPath PACKAGE_LOCATION = new Path("/workspace-root/project/source-folder/package");
	private static final IPath COMPILATION_UNIT_LOCATION = new Path(
			"/workspace-root/project/source-folder/package/class.java");

	@Test
	public void getCompilationUnitLocation() {
		GenerateBuilderContext context = aGenerateBuilderContext()
				.withCompilationUnitLocation(COMPILATION_UNIT_LOCATION)
				.build();

		assertThat(context.getCompilationUnitLocation()).isEqualTo(COMPILATION_UNIT_LOCATION);
	}

	@Test
	public void getPackageLocation() {
		GenerateBuilderContext context = aGenerateBuilderContext()
				.withCompilationUnitLocation(COMPILATION_UNIT_LOCATION)
				.build();

		assertThat(context.getPackageLocation()).isEqualTo(PACKAGE_LOCATION);
	}
}