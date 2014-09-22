package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder.createCompilationUnitCommand;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ICompilationUnitTestBuilder.anICompilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.IPackageFragmentTestBuilder.anIPackageFragment;
import static org.fest.assertions.Assertions.assertThat;
import static org.fest.reflect.core.Reflection.field;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteException;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class WriteablePackageFragmentTest extends UnitTest {

	private static final String COMPILATION_UNIT_NAME = "CompilationUnitName";

	@Test
	public void createCompilationUnit() throws JavaModelException {
		IPackageFragment packageFragment = anIPackageFragment().build();
		ICompilationUnit compilationUnit = anICompilationUnit().build();
		when(packageFragment
				.createCompilationUnit(
						COMPILATION_UNIT_NAME + ".java",
						"",
						true,
						null))
				.thenReturn(compilationUnit);
		WriteablePackageFragment writeablePackageFragment = new WriteablePackageFragment(packageFragment);
		CreateCompilationUnitCommand command = createCompilationUnitCommand()
				.withName(COMPILATION_UNIT_NAME)
				.build();

		ReadableCompilationUnit readableCompilationUnit = writeablePackageFragment.createCompilationUnit(command);

		verify(packageFragment).createCompilationUnit(
				COMPILATION_UNIT_NAME + ".java",
				"",
				true,
				null);
		assertThat(getICompilationUnit(readableCompilationUnit)).isEqualTo(compilationUnit);
	}

	@Test
	public void createCompilationUnit_WhenFails_ThrowsJdtWriteException() {
		IPackageFragment packageFragment = anIPackageFragment()
				.withFailingCreateCompilationUnit()
				.build();
		WriteablePackageFragment writeablePackageFragment = new WriteablePackageFragment(packageFragment);
		CreateCompilationUnitCommand command = createCompilationUnitCommand()
				.withName(COMPILATION_UNIT_NAME)
				.build();

		expectExceptionWithMessage(
				JdtWriteException.class,
				"Something went wrong while creating the following compilation unit: " + COMPILATION_UNIT_NAME
						+ ".java");

		writeablePackageFragment.createCompilationUnit(command);
	}

	private ICompilationUnit getICompilationUnit(ReadableCompilationUnit readableCompilationUnit) {
		return field("compilationUnit").ofType(ICompilationUnit.class).in(readableCompilationUnit).get();
	}
}