package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

public class GenerateBuilderHandler extends AbstractHandler {

	private GenerateBuilderHandlerModel generateBuilderHandlerModel;

	public GenerateBuilderHandler() {
		generateBuilderHandlerModel = new GenerateBuilderHandlerModel();
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		generateBuilderHandlerModel.generateBuilder();
		return null;
	}
}