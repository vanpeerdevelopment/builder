package be.vanpeerdevelopment.eclipse.builder.core.api;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.core.internal.BuilderPatternEngine;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.JdtWriteModel;
import be.vanpeerdevelopment.eclipse.builder.jdt.write.api.command.CreateCompilationUnitCommand;

public class GenerateBuilderServiceTest extends UnitTest {

	@Mock
	private BuilderPatternEngine builderPatternEngine;
	@Mock
	private JdtWriteModel jdtWriteModel;
	@InjectMocks
	private GenerateBuilderService generateBuilderService;

	@Mock
	private IPath compilationUnitLocation;
	@Mock
	private CreateCompilationUnitCommand command;

	@Test
	public void generateBuilder() throws Exception {
		when(builderPatternEngine.generateBuilder(compilationUnitLocation)).thenReturn(command);

		generateBuilderService.generateBuilder(compilationUnitLocation);

		verify(jdtWriteModel).createCompilationUnit(command);
	}
}