package be.vanpeerdevelopment.eclipse.builder.core.internal;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.JdtReadModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableType;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class BuilderPatternEngineTest extends UnitTest {

	private static final String TYPE_NAME = "Person";

	@Mock
	private JdtReadModel jdtReadModel;
	@InjectMocks
	private BuilderPatternEngine builderPatternEngine;

	private IPath packageLocation = new Path("/workspace-root/project/source-folder/package");
	private IPath compilationUnitLocation = new Path("/workspace-root/project/source-folder/package/class.java");
	@Mock
	private ReadableCompilationUnit compilationUnit;
	@Mock
	private ReadableType type;

	@Test
	public void generateBuilder() {
		when(jdtReadModel.getCompilationUnit(compilationUnitLocation)).thenReturn(compilationUnit);
		when(compilationUnit.getOnlyType()).thenReturn(type);
		when(type.getSimpleName()).thenReturn(TYPE_NAME);

		CreateCompilationUnitCommand command = builderPatternEngine.generateBuilder(compilationUnitLocation);

		assertThat(command.getPackageLocation()).isEqualTo(packageLocation);
		assertThat(command.getName()).isEqualTo(TYPE_NAME + "Builder");
	}
}