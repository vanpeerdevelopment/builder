package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.jdt.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.internal.common.Workspace;

public class JdtReadModelTest extends UnitTest {

	@Mock
	private Workspace workspace;
	@InjectMocks
	private JdtReadModel jdtReadModel;

	@Mock
	private IPath compilationUnitLocation;
	@Mock
	private ReadableCompilationUnit compilationUnit;
	@Mock
	private IPath packageLocation;
	@Mock
	private ReadablePackageFragment packageFragment;

	@Test
	public void getCompilationUnit() {
		when(workspace.getReadableCompilationUnit(compilationUnitLocation)).thenReturn(compilationUnit);

		ReadableCompilationUnit result = jdtReadModel.getCompilationUnit(compilationUnitLocation);

		assertThat(result).isEqualTo(compilationUnit);
	}

	@Test
	public void getPackageFragment() {
		when(workspace.getReadablePackageFragment(packageLocation)).thenReturn(packageFragment);

		ReadablePackageFragment result = jdtReadModel.getPackageFragment(packageLocation);

		assertThat(result).isEqualTo(packageFragment);
	}
}