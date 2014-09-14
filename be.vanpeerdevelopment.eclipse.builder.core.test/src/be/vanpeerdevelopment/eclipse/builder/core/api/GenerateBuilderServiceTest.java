package be.vanpeerdevelopment.eclipse.builder.core.api;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine;
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

	@Test
	public void generateBuilder() throws Exception {
		when(builderPatternEngine.generateBuilder(command)).thenReturn(createCompilationUnitCommand);

		generateBuilderService.generateBuilder(command);

		verify(jdtWriteModel).createCompilationUnit(createCompilationUnitCommand);
	}
}