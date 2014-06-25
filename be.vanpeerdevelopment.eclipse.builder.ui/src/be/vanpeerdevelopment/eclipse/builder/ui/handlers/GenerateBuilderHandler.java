package be.vanpeerdevelopment.eclipse.builder.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

import be.vanpeerdevelopment.eclipse.builder.core.api.GenerateBuilderServiceFactory;

public class GenerateBuilderHandler extends AbstractHandler {

	private GenerateBuilderHandlerModel generateBuilderHandlerModel;

	public GenerateBuilderHandler() {
		generateBuilderHandlerModel = new GenerateBuilderHandlerModel(
				new GenerateBuilderServiceFactory().createGenerateBuilderService(),
				new Workbench());
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		generateBuilderHandlerModel.generateBuilder();
		return null;
	}
}