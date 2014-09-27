package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write;

import static be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnitTestBuilder.aCompilationUnit;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ICompilationUnitTestBuilder.COMPILATION_UNIT_NAME;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.IPackageFragmentTestBuilder.PACKAGE_NAME;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.IPackageFragmentTestBuilder.anIPackageFragment;
import static org.mockito.Mockito.verify;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.junit.Test;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteException;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit;

public class WriteablePackageFragmentTest extends UnitTest {

	@Test
	public void createCompilationUnit() throws JavaModelException {
		CompilationUnit compilationUnit = aCompilationUnit()
				.withName(COMPILATION_UNIT_NAME)
				.build();
		IPackageFragment packageFragment = anIPackageFragment()
				.withName(PACKAGE_NAME)
				.build();
		WriteablePackageFragment writeablePackageFragment = new WriteablePackageFragment(packageFragment);

		writeablePackageFragment.createCompilationUnit(compilationUnit);

		verify(packageFragment).createCompilationUnit(
				COMPILATION_UNIT_NAME + ".java",
				"package " + PACKAGE_NAME + ";",
				true,
				null);
	}

	@Test
	public void createCompilationUnit_WhenFails_ThrowsJdtWriteException() {
		CompilationUnit compilationUnit = aCompilationUnit()
				.withName(COMPILATION_UNIT_NAME)
				.build();
		IPackageFragment packageFragment = anIPackageFragment()
				.withFailingCreateCompilationUnit()
				.build();
		WriteablePackageFragment writeablePackageFragment = new WriteablePackageFragment(packageFragment);

		expectExceptionWithMessage(
				JdtWriteException.class,
				"Something went wrong while creating the following compilation unit: " + COMPILATION_UNIT_NAME
						+ ".java");

		writeablePackageFragment.createCompilationUnit(compilationUnit);
	}
}