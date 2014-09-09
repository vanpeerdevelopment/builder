package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import static org.mockito.Mockito.verify;

import org.eclipse.core.commands.ExecutionEvent;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import be.vanpeerdevelopment.eclipse.builder.ui.UnitTest;

public class GenerateBuilderHandlerTest extends UnitTest {

	@Mock
	private GenerateBuilderHandlerModel generateBuilderHandlerModel;
	@InjectMocks
	private GenerateBuilderHandler generateBuilderHandler;

	@Test
	public void execute() throws Exception {
		ExecutionEvent event = new ExecutionEvent();

		generateBuilderHandler.execute(event);

		verify(generateBuilderHandlerModel).generateBuilder();
	}
}