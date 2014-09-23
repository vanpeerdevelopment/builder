package be.vanpeerdevelopment.eclipse.builder.core.api;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.read.ReadableCompilationUnit;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.api.write.command.CreateCompilationUnitCommand;

public class GenerateBuilderServiceTest extends UnitTest {

	@Mock
	private BuilderPatternEngine builderPatternEngine;
	@Mock
	private JdtWriteModel jdtWriteModel;
	@InjectMocks
	private GenerateBuilderService generateBuilderService;

	@Mock
	private GenerateBuilderCommand command;
	@Mock
	private CreateCompilationUnitCommand createCompilationUnitCommand;
	@Mock
	private ReadableCompilationUnit createdBuilder;
	@Mock
	private IPath createdBuilderLocation;

	@Test
	public void generateBuilder() throws Exception {
		when(builderPatternEngine.generateBuilder(command)).thenReturn(createCompilationUnitCommand);
		when(jdtWriteModel.createCompilationUnit(createCompilationUnitCommand)).thenReturn(createdBuilder);
		when(createdBuilder.getPath()).thenReturn(createdBuilderLocation);

		IPath result = generateBuilderService.generateBuilder(command);

		assertThat(result).isEqualTo(createdBuilderLocation);
	}
}