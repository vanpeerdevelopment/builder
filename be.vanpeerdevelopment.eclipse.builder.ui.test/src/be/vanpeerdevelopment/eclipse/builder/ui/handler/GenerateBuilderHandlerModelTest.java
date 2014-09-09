package be.vanpeerdevelopment.eclipse.builder.ui.handler;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.eclipse.core.runtime.IPath;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderService;
import be.vanpeerdevelopment.eclipse.builder.ui.UnitTest;
import be.vanpeerdevelopment.eclipse.builder.ui.handler.GenerateBuilderHandlerModel;
import be.vanpeerdevelopment.eclipse.builder.ui.handler.Workbench;

public class GenerateBuilderHandlerModelTest extends UnitTest {

	@Mock
	private GenerateBuilderService generateBuilderService;
	@Mock
	private Workbench workbench;
	@InjectMocks
	private GenerateBuilderHandlerModel generateBuilderHandlerModel;

	@Mock
	private IPath compilationUnitlocation;

	@Test
	public void generateBuilder_delegatesToGenerateBuilderService() {
		when(workbench.getActiveCompilationUnitLocation()).thenReturn(compilationUnitlocation);

		generateBuilderHandlerModel.generateBuilder();

		verify(generateBuilderService).generateBuilder(compilationUnitlocation);
	}
}