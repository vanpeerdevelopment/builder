package be.vanpeerdevelopment.eclipse.builder.core.api;

import static be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderCommandTestBuilder.aGenerateBuilderCommand;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;

public class GenerateBuilderCommandTest extends UnitTest {

	private static final IPath PACKAGE_LOCATION = new Path("/workspace-root/project/source-folder/package");
	private static final IPath COMPILATION_UNIT_LOCATION = new Path(
			"/workspace-root/project/source-folder/package/class.java");

	@Test
	public void getCompilationUnitLocation() {
		GenerateBuilderCommand command = aGenerateBuilderCommand()
				.withCompilationUnitLocation(COMPILATION_UNIT_LOCATION)
				.build();

		assertThat(command.getCompilationUnitLocation()).isEqualTo(COMPILATION_UNIT_LOCATION);
	}

	@Test
	public void getPackageLocation() {
		GenerateBuilderCommand command = aGenerateBuilderCommand()
				.withCompilationUnitLocation(COMPILATION_UNIT_LOCATION)
				.build();

		assertThat(command.getPackageLocation()).isEqualTo(PACKAGE_LOCATION);
	}
}