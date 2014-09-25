package be.vanpeerdevelopment.eclipse.builder.core.api;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderLocator;
import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class GenerateBuilderServiceTest extends UnitTest {

	@Mock
	private BuilderLocator builderLocator;
	@Mock
	private BuilderPatternEngine builderPatternEngine;
	@Mock
	private JdtWriteModel jdtWriteModel;
	@InjectMocks
	private GenerateBuilderService generateBuilderService;

	@Mock
	private GenerateBuilderCommand command;
	@Mock
	private IPath packageLocation;
	@Mock
	private IPath compilationUnitLocation;
	@Mock
	private IPath builderLocation;
	@Mock
	private CreateCompilationUnitCommand createCompilationUnitCommand;

	@Before
	public void setup() {
		when(builderPatternEngine.generateBuilder(command)).thenReturn(createCompilationUnitCommand);
		when(command.getPackageLocation()).thenReturn(packageLocation);
		when(command.getCompilationUnitLocation()).thenReturn(compilationUnitLocation);
		when(builderLocator.getBuilderLocation(packageLocation, compilationUnitLocation))
				.thenReturn(builderLocation);
	}

	@Test
	public void generateBuilder() {
		IPath result = generateBuilderService.generateBuilder(command);

		verify(jdtWriteModel).createCompilationUnit(createCompilationUnitCommand);
		assertThat(result).isEqualTo(builderLocation);
	}
}