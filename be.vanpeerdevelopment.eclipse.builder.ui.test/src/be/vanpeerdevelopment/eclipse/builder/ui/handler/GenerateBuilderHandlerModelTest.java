package be.vanpeerdevelopment.eclipse.builder.ui.handler;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderCommand;
import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;
import be.vanpeerdevelopment.eclipse.builder.ui.UnitTest;

public class GenerateBuilderHandlerModelTest extends UnitTest {

	@Mock
	private Workbench workbench;
	@Mock
	private GenerateBuilderService generateBuilderService;
	@InjectMocks
	private GenerateBuilderHandlerModel generateBuilderHandlerModel;

	@Mock
	private IPath compilationUnitLocation;
	@Mock
	private IPath createdBuilderLocation;
	@Captor
	private ArgumentCaptor<GenerateBuilderCommand> commandCaptor;

	@Test
	public void generateBuilder_delegatesToGenerateBuilderService() {
		when(workbench.getActiveCompilationUnitLocation()).thenReturn(compilationUnitLocation);
		when(generateBuilderService.generateBuilder(any(GenerateBuilderCommand.class)))
				.thenReturn(createdBuilderLocation);

		generateBuilderHandlerModel.generateBuilder();

		verify(generateBuilderService).generateBuilder(commandCaptor.capture());
		assertThat(commandCaptor.getValue().getCompilationUnitLocation()).isEqualTo(compilationUnitLocation);
		verify(workbench).openCompilationUnit(createdBuilderLocation);
	}
}