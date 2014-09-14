package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write;

import static be.vanpeerdevelopment.eclipse.builder.jdt.IPackageFragmentTestBuilder.anIPackageFragment;
import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand.CreateCompilationUnitCommandBuilder.createCompilationUnitCommand;
import static org.mockito.Mockito.verify;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteException;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class WriteablePackageFragmentTest extends UnitTest {

	private static final String COMPILATION_UNIT_NAME = "CompilationUnitName";

	@Test
	public void createCompilationUnit() throws JavaModelException {
		IPackageFragment packageFragment = anIPackageFragment().build();
		WriteablePackageFragment writeablePackageFragment = new WriteablePackageFragment(packageFragment);
		CreateCompilationUnitCommand command = createCompilationUnitCommand()
				.withName(COMPILATION_UNIT_NAME)
				.build();

		writeablePackageFragment.createCompilationUnit(command);

		verify(packageFragment).createCompilationUnit(
				COMPILATION_UNIT_NAME + ".java",
				"",
				true,
				null);
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
}