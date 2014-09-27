package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnitTestBuilder.aCompilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommandTestBuilder.aCreateCompilationUnitCommand;
import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;

public class CreateCompilationUnitCommandTest extends UnitTest {

	@Test
	public void getPackageLocation() {
		IPath packageLocation = mock(IPath.class);
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withPackageLocation(packageLocation)
				.build();

		IPath result = command.getPackageLocation();

		assertThat(result).isEqualTo(packageLocation);
	}

	@Test
	public void getCompilationUnit() throws Exception {
		CompilationUnit compilationUnit = aCompilationUnit().build();
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withCompilationUnit(compilationUnit)
				.build();

		CompilationUnit result = command.getCompilationUnit();

		assertThat(result).isEqualTo(compilationUnit);
	}
}