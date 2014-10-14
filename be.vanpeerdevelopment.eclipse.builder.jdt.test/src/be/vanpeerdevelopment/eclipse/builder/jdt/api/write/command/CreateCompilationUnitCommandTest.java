package be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnitTestBuilder.aCompilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommandTestBuilder.aCreateCompilationUnitCommand;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.PackageDeclarationTestBuilder.aPackageDeclaration;
import static org.fest.assertions.Assertions.assertThat;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.ValidationException;

public class CreateCompilationUnitCommandTest extends UnitTest {

	@Test
	public void testBuilderCreatesDefaultValidCommand() {
		expectNoException();

		aCreateCompilationUnitCommand().build();
	}

	@Test
	public void whenNoPackageLocation_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Package location is required.");

		aCreateCompilationUnitCommand()
				.withPackageLocation(null)
				.build();
	}

	@Test
	public void whenNoCompilationUnit_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Compilation unit is required.");

		aCreateCompilationUnitCommand()
				.withCompilationUnit(null)
				.build();
	}

	@Test
	public void whenCompilationUnitNotIsInSamePackage_throwsValidationException() {
		expectExceptionWithMessage(
				ValidationException.class,
				"Compilation unit has to be in same package as create compilation unit command.");

		aCreateCompilationUnitCommand()
				.withPackageLocation(new Path("/project/src/be.vanpeerdevelopment.eclipse.builder"))
				.withCompilationUnit(aCompilationUnit()
						.withPackageDeclaration(aPackageDeclaration()
								.withName("be.vanpeerdevelopment.eclipse.builder.subpackage")
								.build())
						.build())
				.build();
	}

	@Test
	public void getPackageLocation() {
		IPath packageLocation = new Path("/project/src/be.vanpeerdevelopment.eclipse.builder");
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withPackageLocation(packageLocation)
				.withCompilationUnit(aCompilationUnit()
						.withPackageDeclaration(aPackageDeclaration()
								.withName("be.vanpeerdevelopment.eclipse.builder")
								.build())
						.build())
				.build();

		IPath result = command.getPackageLocation();

		assertThat(result).isEqualTo(packageLocation);
	}

	@Test
	public void getCompilationUnit() throws Exception {
		CompilationUnit compilationUnit = aCompilationUnit()
				.withPackageDeclaration(aPackageDeclaration()
						.withName("be.vanpeerdevelopment.eclipse.builder")
						.build())
				.build();
		CreateCompilationUnitCommand command = aCreateCompilationUnitCommand()
				.withPackageLocation(new Path("/project/src/be.vanpeerdevelopment.eclipse.builder"))
				.withCompilationUnit(compilationUnit)
				.build();

		CompilationUnit result = command.getCompilationUnit();

		assertThat(result).isEqualTo(compilationUnit);
	}
}