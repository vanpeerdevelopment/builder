package be.vanpeerdevelopment.eclipse.builder.jdt.api.read;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.reflect.core.Reflection.field;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.eclipse.jdt.core.ICompilationUnit;
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
	private ICompilationUnit compilationUnit;

	@Test
	public void getCompilationUnit() {
		when(workspace.getCompilationUnit(compilationUnitLocation)).thenReturn(compilationUnit);

		ReadableCompilationUnit readableCompilationUnit = jdtReadModel.getCompilationUnit(compilationUnitLocation);

		assertThat(getCompilationUnit(readableCompilationUnit)).isEqualTo(compilationUnit);
	}

	private ICompilationUnit getCompilationUnit(ReadableCompilationUnit readableCompilationUnit) {
		return field("compilationUnit").ofType(ICompilationUnit.class).in(readableCompilationUnit).get();
	}
}