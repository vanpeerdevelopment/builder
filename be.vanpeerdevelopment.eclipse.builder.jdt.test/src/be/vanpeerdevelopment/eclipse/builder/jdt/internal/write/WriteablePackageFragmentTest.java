package be.vanpeerdevelopment.eclipse.builder.jdt.internal.write;

import static be.vanpeerdevelopment.eclipse.builder.jdt.element.ICompilationUnitTestBuilder.COMPILATION_UNIT_NAME;
import static be.vanpeerdevelopment.eclipse.builder.jdt.element.IPackageFragmentTestBuilder.anIPackageFragment;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteException;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CompilationUnit;

public class WriteablePackageFragmentTest extends UnitTest {

	private static final String CODE = "code";
	@Mock
	private CompilationUnit compilationUnit;

	@Before
	public void setup() {
		when(compilationUnit.getNameWithExtension()).thenReturn(COMPILATION_UNIT_NAME + ".java");
		when(compilationUnit.toCode()).thenReturn(CODE);
	}

	@Test
	public void createCompilationUnit() throws JavaModelException {
		IPackageFragment packageFragment = anIPackageFragment().build();
		WriteablePackageFragment writeablePackageFragment = new WriteablePackageFragment(packageFragment);

		writeablePackageFragment.createCompilationUnit(compilationUnit);

		verify(packageFragment).createCompilationUnit(
				COMPILATION_UNIT_NAME + ".java",
				CODE,
				true,
				null);
	}

	@Test
	public void createCompilationUnit_WhenFails_ThrowsJdtWriteException() {
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